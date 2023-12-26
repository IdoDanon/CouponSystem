package com.customerconnect.service;

import com.customerconnect.data.entity.Customer;
import com.customerconnect.data.repository.CustomerRepository;
import com.customerconnect.mapper.CustomerMapper;
import com.customerconnect.service.ex.CustomerAlreadyExistException;
import com.customerconnect.service.ex.CustomerNotFoundException;
import com.customerconnect.service.ex.EmailAlreadyExistException;
import com.customerconnect.service.ex.UserNotFoundException;
import com.customerconnect.web.dto.CustomerDto;
import com.customerconnect.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final String authUrlParseToken;
    private final RestTemplate restTemplate;
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerServiceImpl(@Value("${auth.url.parse-token}") String authUrlParseToken,
                               RestTemplate restTemplate,
                               CustomerRepository repository,
                               CustomerMapper mapper) {
        this.authUrlParseToken = authUrlParseToken;
        this.restTemplate = restTemplate;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CustomerDto newCustomer(CustomerDto customerDto, UUID uuid) {
        if (repository.findByUuid(uuid).isPresent()) {
            throw new CustomerAlreadyExistException("Customer already exist");
        }

        if (repository.findByEmail(customerDto.getEmail()).isPresent()) {
            throw new EmailAlreadyExistException("Email already exist");
        }

        customerDto.setUuid(uuid);
        repository.save(mapper.toEntity(customerDto));
        return customerDto;
    }

    @Override
    public CustomerDto getCustomerByUuid(UUID uuid) {
        return mapper.toDto(repository.findByUuid(uuid)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found!")));
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public CustomerDto updateFirstAndLastName(UUID uuid, CustomerDto customerDto) {
        Customer customer = repository.findByUuid(uuid)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());

        return mapper.toDto(repository.save(customer));
    }

    @Override
    public boolean deleteCustomer(UUID uuid) {
        Optional<Customer> optCustomer = repository.findByUuid(uuid);
        if (optCustomer.isEmpty()) {
            return false;
        }
        repository.delete(optCustomer.get());

        restTemplate.exchange(
                "http://coupon-hub/api/coupons/delete-customer/" + uuid,
                HttpMethod.DELETE,
                new HttpEntity<>(uuid),
                UUID.class);
        return true;
    }

    @Override
    public UserDto getUserByToken(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);

        return Optional.ofNullable(restTemplate.exchange(
                                authUrlParseToken,
                                HttpMethod.GET,
                                new HttpEntity<>(headers),
                                UserDto.class)
                        .getBody())
                .orElseThrow(() -> new UserNotFoundException("User not found!"));

    }
}
