package com.um.apitest.pizza;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PizzaConfig {

    @Bean
    CommandLineRunner commandLineRunner(PizzaRepository repository)  {
        return args -> {

            Pizza margarita = new Pizza("margarita",true, 6.50);
            Pizza tonno = new Pizza("tonno", false, 8.50);
            Pizza funghi = new Pizza("funghi", true, 8.00);

            repository.saveAll(List.of(margarita, tonno, funghi));
        };
    }
}
