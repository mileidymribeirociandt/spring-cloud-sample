package br.com.desafio.restapipagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiPagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPagamentoApplication.class, args);
	}

}
