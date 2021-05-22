package com.um.apitest.pizza;

public class Pizza {

    private int pizza_id;
    private String name;
    private boolean vegetarian;
    private double price;
    private String[] toppings;

    public Pizza(int pizza_id, String name, boolean vegetarian, double price, String[] toppings) {
        this.pizza_id = pizza_id;
        this.name = name;
        this.vegetarian = vegetarian;
        this.price = price;
        this.toppings = toppings;
    }

    public Pizza(String name, boolean vegetarian, double price) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public Pizza(){}

    public int getPizza_id() {
        return pizza_id;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public double getPrice() {
        return price;
    }

    public void setPizza_id(int pizza_id) {
        this.pizza_id = pizza_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getToppings() {
        return toppings;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + pizza_id +
                ", name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", price=" + price +
                '}';
    }
}
