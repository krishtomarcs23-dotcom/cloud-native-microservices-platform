# Cloud-Native Microservices Platform

A cloud-native microservices-based backend system built using **Spring Boot**, **Spring Security (JWT)**, and **Maven**.  
Each microservice is independently developed, secured, and packaged following industry best practices.

---

## 🧩 Microservices Overview

| Service | Description |
|------|------------|
| **Order Service** | Manages orders, pricing, and order lifecycle |
| **Customer Service** | Manages customer data and authentication |
| **Product Service** | _(Planned)_ Manages product catalog |

---

## 📂 Repository Structure

```text
cloud-native-microservices-platform/
│
├── order-service/
│   ├── src/
│   ├── pom.xml
│   └── README.md
│
├── customer-service/
│   ├── src/
│   ├── pom.xml
│   └── README.md
│
├── docs/
│   └── architecture.md
│
├── .gitignore
└── README.md


## 📂 Source Code Structure

```text
order-service/
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── krish/
        │           └── cloud/
        │               └── order/
        │                   ├── OrderServiceApplication.java
        │                   │
        │                   ├── controller/
        │                   │   └── OrderController.java
        │                   │
        │                   ├── service/
        │                   │   └── OrderService.java
        │                   │
        │                   ├── repository/
        │                   │   └── OrderRepository.java
        │                   │
        │                   ├── entity/
        │                   │   └── Order.java
        │                   │
        │                   ├── dto/
        │                   │   └── OrderRequestDto.java
        │                   │
        │                   └── security/
        │                       ├── JwtAuthenticationFilter.java
        │                       ├── JwtUtil.java
        │                       └── SecurityConfig.java
        │
        └── resources/
            ├── application.yml
            └── application.properties


### 📌 Layer Responsibilities
- **controller** → REST APIs
- **service** → Business logic
- **repository** → Database access (JPA)
- **entity** → Database models
- **dto** → API request/response objects
- **security** → JWT & Spring Security config

---

## ✅ customer-service — FULL `src` STRUCTURE

Put this in **`customer-service/README.md`**

```markdown
## 📂 Source Code Structure

```text
customer-service/
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── krish/
        │           └── cloud/
        │               └── customer/
        │                   ├── CustomerServiceApplication.java
        │                   │
        │                   ├── controller/
        │                   │   └── CustomerController.java
        │                   │
        │                   ├── service/
        │                   │   └── CustomerService.java
        │                   │
        │                   ├── repository/
        │                   │   └── CustomerRepository.java
        │                   │
        │                   ├── entity/
        │                   │   └── Customer.java
        │                   │
        │                   ├── dto/
        │                   │   ├── LoginRequestDto.java
        │                   │   └── CustomerResponseDto.java
        │                   │
        │                   └── security/
        │                       ├── JwtAuthenticationFilter.java
        │                       ├── JwtUtil.java
        │                       └── SecurityConfig.java
        │
        └── resources/
            ├── application.yml
            └── application.properties
