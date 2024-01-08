package org.cortesrmzcau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class SpringSecurity6Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity6Application.class, args);
	}

}
