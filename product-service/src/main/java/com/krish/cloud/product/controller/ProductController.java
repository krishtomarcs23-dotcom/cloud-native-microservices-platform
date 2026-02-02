package com.krish.cloud.product.controller;

import com.krish.cloud.product.entity.Product;
import com.krish.cloud.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.create(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        // 404 handled by ProductService
        return service.getById(id);
    }

    // used by order-service
    @PutMapping("/{id}/stock")
    public ResponseEntity<Void> updateStock(
            @PathVariable Long id,
            @RequestBody Map<String, Integer> body
    ) {
        service.updateStock(id, body.get("stock"));
        return ResponseEntity.ok().build();
    }
}
