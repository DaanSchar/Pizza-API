package com.um.apitest.order.post;

import com.um.apitest.order.util.Address;

import java.util.List;

public class OrderPost {

    private List<Integer> pizzas;
    private boolean takeaway;
    private String payment_type;
    private int customer_id;
    private String note;
    private Address delivery_address;

    public OrderPost(List<Integer> pizzas, boolean takeaway, String payment_type, int customerId, Address delivery_address) {
        this.pizzas = pizzas;
        this.takeaway = takeaway;
        this.payment_type = payment_type;
        this.customer_id = customerId;
        this.delivery_address = delivery_address;
    }

    public OrderPost(){}

    public List<Integer> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Integer> pizzas) {
        this.pizzas = pizzas;
    }

    public boolean getTakeaway() {
        return takeaway;
    }

    public void setTakeaway(boolean takeaway) {
        this.takeaway = takeaway;
    }

    public String getPaymentType() {
        return payment_type;
    }

    public void setPayment_type(String paymentType) {
        this.payment_type = paymentType;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Address getDeliveryAddress() {
        return delivery_address;
    }

    public void setDelivery_address(Address delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String toString() {
        return "PostOrder{" +
                "pizzas=" + pizzas +
                ", takeAway=" + takeaway +
                ", paymentType='" + payment_type + '\'' +
                ", customerId=" + customer_id +
                ", deliveryAddress=" + delivery_address +
                '}';
    }

}
