package com.um.apitest.order;

import com.um.apitest.order.util.Address;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PizzaOrderConfig {


    @Bean
    CommandLineRunner commandLineRunnerOrder(PizzaOrderRepository repository) {
        return args -> {
            // new Address("MelkwegStraat", "Eindhoven","Netherlands","1234AB")
            PizzaOrder order1 = new PizzaOrder(1, "in progress", LocalDate.now(),true, new Address("street", "city", "country", "zipcode"));
            PizzaOrder order2 = new PizzaOrder(1, "in progress", LocalDate.now(),true, new Address("street", "city", "country", "zipcode"));
            PizzaOrder order3 = new PizzaOrder(2, "in progress", LocalDate.now(),true, new Address("street", "city", "country", "zipcode"));



            repository.saveAll(List.of(order1, order2,order3));
        };

    }


}
