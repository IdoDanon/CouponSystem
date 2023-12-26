package com.couponhub.mapper;

import com.couponhub.data.entity.Coupon;
import com.couponhub.web.dto.CouponDto;
import org.springframework.stereotype.Component;

@Component
public class CouponMapperImpl implements CouponMapper {
    @Override
    public Coupon toEntity(CouponDto dto) {
        return Coupon.builder()
                .uuid(dto.getUuid())
                .companyUuid(dto.getCompanyUuid())
                .category(dto.getCategory())
                .title(dto.getTitle())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .amount(dto.getAmount())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .customers(dto.getCustomers())
                .build();
    }

    @Override
    public CouponDto toDto(Coupon entity) {
        return CouponDto.builder()
                .uuid(entity.getUuid())
                .companyUuid(entity.getCompanyUuid())
                .category(entity.getCategory())
                .title(entity.getTitle())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .amount(entity.getAmount())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .imageUrl(entity.getImageUrl())
                .customers(entity.getCustomers())
                .build();
    }
}
