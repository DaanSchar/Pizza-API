package com.um.apitest.pizza;

import com.um.apitest.database.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    public PizzaService(){}

    /**
     * @return all available pizzas from the pizza database
     */
    public List<Pizza> getPizzas() {
        return PizzaRepository.getPizzaList();
    }

    /**
     * @param pizzaId int to identify a specific pizza type
     * @return corresponding pizza of that pizzaId as it retrieved from the pizza database
     */
    public Pizza getPizza(int pizzaId) {

        //TODO: add message 404: "pizza not found"

        List<Pizza> pizzaList = getPizzas();

        for (int i = 0; i < pizzaList.size(); i++)
            if (pizzaList.get(i).getId() == pizzaId)
                return pizzaList.get(i);

        throw new IllegalStateException("Pizza with id "  + pizzaId + " does not exist");
    }

}
