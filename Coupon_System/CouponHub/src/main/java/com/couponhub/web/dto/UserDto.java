package com.couponhub.web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private String username;
    private UUID uuid;
}
