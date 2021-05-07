package com.um.apitest.database;

import com.um.apitest.order.Order;

import java.time.LocalDate;
import java.util.List;

public class OrderRepository {

    private static List<Order> orderList = List.of(
            new Order(1, 1, "delivered", LocalDate.now(), true, "address"),
            new Order(2, 2, "delivered", LocalDate.now(), true, "address2"),
            new Order(3, 2, "in progress", LocalDate.now(), true, "address2"),
            new Order(4, 1, "in progress", LocalDate.now(), true, "address"));

    public static List<Order> getOrderList() {
        return orderList;
    }
}
