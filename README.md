# Spring Boot Microservices with Feign, Eureka, and Ribbon

This project demonstrates a simple microservices architecture using **Spring Boot**, **Spring Cloud**, and **OpenFeign** for inter-service communication, with **Ribbon** for client-side load balancing and **Eureka** for service discovery.

---

## 🛠 Tech Stack

- **Spring Boot 3.3.0**
- **Spring Cloud 2023.0.1**
- **H2 In-Memory Database**
- **Spring Cloud OpenFeign**
- **Eureka Naming Server**
- **Ribbon (Client-Side Load Balancer)**

---

## 📦 Services Overview

### 1. `currency-exchange-service`
- Provides exchange rate data
- Stores exchange values in an H2 in-memory database
- Registers itself with Eureka

### 2. `currency-conversion-service`
- Calls `currency-exchange-service` using Feign Client
- Converts an amount based on exchange rate
- Uses Ribbon for load balancing across multiple instances
- Registers itself with Eureka

---

## 🧭 Service Communication Flow

```text
Client Request → currency-conversion-service
                → Feign Client
                  → Eureka (service lookup)
                    → Ribbon (choose instance)
                      → currency-exchange-service
