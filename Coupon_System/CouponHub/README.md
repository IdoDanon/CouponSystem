# CouponHub Microservice

The CouponHub microservice is a part of a larger system designed to manage coupon-related operations. This microservice exposes a RESTful API to handle various coupon functionalities, including retrieving coupons by UUID, getting customer-specific coupons, obtaining company-specific coupons, purchasing coupons, and deleting customer records.

## Table of Contents

1. [Introduction](#introduction)
2. [Endpoints](#endpoints)
    - [1. Get Coupon By UUID](#1-get-coupon-by-uuid)
    - [2. Get Customer Coupons](#2-get-customer-coupons)
    - [3. Get Company Coupons](#3-get-company-coupons)
    - [4. Purchase Coupon](#4-purchase-coupon)
    - [5. Delete Customer](#5-delete-customer)
3. [Authentication](#authentication)
4. [Request and Response Formats](#request-and-response-formats)
5. [Dependencies](#dependencies)

## Introduction

The CouponHub microservice provides functionality related to coupon management within a larger system. It leverages Spring Boot to implement a RESTful API and relies on various endpoints to perform coupon-specific operations.

## Endpoints

### 1. Get Coupon By UUID

- **Endpoint:** `GET /api/coupons/{couponUuid}`
- **Description:** Retrieve details of a coupon by its UUID.
- **Request Header:** Authorization token for user authentication.
- **Path Variable:** `couponUuid` - UUID of the coupon.
- **Response:** Returns the CouponDto for the specified coupon.

### 2. Get Customer Coupons

- **Endpoint:** `GET /api/coupons/customer`
- **Description:** Retrieve all coupons associated with the authenticated customer.
- **Request Header:** Authorization token for user authentication.
- **Response:** Returns a set of CouponDto objects representing customer-specific coupons.

### 3. Get Company Coupons

- **Endpoint:** `GET /api/coupons/company/{companyUuid}`
- **Description:** Retrieve all coupons associated with a specific company.
- **Path Variable:** `companyUuid` - UUID of the company.
- **Response:** Returns a set of CouponDto objects representing company-specific coupons.

### 4. Purchase Coupon

- **Endpoint:** `POST /api/coupons/purchase/{couponUuid}`
- **Description:** Purchase a coupon by its UUID.
- **Request Header:** Authorization token for user authentication.
- **Path Variable:** `couponUuid` - UUID of the coupon to be purchased.
- **Response:** Returns the purchased CouponDto.

### 5. Delete Customer

- **Endpoint:** `DELETE /api/coupons/delete-customer/{uuid}`
- **Description:** Delete a customer by their UUID.
- **Path Variable:** `uuid` - UUID of the customer to be deleted.

## Authentication

All endpoints require authentication using an Authorization token. The token should be included in the request headers.

## Request and Response Formats

All data is exchanged in JSON format. Request and response bodies follow the structure defined in the `CouponDto` class.

## Dependencies

The microservice relies on the following dependencies:
- Spring Boot
- Spring Boot Starter Data JPA
- Lombok
- MySQL Driver
- Eureka Client
