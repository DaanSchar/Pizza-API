package com.um.apitest;

import com.um.apitest.order.Order;
import com.um.apitest.pizza.Pizza;

import java.time.LocalDate;
import java.util.List;

public class DataBase {

    public static List<Order> PizzaOrderData() {
        Order order1 = new Order(1, "in progress", LocalDate.now(),true, "address");
        Order order2 = new Order(1, "in progress", LocalDate.now(),true,"address");
        Order order3 = new Order(2, "in progress", LocalDate.now(),true,"address");

        return List.of(order1, order2, order3);
    }

    public static List<Pizza> PizzaData() {
        Pizza margarita = new Pizza(1,"margarita",true, 6.50);
        Pizza tonno = new Pizza(2,"tonno", false, 8.50);
        Pizza funghi = new Pizza(3,"funghi", true, 8.00);

        return List.of(margarita, tonno, funghi);
    }


}
