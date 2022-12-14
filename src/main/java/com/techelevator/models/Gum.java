package com.techelevator.models;

import com.techelevator.interfaces.TypeConstants;

public class Gum extends Product implements TypeConstants {

    public Gum(String name, double price) {
        super(name, price, TYPE_GUM);
    }

    @Override
    public String makeSound() {
        return "Chew Chew, Yum!";
    }
}
