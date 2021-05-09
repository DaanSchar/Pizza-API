package com.um.apitest.database;

import com.um.apitest.order.Order;
import com.um.apitest.order.util.Address;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private static List<Order> orderList;

    public static void init() {
        orderList = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            orderList.add(new Order(1, 1, "delivered", sdf.parse("2021-05-02 12:54:34"), true,"Debit", new Address("MelkwegStraat", "Eindhoven", "Netherlands","6123AB") ,List.of(PizzaRepository.getPizza(1))));
            orderList.add(new Order(2, 2, "delivered", sdf.parse("2021-05-02 18:32:28"), true,"Debit",  new Address("Hollederweg", "Maastricht", "Netherlands","6233BC"), List.of(PizzaRepository.getPizza(2))));
            orderList.add(new Order(3, 2, "delivered",sdf.parse("2021-05-04 17:48:01"), true,"Debit",  new Address("Hollederweg", "Maastricht", "Netherlands","6233BC"), List.of(PizzaRepository.getPizza(3))));
            orderList.add(new Order(4, 1, "delivered", sdf.parse("2021-05-05 20:23:21"), true,"Debit",  new Address("MelkwegStraat", "Eindhoven", "Netherlands","6123AB"), List.of(PizzaRepository.getPizza(3))));
        }
        catch (ParseException e) { e.printStackTrace(); }
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    public static void insert(Order order) {
        orderList.add(order);
    }
}
