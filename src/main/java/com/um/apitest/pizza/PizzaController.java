package com.um.apitest.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    /**
     * @return list containing all pizza types
     */
    @GetMapping("/pizza")
    public List<Pizza> getAllPizzas() {
        return pizzaService.getPizzas();
    }

    /**
     * @param pizzaId int to identify a specific pizza type
     * @return corresponding pizza of that pizzaId as it is received from the PizzaService class
     */
    @GetMapping("/pizza/{pizzaId}")
    public Pizza getPizza(@PathVariable("pizzaId") int pizzaId) {
        return pizzaService.getPizza(pizzaId);
    }
}
