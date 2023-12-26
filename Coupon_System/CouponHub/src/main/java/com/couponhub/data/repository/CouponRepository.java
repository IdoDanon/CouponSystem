package com.couponhub.data.repository;

import com.couponhub.data.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.*;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Optional<Coupon> findByUuid(UUID uuid);
    Set<Coupon> findAllByCompanyUuid(UUID couponUuid);
    Set<Coupon> findAllByCustomersContains(UUID customerUuid);
}
