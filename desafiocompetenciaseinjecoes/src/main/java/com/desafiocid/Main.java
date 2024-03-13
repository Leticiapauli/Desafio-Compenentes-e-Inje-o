package com.desafiocid;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desafiocid.entities.Order;
import com.desafiocid.services.OrderService;

@SpringBootApplication
public class Main implements CommandLineRunner{
    //Injeção de dependência
    @Autowired
    private OrderService orderService;

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        Locale.setDefault(Locale.US);

        Order order = new Order(1034, 150.00, 20.0);
        System.out.println("Order code: " + order.getCode());
        System.out.printf("Total value: %.2f%n ", orderService.total(order));
    }
}