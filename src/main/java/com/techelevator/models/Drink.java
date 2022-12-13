package com.techelevator.models;

public class Drink extends Product implements TypeConstants {

    public Drink(String name, double price) {
        super(name, price, TYPE_DRINK);
    }

    @Override
    public String makeSound() {
        return "Glug Glug, Yum!";
    }
}
