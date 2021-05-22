package com.um.apitest.order.post;

public class PizzaOrder {

    private int pizza_id;
    private String note;

    public PizzaOrder() {}

    public PizzaOrder(int id, String note) {
        this.pizza_id = id;
        this.note = note;
    }

    public int getPizza_id() {
        return pizza_id;
    }

    public void setPizza_id(int pizza_id) {
        this.pizza_id = pizza_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String toString() {
        return "PizzaOrder{" +
                "id=" + pizza_id +
                ", note='" + note + '\'' +
                '}';
    }
}
