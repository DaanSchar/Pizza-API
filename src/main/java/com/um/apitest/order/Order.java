package com.um.apitest.order;

import com.um.apitest.order.util.Address;
import com.um.apitest.pizza.Pizza;

import java.util.Date;
import java.util.List;

public class Order {

    private int order_id;
    private int customer_id;
    private String status;
    private Date ordered_at;
    private String note;
    private boolean takeAway;
    private String payment_type;
    private Address delivery_address;
    private List<Pizza> pizzas;

    public Order(int order_id, int customer_id, String status, Date ordered_at, boolean takeAway, String payment_type, Address delivery_address, List<Pizza> pizzas) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.status = status;
        this.ordered_at = ordered_at;
        this.takeAway = takeAway;
        this.payment_type = payment_type;
        this.delivery_address = delivery_address;
        this.pizzas = pizzas;
    }

    public Order(){}

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrdered_at() {
        return (Date) ordered_at.clone();
    }

    public void setOrdered_at(Date ordered_at) {
        this.ordered_at = ordered_at;
    }

    public boolean isTakeAway() {
        return takeAway;
    }

    public void setTakeAway(boolean takeAway) {
        this.takeAway = takeAway;
    }

    public Address getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(Address delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + order_id +
                ", customerId=" + customer_id +
                ", status='" + status + '\'' +
                ", orderedAt=" + ordered_at +
                ", takeAway=" + takeAway +
                ", deliveryAddress=" + delivery_address +
                '}';
    }
}

