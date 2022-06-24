package com.configuration.salesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configuration.salesservice.model.Product;
import com.configuration.salesservice.model.Sale;
import com.configuration.salesservice.repository.SaleRepository;

@Service
public class SaleService {
    
    @Autowired
    private SaleRepository saleRepository;

    public Sale getSale(Integer cantity) {
        Product product = saleRepository.getProduct();
        
        Sale sale = new Sale(
            product.getName(),
            product.getPrice(),
            cantity,
            product.getPrice() * cantity);

        return sale;
    }

}
