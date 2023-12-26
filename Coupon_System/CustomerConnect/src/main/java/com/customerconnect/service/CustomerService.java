package com.customerconnect.service;

import com.customerconnect.web.dto.CustomerDto;
import com.customerconnect.web.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerDto newCustomer(CustomerDto customerDto, UUID uuid);

    UserDto getUserByToken(String token);

    CustomerDto getCustomerByUuid(UUID uuid);

    List<CustomerDto> getAllCustomers();

    CustomerDto updateFirstAndLastName(UUID uuid, CustomerDto customerDto);

    boolean deleteCustomer(UUID uuid);
}
