package com.configuration.salesserviceultimate.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sales")
@RefreshScope
@Slf4j
public class SaleController {
    
    @Autowired
    private Environment environment;

    @Value("${com.nubox.url}")
    private String url;

    @EventListener({
        ApplicationReadyEvent.class,
        RefreshScopeRefreshedEvent.class
    })
    public void onEvent() {
        log.info("onEvent: {}", environment.getProperty("com.nubox.url"));
    }
    /*
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("ApplicationReadyEvent: {}", event);
    }
    */

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
