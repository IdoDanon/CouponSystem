package com.couponhub.web.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouponDto {
    private UUID uuid;
    private UUID companyUuid;
    private int category;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private int amount;
    private String description;
    private double price;
    private String imageUrl;
    private Set<UUID> customers;
}
