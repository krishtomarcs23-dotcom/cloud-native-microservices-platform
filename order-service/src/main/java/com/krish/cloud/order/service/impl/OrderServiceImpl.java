package com.krish.cloud.order.service.impl;

import com.krish.cloud.order.client.ProductClient;
import com.krish.cloud.order.dto.OrderRequestDTO;
import com.krish.cloud.order.dto.OrderResponseDTO;
import com.krish.cloud.order.dto.ProductResponseDTO;
import com.krish.cloud.order.entity.Order;
import com.krish.cloud.order.repository.OrderRepository;
import com.krish.cloud.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    // ✅ CREATE ORDER
    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO request) {

        ProductResponseDTO product =
                productClient.getProduct(request.getProductId());

        if (product.getStock() < request.getQuantity()) {
            throw new RuntimeException("Insufficient stock");
        }

        int updatedStock = product.getStock() - request.getQuantity();
        productClient.updateStock(product.getId(), updatedStock);

        Order order = new Order();
        order.setProductName(product.getName());
        order.setQuantity(request.getQuantity());
        order.setPrice(product.getPrice());

        order = orderRepository.save(order);

        return new OrderResponseDTO(
                order.getId(),
                order.getProductName(),
                order.getQuantity(),
                order.getPrice()
        );
    }

    // ✅ GET ALL ORDERS
    @Override
    public List<OrderResponseDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(o -> new OrderResponseDTO(
                        o.getId(),
                        o.getProductName(),
                        o.getQuantity(),
                        o.getPrice()))
                .toList();
    }

    // ✅ GET ORDER BY ID
    @Override
    public OrderResponseDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return new OrderResponseDTO(
                order.getId(),
                order.getProductName(),
                order.getQuantity(),
                order.getPrice()
        );
    }

    // ✅ UPDATE ORDER (basic version)
    @Override
    public OrderResponseDTO updateOrder(Long id, OrderRequestDTO request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setQuantity(request.getQuantity());
        order = orderRepository.save(order);

        return new OrderResponseDTO(
                order.getId(),
                order.getProductName(),
                order.getQuantity(),
                order.getPrice()
        );
    }

    // ✅ DELETE ORDER
    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
