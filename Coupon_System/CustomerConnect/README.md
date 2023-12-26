# CustomerConnect Microservice

The CustomerConnect microservice is a component of a larger system designed to manage customer-related operations. This microservice provides a RESTful API for handling customer-related functionalities, such as creating new customers, retrieving customer details, updating customer information, and deleting customer records.

## Table of Contents

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

## Introduction

The CustomerConnect microservice is responsible for managing customer information within a larger system. It is implemented as a Spring Boot application, providing a set of RESTful endpoints for various customer-related operations.

## Endpoints

### 1. New Customer

- **Endpoint:** `POST /api/customers/new`
- **Description:** Create a new customer with the provided information.
- **Request Body:** CustomerDto (Data Transfer Object) containing customer details.
- **Request Header:** Authorization token for user authentication.
- **Response:** Returns the created CustomerDto.

### 2. Customer Details

- **Endpoint:** `GET /api/customers/details`
- **Description:** Retrieve details of the currently authenticated user's customer.
- **Request Header:** Authorization token for user authentication.
- **Response:** Returns the CustomerDto for the authenticated user.

### 3. All Customers

- **Endpoint:** `GET /api/customers/all`
- **Description:** Retrieve details of all customers.
- **Response:** Returns a list of CustomerDto objects representing all customers.

### 4. Update Customer

- **Endpoint:** `PUT /api/customers/update`
- **Description:** Update the details of the currently authenticated user's customer.
- **Request Body:** CustomerDto containing updated details.
- **Request Header:** Authorization token for user authentication.
- **Response:** Returns the updated CustomerDto.

### 5. Delete Customer

- **Endpoint:** `DELETE /api/customers/delete`
- **Description:** Delete the currently authenticated user's customer.
- **Request Header:** Authorization token for user authentication.
- **Response:** Returns a success status if the deletion is successful.

## Authentication

All endpoints require authentication using an Authorization token. The token should be included in the request headers.

## Request and Response Formats

All data is exchanged in JSON format. Request and response bodies follow the structure defined in the `CustomerDto` and `UserDto` classes.

## Error Handling

In case of errors, appropriate HTTP status codes and error messages are returned. Refer to each endpoint description for possible error scenarios.

## Dependencies

The microservice relies on the following dependencies:
- Spring Boot
- Spring Boot Starter Data JPA
- Lombok
- MySQL Driver
- Eureka Client