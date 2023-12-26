package com.customerconnect.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
public class UserDto {
    private String username;
    private UUID uuid;
}
