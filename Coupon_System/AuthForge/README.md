# AuthForge Authentication

The AuthForge Authentication is responsible for handling user authentication and authorization processes within the AuthForge microservice. It exposes endpoints for user signup, login, and token parsing.

## Table of Contents

1. [Introduction](#introduction)
2. [Endpoints](#endpoints)
    - [1. Sign Up](#1-sign-up)
    - [2. Login](#2-login)
    - [3. Parse Token](#3-parse-token)
3. [Exception Handling](#exception-handling)
4. [Dependencies](#dependencies)

## Introduction

The AuthForge Authentication Controller provides a set of RESTful endpoints for user authentication and authorization. It interacts with the AuthForgeService to handle signup, login, and token parsing functionalities.

## Endpoints

### 1. Sign Up

- **Endpoint:** `POST /sign-up`
- **Description:** Register a new user with the provided username and password.
- **Request Body:** SignUpRequest containing username and password.
- **Response:** Returns a success status if the signup is successful.

### 2. Login

- **Endpoint:** `POST /login`
- **Description:** Authenticate a user and generate an authentication token.
- **Request Body:** LoginRequest containing username and password.
- **Response:** Returns the generated authentication token.

### 3. Parse Token

- **Endpoint:** `GET /parse-token`
- **Description:** Parse the provided authentication token and retrieve user details.
- **Request Header:** Authorization token for user authentication.
- **Response:** Returns the UserDto containing user details.

## Exception Handling

- **AuthException:** Thrown during the login process if authentication fails.

## Dependencies

The microservice relies on the following dependencies:
- Spring Boot
- Spring Boot Starter Data JPA
- Lombok
- MySQL Driver
- Eureka Client
