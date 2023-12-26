package com.customerconnect.web.dto;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
}
