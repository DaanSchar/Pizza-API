package com.um.apitest.order;

import com.um.apitest.order.util.Address;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pizza_order")
public class PizzaOrder {

    @Id
    @SequenceGenerator(name = "pizza_order_sequence", sequenceName = "pizza_order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pizza_order_sequence")

    private int id;
    private int customerId;
    private String status;
    private LocalDate orderedAt;
    private boolean takeAway;
    private Address deliveryAddress;

    public PizzaOrder(int id, int customerId, String status, LocalDate orderedAt, boolean takeAway, Address deliveryAddress) {
        this.id = id;
        this.customerId = customerId;
        this.status = status;
        this.orderedAt = orderedAt;
        this.takeAway = takeAway;
        this.deliveryAddress = deliveryAddress;
    }

    public PizzaOrder(int customerId, String status, LocalDate orderedAt, boolean takeAway, Address deliveryAddress) {
        this.customerId = customerId;
        this.status = status;
        this.orderedAt = orderedAt;
        this.takeAway = takeAway;
        this.deliveryAddress = deliveryAddress;
    }

    public PizzaOrder(){}

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

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
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

