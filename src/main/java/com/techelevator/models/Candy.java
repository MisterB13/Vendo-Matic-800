package com.techelevator.models;


public class Candy extends Product implements TypeConstants {

    public Candy(String name, double price) {
        super(name, price, TYPE_CANDY);
    }

    @Override
    public String makeSound() {
        return "Munch Munch, Yum!";
    }
}
