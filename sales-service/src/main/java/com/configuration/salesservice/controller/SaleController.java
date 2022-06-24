package com.configuration.salesservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuration.salesservice.service.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {
    
    @Autowired
    private SaleService saleService;

    @GetMapping("/{cantity}")
    public ResponseEntity<?> getSale(@PathVariable Integer cantity) {
        return new ResponseEntity<>(
            saleService.getSale(cantity),
            HttpStatus.OK);
    }

}
