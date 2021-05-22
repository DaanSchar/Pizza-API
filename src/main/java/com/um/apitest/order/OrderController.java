package com.um.apitest.order;

import com.um.apitest.order.post.OrderPost;
import com.um.apitest.order.response.CancelResponse;
import com.um.apitest.order.response.OrderResponse;
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

    @GetMapping("/order/{orderId}")
    public ResponseEntity getOrders(@PathVariable("orderId") int orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/order/deliverytime/{order_id}")
    public ResponseEntity getDeliveryTime(@PathVariable("order_id") int orderId) {
        return orderService.getDeliveryTime(orderId);
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