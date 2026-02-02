package com.krish.cloud.order.client;

import com.krish.cloud.order.dto.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${product.service.url}")
    private String productServiceUrl;

    public ProductResponseDTO getProduct(Long productId) {
        return restTemplate.getForObject(
                productServiceUrl + "/api/products/" + productId,
                ProductResponseDTO.class
        );
    }

    public void updateStock(Long productId, int newStock) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String body = """
            {
              "stock": %d
            }
            """.formatted(newStock);

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        restTemplate.exchange(
                productServiceUrl + "/api/products/" + productId + "/stock",
                HttpMethod.PUT,
                entity,
                Void.class
        );
    }
}
