package com.um.apitest.order;

import com.um.apitest.order.util.Address;
import com.um.apitest.pizza.Pizza;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

public class Order {

    private int id;
    private int customerId;
    private String status;
    private Date orderedAt;
    private boolean takeAway;
    private String paymentType;
    private Address deliveryAddress;
    private List<Pizza> pizzas;

    public Order(int id, int customerId, String status, Date orderedAt, boolean takeAway, String paymentType, Address deliveryAddress, List<Pizza> pizzas) {
        this.id = id;
        this.customerId = customerId;
        this.status = status;
        this.orderedAt = orderedAt;
        this.takeAway = takeAway;
        this.paymentType = paymentType;
        this.deliveryAddress = deliveryAddress;
        this.pizzas = pizzas;
    }

    public Order(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }

    public boolean isTakeAway() {
        return takeAway;
    }

    public void setTakeAway(boolean takeAway) {
        this.takeAway = takeAway;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", status='" + status + '\'' +
                ", orderedAt=" + orderedAt +
                ", takeAway=" + takeAway +
                ", deliveryAddress=" + deliveryAddress +
                '}';
    }
}

