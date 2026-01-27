## Current Progress
- Customer Service: Authentication & JWT generation
- Order Service: JWT validation & protected APIs
- Stateless security using Spring Security
- H2 + JPA integration
C:\USERS\KRISH\DOCUMENTS\CLOUD-NATIVE-MICROSERVICES-PLATFORM\CUSTOMER-SERVICE\SRC\MAIN\JAVA
└───com
    └───krish
        └───cloud
            └───customer
                │   CustomerServiceApplication.java
                │
                ├───config
                ├───controller
                │       AuthController.java
                │       CustomerController.java
                │       TestController.java
                │
                ├───dto
                │       LoginRequest.java
                │
                ├───entity
                │       Customer.java
                │
                ├───exception
                │       CustomerNotFoundException.java
                │       GlobalExceptionHandler.java
                │
                ├───repository
                │       CustomerRepository.java
                │
                ├───security
                │       JwtFilter.java
                │       JwtUtil.java
                │       SecurityConfig.java
                │
                └───service
  C:\USERS\KRISH\DOCUMENTS\CLOUD-NATIVE-MICROSERVICES-PLATFORM\ORDER-SERVICE\SRC\MAIN\JAVA
└───com
    └───krish
        └───cloud
            └───order
                │   OrderServiceApplication.java
                │
                ├───controller
                │       OrderController.java
                │
                ├───dto
                │       OrderRequestDTO.java
                │       OrderResponseDTO.java
                │
                ├───entity
                │       Order.java
                │
                ├───exception
                │       GlobalExceptionHandler.java
                │       OrderNotFoundException.java
                │
                ├───repository
                │       OrderRepository.java
                │
                ├───security
                │       JwtAuthenticationFilter.java
                │       JwtUtil.java
                │       SecurityConfig.java
                │
                └───service
                    │   OrderService.java
                    │
                    └───impl
                            OrderServiceImpl.java
                        CustomerService.java
