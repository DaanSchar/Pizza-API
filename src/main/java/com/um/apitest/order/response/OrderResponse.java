package com.um.apitest.order.response;

import com.um.apitest.order.Order;

import java.util.Date;

public class OrderResponse {
    private Order order;
    private Date ordered_at;
    private Date delivery_time;

    public OrderResponse(Order order, Date delivery_time) {
        this.order = order;
        this.ordered_at = order.getOrderedAt();
        this.delivery_time = delivery_time;
    }

    public OrderResponse() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getOrdered_at() {
        return ordered_at;
    }

    public void setOrdered_at(Date ordered_at) {
        this.ordered_at = ordered_at;
    }

    public Date getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(Date delivery_time) {
        this.delivery_time = delivery_time;
    }

    public String toString() {
        return "OrderResponse{" +
                "order=" + order +
                ", ordered_at='" + ordered_at + '\'' +
                ", delivery_time='" + delivery_time + '\'' +
                '}';
    }
}
