package com.configuration.salesserviceultimate.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RefreshScope
@RestController
@RequestMapping("/sales")
@Slf4j
public class SaleController {
    
    @Autowired
    private Environment environment;

    @Value("${com.nubox.url}")
    private String url;

    @GetMapping("/config")
    public ResponseEntity<?> getProperty(@Value("${server.port}") String port) {
        log.info("url: {}", url);
        log.info("port: {}", port);
        
        log.info("profile: {}", environment.getActiveProfiles()[0]);

        Map<String, String> map = new HashMap<>();
            map.put("url", url);
            map.put("port", port);
        
        return new ResponseEntity<>(
            map,
            HttpStatus.OK);
    }

}
