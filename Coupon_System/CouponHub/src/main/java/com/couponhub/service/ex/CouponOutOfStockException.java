package com.couponhub.service.ex;

public class CouponOutOfStockException extends RuntimeException {
    public CouponOutOfStockException(String message) {
        super(message);
    }
}
