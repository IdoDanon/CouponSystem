package com.couponhub.web.controller;

import com.couponhub.service.CouponService;
import com.couponhub.web.dto.CouponDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coupons")
public class CouponController {
    private final CouponService service;

    @GetMapping("/{couponUuid}")
    public ResponseEntity<CouponDto> getCouponByUuid(@RequestHeader("Authorization") String token,
                                                     @PathVariable UUID couponUuid) {
        return ResponseEntity.ok(service.getCouponByUuid(token, couponUuid));
    }

    @GetMapping("/customer")
    public ResponseEntity<Set<CouponDto>> getCustomerCoupons(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(service.getCouponsOfCustomer(token));
    }

    @GetMapping("/company/{companyUuid}")
    public ResponseEntity<Set<CouponDto>> getCompanyCoupons(@PathVariable UUID companyUuid) {
        return ResponseEntity.ok(service.getCouponsOfCompany(companyUuid));
    }

    @PostMapping("/purchase/{couponUuid}")
    public ResponseEntity<CouponDto> purchaseCoupon(@RequestHeader("Authorization") String token,
                                                    @PathVariable UUID couponUuid) {
        return ResponseEntity.ok(service.purchaseCoupon(token, couponUuid));
    }

    @DeleteMapping("/delete-customer/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable UUID uuid) {
        service.deleteCustomer(uuid);
    }
}
