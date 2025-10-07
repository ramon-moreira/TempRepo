package com.devsuperior.desafio1;
import com.devsuperior.desafio1.entities.Order;
import com.devsuperior.desafio1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(Desafio1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Order order = new Order(1034, 150.0, 20.0);
        double total = orderService.total(order);
        System.out.printf("Pedido código %d Valor total: R$ %.2f%n", order.getCode(), total);
    }
}