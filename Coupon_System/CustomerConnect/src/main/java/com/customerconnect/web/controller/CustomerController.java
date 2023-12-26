package com.customerconnect.web.controller;

import com.customerconnect.service.CustomerService;
import com.customerconnect.web.dto.CustomerDto;
import com.customerconnect.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;

    @PostMapping("/new")
    public ResponseEntity<CustomerDto> newCustomer(@RequestBody CustomerDto customerDto,
                                                @RequestHeader("Authorization") String token) {
        UserDto userDto = service.getUserByToken(token);
        return ResponseEntity.ok(service.newCustomer(customerDto, userDto.getUuid()));
    }

    @GetMapping("/details")
    public ResponseEntity<CustomerDto> getCustomerDetails(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(service.getCustomerByUuid(service.getUserByToken(token).getUuid()));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDto> updateFirstAndLastName(@RequestHeader("Authorization") String token,
                                                              @RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(service.updateFirstAndLastName(service.getUserByToken(token).getUuid(), customerDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCustomer(@RequestHeader("Authorization") String token) {
        if (service.deleteCustomer(service.getUserByToken(token).getUuid())) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}