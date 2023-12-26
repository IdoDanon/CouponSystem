package com.couponhub.service;

import com.couponhub.data.entity.Coupon;
import com.couponhub.data.repository.CouponRepository;
import com.couponhub.mapper.CouponMapper;
import com.couponhub.service.ex.*;
import com.couponhub.web.dto.CouponDto;
import com.couponhub.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CouponServiceImpl implements CouponService {
    private final String authUrlParseToken;
    private final RestTemplate restTemplate;
    private final CouponRepository repository;
    private final CouponMapper mapper;

    public CouponServiceImpl(@Value("${auth.url.parse-token}") String authUrlParseToken,
                             RestTemplate restTemplate,
                             CouponRepository repository,
                             CouponMapper mapper) {
        this.authUrlParseToken = authUrlParseToken;
        this.restTemplate = restTemplate;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDto getUserByToken(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);

        return Optional.ofNullable(restTemplate.exchange(
                                authUrlParseToken,
                                HttpMethod.GET,
                                new HttpEntity<>(headers),
                                UserDto.class)
                        .getBody())
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    @Override
    public CouponDto getCouponByUuid(String token, UUID couponUuid) {
        getUserByToken(token);

        return mapper.toDto(repository.findByUuid(couponUuid)
                .orElseThrow(() -> new CouponNotFoundException("Coupon not found!")));
    }

    @Override
    public Set<CouponDto> getCouponsOfCompany(UUID companyUuid) {
        return repository.findAllByCompanyUuid(companyUuid).stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());

    }

    public Set<CouponDto> getCouponsOfCustomer(String token) {
        UUID customerUuid = getUserByToken(token).getUuid();

        return repository.findAllByCustomersContains(customerUuid).stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public CouponDto purchaseCoupon(String token, UUID couponUuid) {
        UserDto userDto = getUserByToken(token);

        Coupon coupon = repository.findByUuid(couponUuid)
                .orElseThrow(() -> new CouponNotFoundException("Coupon not found!"));

        if (repository.findAllByCustomersContains(userDto.getUuid()).contains(coupon)) {
            throw new CouponAlreadyPurchasedException("You already have this coupon!");
        }

        if (coupon.getEndDate().isBefore(LocalDate.now())) {
            throw new CouponExpiredException("This coupon has been expired");
        }

        if (coupon.getAmount() <= 0) {
            throw new CouponOutOfStockException("This coupon is out of stock");
        }

        coupon.getCustomers().add(userDto.getUuid());
        coupon.setAmount(coupon.getAmount() - 1);
        return mapper.toDto(repository.save(coupon));
    }

    @Override
    public void deleteCustomer(UUID customerUuid) {
        Set<Coupon> coupons = repository.findAllByCustomersContains(customerUuid);
        coupons.forEach(c -> c.getCustomers().removeIf(uuid -> uuid.equals(customerUuid)));
        repository.saveAll(coupons);
    }
}
