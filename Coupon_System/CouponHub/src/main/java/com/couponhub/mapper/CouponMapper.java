package com.couponhub.mapper;

import com.couponhub.data.entity.Coupon;
import com.couponhub.web.dto.CouponDto;

public interface CouponMapper {
    Coupon toEntity(CouponDto dto);
    CouponDto toDto(Coupon entity);
}
