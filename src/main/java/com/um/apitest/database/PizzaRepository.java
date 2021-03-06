package com.um.apitest.database;

import com.um.apitest.pizza.Pizza;

import java.util.List;

public class PizzaRepository {

    private static List<Pizza> pizzaList = List.of(
            new Pizza(1,"margarita",true, 6.50, new String[]{"Basil"}),
            new Pizza(2,"tonno", false, 8.50, new String[]{"Tuna"}),
            new Pizza(3,"funghi", true, 8.00, new String[]{"Mushrooms"}));


    public static List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public static Pizza getPizza(int pizzaId) {

        for (int i = 0; i < pizzaList.size(); i++)
            if (pizzaList.get(i).getPizza_id() == pizzaId)
                return pizzaList.get(i);

        throw new IllegalStateException("Pizza with id " + pizzaId + " does not exist");
    }

}
