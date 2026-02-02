package com.krish.cloud.product.service;


import com.krish.cloud.product.entity.Product;
import com.krish.cloud.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product product) {
        return repository.save(product);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    // ✅ FIXED
    public Product getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Product not found with id " + id
                        )
                );
    }

    // ✅ FIXED
    public void updateStock(Long id, int stock) {
        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Product not found with id " + id
                        )
                );

        product.setStock(stock);
        repository.save(product);
    }
}
