package com.configuration.productsservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuration.productsservice.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @GetMapping
    public ResponseEntity<?> getProduct() {
        Product product = new Product("name", "description", 2);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


}
