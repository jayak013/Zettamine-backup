package com.zettamine.mat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(title = "MATERIAL MODULE APP",
							description = "MATERIAL MANAGEMENT APPLICATION",
							version = "v2",
							contact = @Contact(
									name = "jaya krishna",
									email = "jaya@gmail.com",
									url = "https://www.google.com"),
							license = @License(name = "ZETTA 2.0",
							url = "https://www.zettamine.com")),
							externalDocs = @ExternalDocumentation(
									description = "MATERIAL APP REST API DOCUMENTATION",
									url = "http://localhost:8080/swagger-ui/index.html"))
public class MaterialMatcharsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaterialMatcharsApplication.class, args);
	}

}
