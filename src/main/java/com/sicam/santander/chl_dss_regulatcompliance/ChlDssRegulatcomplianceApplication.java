package com.sicam.santander.chl_dss_regulatcompliance;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Banco Santander REST API Documentation",
				description = "Banco Santander microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Dev Cristopher Vergara",
						email = "cristopher.vergara@imagemaker.com",
						url = "https://banco.santander.cl/personas"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.linkedin.com/in/cristophervergaracolombo/"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "Visita mi GitHub",
				url = "https://github.com/colombo1986"
		)
)
public class ChlDssRegulatcomplianceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChlDssRegulatcomplianceApplication.class, args);


	}

}
