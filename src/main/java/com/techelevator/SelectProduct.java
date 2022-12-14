package com.techelevator;

import com.techelevator.models.Product;
import com.techelevator.models.TypeConstants;
import java.util.List;

public class SelectProduct extends Product implements TypeConstants {

    List<String> productList = getListOfProducts;

    public SelectProduct(String name, double price, String type) {
        super(name, price, type);
    }

    public void printProductList() {
        System.out.println(productList);
        System.out.println("Please enter item code from list above: ");

    }

    public void selectProduct(Object choice) {
    }

    public String dispenseProduct() {
        String dispense = getProduct() + ": " + getPrice() + getRemainingBalance();
        System.out.println(makeNoise(type));
        return dispense;
    }

    @Override
    public String makeSound() {
        return null;
    }
}
