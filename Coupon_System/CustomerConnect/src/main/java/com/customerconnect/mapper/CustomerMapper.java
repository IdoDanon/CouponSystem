package com.customerconnect.mapper;

import com.customerconnect.data.entity.Customer;
import com.customerconnect.web.dto.CustomerDto;

public interface CustomerMapper {
    Customer toEntity(CustomerDto dto);
    CustomerDto toDto(Customer entity);

}
