package com.um.apitest.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/order/{customerId}")
    public List<Order> getOrders(@PathVariable("customerId") int customerId) {
        return orderService.getOrders(customerId);
    }

    @PostMapping("/order")
    public ResponseEntity<OrderResponse> submitOrder(@RequestBody OrderPost orderPost) {
        return orderService.submitOrder(orderPost);
    }

    @PutMapping("/order/cancel/{order_id}")
    public ResponseEntity<CancelResponse> cancelOrder(@PathVariable("order_id") int orderId) {
        return orderService.cancelOrder(orderId);
    }



}