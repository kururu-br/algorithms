package br.com.edson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AlgorithmsDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgorithmsDiscoveryServiceApplication.class, args);
	}

}
