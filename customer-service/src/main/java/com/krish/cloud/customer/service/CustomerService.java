package com.krish.cloud.customer.service;

import com.krish.cloud.customer.entity.Customer;
import com.krish.cloud.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import com.krish.cloud.customer.exception.CustomerNotFoundException;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
	
	public Customer updateCustomer(Long id, Customer updatedCustomer) {
    Customer existingCustomer = getCustomerById(id);

    existingCustomer.setName(updatedCustomer.getName());
    existingCustomer.setEmail(updatedCustomer.getEmail());
    existingCustomer.setPhone(updatedCustomer.getPhone());

    return customerRepository.save(existingCustomer);
}
public void validateCustomer(String email) {
    customerRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Customer not found"));
}

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

   public Customer getCustomerById(Long id) {
return customerRepository.findById(id)
.orElseThrow(() ->
new CustomerNotFoundException("Customer not found with id " + id)
);
}

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}