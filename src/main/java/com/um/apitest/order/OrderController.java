package com.um.apitest.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public List<Order> getAllPizzaOrders() {
        return orderService.getAllPizzaOrders();
    }

    @GetMapping("/order/{customerId}")
    public List<Order> getPizzaOrders(@PathVariable("customerId") int customerId) {
        return orderService.getPizzaOrders(customerId);
    }

}