package com.krish.cloud.order.dto;

public class OrderResponseDTO {

    private Long id;
    private String productName;
    private int quantity;
    private double price;

    public OrderResponseDTO(Long id, String productName, int quantity, double price) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}