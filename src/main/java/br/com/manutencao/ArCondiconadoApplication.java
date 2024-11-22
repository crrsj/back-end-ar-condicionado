package br.com.manutencao;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API - Sistema de Assistência de Ar-Condicionado",
				version = "1.0",
				description = "Documentando uma API para um sistema de assistência para ar-condicionado",
				contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
)
public class ArCondiconadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArCondiconadoApplication.class, args);
	}

}
