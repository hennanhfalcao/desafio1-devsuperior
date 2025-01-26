package com.devsuperior.desafio1;

import com.devsuperior.desafio1.entities.Order;
import com.devsuperior.desafio1.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o código do pedido: ");
		Integer code = sc.nextInt();
		System.out.print("Digite o valor básico do pedido: ");
		double basic = sc.nextDouble();
		System.out.print("Digite a porcentagem de desconto: ");
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);
		double total = orderService.total(order);
		System.out.printf("Pedido código %d%n", code);
		System.out.printf("Valor total: R$ %.2f%n", total);

		sc.close();
	}
}
