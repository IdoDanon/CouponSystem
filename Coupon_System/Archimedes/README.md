# Unified App README

This README provides an overview and documentation for the microservices that collectively constitute the Unified App. Each microservice focuses on specific functionalities within the larger system.

## Microservices Overview

1. [AuthForge Authentication](#authforge-authentication)
2. [CouponHub Microservice](#couponhub-microservice)
3. [CustomerConnect Microservice](#customerconnect-microservice)
4. [RouteLocator Microservice](#routelocator-microservice)

---

## AuthForge Authentication

The AuthForge Authentication microservice handles user authentication and authorization processes. It exposes endpoints for user signup, login, and token parsing.

### Getting Started

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/#build-image)
- [Eureka Server](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#spring-cloud-eureka-server)

### Guides

- [Service Registration and Discovery with Eureka and Spring Cloud](https://spring.io/guides/gs/service-registration-and-discovery/)

---

## CouponHub Microservice

The CouponHub microservice manages coupon-related operations, providing a RESTful API for retrieving coupons, purchasing coupons, and managing customer and company-specific coupons.

### Table of Contents

1. [Introduction](#introduction)
2. [Endpoints](#endpoints)
    - [1. Get Coupon By UUID](#1-get-coupon)
    - [2. Get Customer Coupons](#2-get-customer-coupons)
    - [3. Get Company Coupons](#3-get-company-coupons)
    - [4. Purchase Coupon](#4-purchase-coupon)
    - [5. Delete Customer](#5-delete-customer)
3. [Authentication](#authentication)
4. [Request and Response Formats](#request-and-response-formats)
5. [Dependencies](#dependencies)

### Introduction

The CouponHub microservice provides functionality related to coupon management within a larger system. It leverages Spring Boot to implement a RESTful API and relies on various endpoints to perform coupon-specific operations.

### Endpoints

#### 1. Get Coupon By UUID

- **Endpoint:** `GET /api/coupons/{couponUuid}`
- **Description:** Retrieve details of a coupon by its UUID.
- **Request Header:** Authorization token for user authentication.
- **Path Variable:** `couponUuid` - UUID of the coupon.
- **Response:** Returns the CouponDto for the specified coupon.

#### 2. Get Customer Coupons

- **Endpoint:** `GET /api/coupons/customer`
- **Description:** Retrieve all coupons associated with the authenticated customer.
- **Request Header:** Authorization token for user authentication.
- **Response:** Returns a set of CouponDto objects representing customer-specific coupons.

#### 3. Get Company Coupons

- **Endpoint:** `GET /api/coupons/company/{companyUuid}`
- **Description:** Retrieve all coupons associated with a specific company.
- **Path Variable:** `companyUuid` - UUID of the company.
- **Response:** Returns a set of CouponDto objects representing company-specific coupons.

#### 4. Purchase Coupon

- **Endpoint:** `POST /api/coupons/purchase/{couponUuid}`
- **Description:** Purchase a coupon by its UUID.
- **Request Header:** Authorization token for user authentication.
- **Path Variable:** `couponUuid` - UUID of the coupon to be purchased.
- **Response:** Returns the purchased CouponDto.

#### 5. Delete Customer

- **Endpoint:** `DELETE /api/coupons/delete-customer/{uuid}`
- **Description:** Delete a customer by their UUID.
- **Path Variable:** `uuid` - UUID of the customer to be deleted.

### Authentication

All endpoints require authentication using an Authorization token. The token should be included in the request headers.

### Request and Response Formats

All data is exchanged in JSON format. Request and response bodies follow the structure defined in the `CouponDto` class.

### Dependencies

The microservice relies on the following dependencies:
- Spring Boot
- Spring Boot Starter Data JPA
- Lombok
- MySQL Driver
- Eureka Client

---

## CustomerConnect Microservice

The CustomerConnect microservice manages customer-related operations, providing a RESTful API for creating, retrieving, updating, and deleting customer records.

### Table of Contents

1. [Introduction](#introduction)
2. [Endpoints](#endpoints)
    - [1. New Customer](#1-new-customer)
    - [2. Customer Details](#2-customer-details)
    - [3. All Customers](#3-all-customers)
    - [4. Update Customer](#4-update-customer)
    - [5. Delete Customer](#5-delete-customer)
3. [Authentication](#authentication)
4. [Request and Response Formats](#request-and-response-formats)
5. [Error Handling](#error-handling)
6. [Dependencies](#dependencies)

### Introduction

The CustomerConnect microservice is responsible for managing customer information within a larger system. It is implemented as a Spring Boot application, providing a set of RESTful endpoints for various customer-related operations.

### Endpoints

#### 1. New Customer

- **Endpoint:** `POST /api/customers/new`
- **Description:** Create a new customer with the provided information.
- **Request Body:** CustomerDto (Data Transfer Object) containing customer details.
- **Request Header:** Authorization token for user authentication.
- **Response:** Returns the created CustomerDto.

#### 2. Customer Details

- **Endpoint:** `GET /api/customers/details`
- **Description:** Retrieve details of the currently authenticated user's customer.
- **Request Header:** Authorization token for user authentication.
- **Response:** Returns the CustomerDto for the authenticated user.

#### 3. All Customers

- **Endpoint:** `GET /api/customers/all`
- **Description:** Retrieve details of all customers.
- **Response:** Returns a list of CustomerDto objects representing all customers.

#### 4. Update Customer

- **Endpoint:** `PUT /api/customers/update`
- **Description:** Update the details of the currently authenticated user's customer.
- **Request Body:** CustomerDto containing updated details.
- **Request Header:** Authorization token for user authentication.
- **Response:** Returns the updated CustomerDto.

#### 5. Delete Customer

- **Endpoint:** `DELETE /api/customers/delete`
- **Description:** Delete the currently authenticated user's customer.
- **Request Header:** Authorization token for user authentication.
- **Response:** Returns a success status if the deletion is successful.

### Authentication

All endpoints require authentication using an Authorization token. The token should be included in the request headers.

### Request and Response Formats

All data is exchanged in JSON format. Request and response bodies follow the structure defined in the `CustomerDto` and `UserDto` classes.

### Error Handling

In case of errors, appropriate HTTP status codes and error messages are returned. Refer to each endpoint description for possible error scenarios.

### Dependencies

The microservice relies on the following dependencies:
- Spring Boot
- Spring Boot Starter Data JPA
- Lombok
- MySQL
