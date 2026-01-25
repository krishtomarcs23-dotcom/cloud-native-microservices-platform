package com.krish.cloud.customer.controller;


import jakarta.validation.Valid;
import com.krish.cloud.customer.entity.Customer;
import com.krish.cloud.customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
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