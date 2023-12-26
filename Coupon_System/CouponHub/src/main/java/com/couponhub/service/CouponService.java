package com.couponhub.service;

import com.couponhub.web.dto.CouponDto;
import com.couponhub.web.dto.UserDto;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface CouponService {
    UserDto getUserByToken(String token);

    CouponDto getCouponByUuid(String token, UUID couponUuid);

    Set<CouponDto> getCouponsOfCompany(UUID companyUuid);

    Set<CouponDto> getCouponsOfCustomer(String token);

    CouponDto purchaseCoupon(String token, UUID couponUuid);

    void deleteCustomer(UUID uuid);
}
