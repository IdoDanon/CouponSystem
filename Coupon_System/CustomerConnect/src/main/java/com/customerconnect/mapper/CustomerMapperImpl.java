package com.customerconnect.mapper;

import com.customerconnect.data.entity.Customer;
import com.customerconnect.web.dto.CustomerDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public Customer toEntity(CustomerDto dto) {
        return Customer.builder()
                .uuid(dto.getUuid())
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
    }

    @Override
    public CustomerDto toDto(Customer entity) {
        return CustomerDto.builder()
                .uuid(entity.getUuid())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
    }
}
