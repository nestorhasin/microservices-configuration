package com.configuration.salesservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.configuration.salesservice.model.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Repository
@AllArgsConstructor
@Getter
@Setter
public class SaleRepository {
    
    @Autowired
    private final RestTemplate restTemplate;

    public Product getProduct() {
        return restTemplate.getForObject(
            "http://localhost:8081/products",
            Product.class
        );
    }

}
