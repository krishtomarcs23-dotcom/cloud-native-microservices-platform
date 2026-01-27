package com.krish.cloud.customer.controller;

import com.krish.cloud.customer.dto.LoginRequest;
import com.krish.cloud.customer.entity.Customer;
import com.krish.cloud.customer.security.JwtUtil;
import com.krish.cloud.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final JwtUtil jwtUtil;   // ✅ FIELD EXISTS

    public CustomerController(CustomerService customerService, JwtUtil jwtUtil) {
        this.customerService = customerService;
        this.jwtUtil = jwtUtil;      // ✅ ASSIGNED
    }

    // 🔐 LOGIN (JWT GENERATION)
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        customerService.validateCustomer(request.getEmail());
        return jwtUtil.generateToken(request.getEmail());
    }

    // CREATE
    @PostMapping
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    // READ ALL
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Customer updateCustomer(
            @PathVariable Long id,
            @RequestBody Customer customer
    ) {
        return customerService.updateCustomer(id, customer);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}