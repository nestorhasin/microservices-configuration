package com.configuration.salesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.configuration.salesservice.model.Product;
import com.configuration.salesservice.model.Sale;
import com.configuration.salesservice.repository.ProductRepositoryOpenFeign;

public class SaleServiceOpenFeign{

    @Autowired
    private ProductRepositoryOpenFeign productRepositoryOpenFeign;

    public Sale getSale(Integer cantity) {
        ResponseEntity<?> response = productRepositoryOpenFeign.getProduct();
        Product product = (Product)response.getBody();
        
        Sale sale = new Sale(
            product.getName(),
            product.getPrice(),
            cantity,
            product.getPrice() * cantity);

        return sale;
    }
    
}
