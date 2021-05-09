package com.um.apitest.pizza;

public class Pizza {

    private int id;
    private String name;
    private boolean vegetarian;
    private double price;

    public Pizza(int id, String name, boolean vegetarian, double price) {
        this.id = id;
        this.name = name;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public Pizza(String name, boolean vegetarian, double price) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public Pizza(){}

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", price=" + price +
                '}';
    }
}
