package com.configuration.configserverultimate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerUltimateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerUltimateApplication.class, args);
	}

}
