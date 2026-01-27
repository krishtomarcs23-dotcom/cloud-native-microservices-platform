package com.krish.cloud.order.service;

import com.krish.cloud.order.dto.OrderRequestDTO;
import com.krish.cloud.order.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {

    OrderResponseDTO createOrder(OrderRequestDTO request);

    List<OrderResponseDTO> getAllOrders();

    OrderResponseDTO getOrderById(Long id);

    OrderResponseDTO updateOrder(Long id, OrderRequestDTO request);

    void deleteOrder(Long id);
}