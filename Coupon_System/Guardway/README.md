# RouteLocator Microservice

The RouteLocator microservice is responsible for managing and configuring routes for a Gateway service. It utilizes Spring Cloud Gateway to define and map routes to downstream services.

## Table of Contents

1. [Introduction](#introduction)
2. [Route Configuration](#route-configuration)
    - [1. Get Coupon By UUID](#1-get-coupon-by-uuid)
    - [2. Get Customer Coupons](#2-get-customer-coupons)
    - [3. Get Company Coupons](#3-get-company-coupons)
    - [4. Purchase Coupon](#4-purchase-coupon)
    - [5. New Customer](#5-new-customer)
    - [6. Customer Details](#6-customer-details)
    - [7. All Customers](#7-all-customers)
    - [8. Update Customer Details](#8-update-customer-details)
    - [9. Delete Customer](#9-delete-customer)
3. [Dependencies](#dependencies)

## Introduction

The RouteLocator microservice utilizes Spring Cloud Gateway to define and manage routes for various downstream services. It allows for the effective handling of HTTP requests by routing them to the appropriate services based on specific path patterns.

## Route Configuration

### 1. Get Coupon By UUID

- **Path Pattern:** `/coupon/**`
- **Rewrite From:** `/coupon/(?<uuid>.*)`
- **Rewrite To:** `/api/coupons/${uuid}`
- **Destination Service:** `coupon-hub`

### 2. Get Customer Coupons

- **Path Pattern:** `/coupon/customer`
- **Rewrite From:** `/coupon/customer`
- **Rewrite To:** `/api/coupons/customer`
- **Destination Service:** `coupon-hub`

### 3. Get Company Coupons

- **Path Pattern:** `/coupon/company/**`
- **Rewrite From:** `/coupon/company/(?<uuid>.*)`
- **Rewrite To:** `/api/coupons/company/${uuid}`
- **Destination Service:** `coupon-hub`

### 4. Purchase Coupon

- **Path Pattern:** `/coupon/purchase/**`
- **Rewrite From:** `/coupon/purchase(?<uuid>.*)`
- **Rewrite To:** `/api/coupons/purchase/${uuid}`
- **Destination Service:** `coupon-hub`

### 5. New Customer

- **Path Pattern:** `/customer/new`
- **Rewrite From:** `/customer/new`
- **Rewrite To:** `/api/customers/new`
- **Destination Service:** `customer-connect`

### 6. Customer Details

- **Path Pattern:** `/customer/details`
- **Rewrite From:** `/customer/details`
- **Rewrite To:** `/api/customers/details`
- **Destination Service:** `customer-connect`

### 7. All Customers

- **Path Pattern:** `/customers/all`
- **Rewrite From:** `/customers/all`
- **Rewrite To:** `/api/customers/all`
- **Destination Service:** `customer-connect`

### 8. Update Customer Details

- **Path Pattern:** `/customer/update`
- **Rewrite From:** `/customer/update`
- **Rewrite To:** `/api/customers/update`
- **Destination Service:** `customer-connect`

### 9. Delete Customer

- **Path Pattern:** `/customer/delete`
- **Rewrite From:** `/customer/update`
- **Rewrite To:** `/api/customers/delete`
- **Destination Service:** `customer-connect`

## Dependencies

The microservice relies on the following dependencies:
- Spring Cloud Gateway
