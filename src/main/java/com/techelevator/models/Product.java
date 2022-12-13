package com.techelevator.models;

public abstract class Product {
    private String name;
    private double price;
    private int quantity = 5;
    private String type;

    public Product(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }
    public abstract String makeSound();
}