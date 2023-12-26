package com.guardway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GateWayRouteConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("couponByUuid", triggerLBCouponHub("/coupon/**", "/coupon/(?<uuid>.*)", "/api/coupons/${uuid}"))
                .route("couponCustomerRoute", triggerLBCouponHub("/coupon/customer", "/coupon/customer", "/api/coupons/customer"))
                .route("couponCompanyRoute", triggerLBCouponHub("/coupon/company/**", "/coupon/company/(?<uuid>.*)", "/api/coupons/company/${uuid}"))
                .route("purchaseCoupon", triggerLBCouponHub("/coupon/purchase/**", "/coupon/purchase(?<uuid>.*)", "/api/coupons/purchase/${uuid}"))
                .route("newCustomer", triggerLBCustomerConnect("/customer/new", "/customer/new", "/api/customers/new"))
                .route("customerDetails", triggerLBCustomerConnect("/customer/details", "/customer/details", "/api/customers/details"))
                .route("allCustomers", triggerLBCustomerConnect("/customers/all", "/customers/all", "/api/customers/all"))
                .route("updateDetails", triggerLBCustomerConnect("/customer/update", "/customer/update", "/api/customers/update"))
                .route("deleteCustomer", triggerLBCustomerConnect("/customer/update", "/customer/update", "/api/customers/delete"))
                .build();
    }

    private static Function<PredicateSpec, Buildable<Route>> triggerLBCouponHub(String path, String from, String to) {
        return r -> r.path(path)
                .filters(f -> f.rewritePath(from, to))
                .uri("lb://coupon-hub");
    }

    private static Function<PredicateSpec, Buildable<Route>> triggerLBCustomerConnect(String path, String from, String to) {
        return r -> r.path(path)
                .filters(f -> f.rewritePath(from, to))
                .uri("lb://customer-connect");
    }
}
