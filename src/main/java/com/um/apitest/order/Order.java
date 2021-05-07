package com.um.apitest.order;

import java.time.LocalDate;

public class Order {

    private int id;
    private int customerId;
    private String status;
    private LocalDate orderedAt;
    private boolean takeAway;
    private String deliveryAddress;

    /**
     * TODO: fix address type and add pizza list
     */

    public Order(int id, int customerId, String status, LocalDate orderedAt, boolean takeAway, String deliveryAddress) {
        this.id = id;
        this.customerId = customerId;
        this.status = status;
        this.orderedAt = orderedAt;
        this.takeAway = takeAway;
        this.deliveryAddress = deliveryAddress;
    }

    public Order(int customerId, String status, LocalDate orderedAt, boolean takeAway, String deliveryAddress) {
        this.customerId = customerId;
        this.status = status;
        this.orderedAt = orderedAt;
        this.takeAway = takeAway;
        this.deliveryAddress = deliveryAddress;
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

    public LocalDate getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(LocalDate orderedAt) {
        this.orderedAt = orderedAt;
    }

    public boolean isTakeAway() {
        return takeAway;
    }

    public void setTakeAway(boolean takeAway) {
        this.takeAway = takeAway;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
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

