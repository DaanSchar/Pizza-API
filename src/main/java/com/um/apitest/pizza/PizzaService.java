package com.um.apitest.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    /**
     * @return all available pizzas from the pizza database
     */
    public List<Pizza> getPizzas() {
        return pizzaRepository.findAll();
    }

    /**
     * @param pizzaId long to identify a specific pizza type
     * @return corresponding pizza of that pizzaId as it retrieved from the pizza database
     */
    public Pizza getPizza(long pizzaId) {
        boolean exists = pizzaRepository.existsById(pizzaId);

        if (!exists) {
            throw new IllegalStateException("Pizza with id "  + pizzaId + "does not exist");
        }
        Optional<Pizza> optionalPizza = pizzaRepository.findById(pizzaId);
        return optionalPizza.get();
    }

}
