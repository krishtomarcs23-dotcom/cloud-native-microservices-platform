package com.krish.cloud.order.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Reference to Customer Service (NOT a DB relationship)
    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private String status; // CREATED, PAID, SHIPPED

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // 🔹 JPA requires a no-args constructor
    protected Order() {
    }

    // 🔹 Convenience constructor
    public Order(Long customerId, Double totalAmount, String status) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }

    // 🔹 Getters & setters
    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}