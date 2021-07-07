package com.adesoes.gerenciamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProjetoEstagioAdesoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoEstagioAdesoesApplication.class, args);
	}

}
