package com.configuration.salesservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuration.salesservice.service.SaleService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sales")
@Slf4j
public class SaleController {
    
    @Autowired
    private SaleService saleService;

    @Value("${com.nubox.url}")
    private String url;

    @GetMapping("/{cantity}")
    public ResponseEntity<?> getSale(@PathVariable Integer cantity) {
        return new ResponseEntity<>(
            saleService.getSale(cantity),
            HttpStatus.OK);
    }

    @GetMapping("/config")
    public ResponseEntity<?> getUrl(@Value("${server.port}") String port) {
        log.info("url: {}", url);
        log.info("port: {}", port);
        
        Map<String, String> map = new HashMap<>();
            map.put("url", url);
            map.put("port", port);
        
        return new ResponseEntity<>(
            map,
            HttpStatus.OK);
    }

}
