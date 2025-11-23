package com.eazybytes.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.eazybytes.loans.dto.LoansContactInfoDto;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {LoansContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Loans micrioservice REST API Documentation",
				description = "EazyBank loans microservices REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Siva",
						email = "siva@gmail.com",
						url = "https:url.com"
						),
				license = @License(
						name = "Apche 2.0",
						url = "sample"
						)
				),
		externalDocs = @ExternalDocumentation(
				description = "EazyBank Loans microservice REST API Documentation",
				url = "sample url"
				)
		
		)

public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
