package com.configuration.salesservice.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "products-service", url = "http://localhost:8081/products")
public interface ProductRepositoryOpenFeign {
    
    @GetMapping
    public ResponseEntity<?> getProduct();

}
