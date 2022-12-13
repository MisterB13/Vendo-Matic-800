package com.techelevator.models;

public class Chip extends Product implements TypeConstants {
    public Chip(String name, double price) {
        super(name, price, TYPE_CHIP);
    }

    @Override
    public String makeSound() {
        return "Crunch Crunch, Yum!";
    }
}
