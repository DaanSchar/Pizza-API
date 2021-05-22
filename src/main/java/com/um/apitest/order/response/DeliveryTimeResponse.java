package com.um.apitest.order.response;

import com.um.apitest.order.Order;

import java.util.Date;

public class DeliveryTimeResponse {

    private Order order;
    private Date deliveryTime;

    public DeliveryTimeResponse(Order order, Date deliveryTime) {
        this.order = order;
        this.deliveryTime = deliveryTime;
    }

    public DeliveryTimeResponse() {}

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
