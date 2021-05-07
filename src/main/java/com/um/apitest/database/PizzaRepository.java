package com.um.apitest.database;

import com.um.apitest.pizza.Pizza;

import java.util.List;

public class PizzaRepository {

    private static List<Pizza> pizzaList = List.of(
            new Pizza(1,"margarita",true, 6.50),
            new Pizza(2,"tonno", false, 8.50),
            new Pizza(3,"funghi", true, 8.00));


    public static List<Pizza> getPizzaList() {
        return pizzaList;
    }

}
