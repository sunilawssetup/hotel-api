package com.app.hotel;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "HOTEL-API",
				description = "This is hotel api",
				version = "V1",
				contact = @Contact(
						name = "Sunil Mane",
				email = "manesunil069@gmail.com",
				url = "/hotel-api"
		)
				,
				license = @License(
						name = "Apache",
						url = "www.swiggy.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				url = "https://localhost:9091/swagger-ui/index.html",
				description ="this is hotel api"
		)
)
public class HotelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApiApplication.class, args);
	}

}
