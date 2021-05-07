package com.um.apitest.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class PizzaOrderController {

    private final PizzaOrderService pizzaOrderService;

    public PizzaOrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @GetMapping("/order")
    public List<PizzaOrder> getAllPizzaOrders() {
        return pizzaOrderService.getAllPizzaOrders();
    }

    @GetMapping("/order/{customerId}")
    public List<PizzaOrder> getPizzaOrders(@PathVariable("customerId") int customerId) {
        return pizzaOrderService.getPizzaOrders(customerId);
    }

}