package io.daniel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IgUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgUserServiceApplication.class, args);
	}

}
