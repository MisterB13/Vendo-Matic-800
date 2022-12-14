package com.techelevator;

import com.techelevator.models.Product;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class SelectProduct  {

    //List<String> productList = getListOfProducts;
    InputStream input;

    InputStream output;

    private static final String CHIP_NOISE = "Crunch Crunch, Yum!";
    private static final String CANDY_NOISE = "Munch Munch, Yum!";
    private static final String DRINK_NOISE = "Glug Glug, Yum!";
    private static final String GUM_NOISE = "Chew Chew, Yum!";

    //private String type = getType();

    public SelectProduct(InputStream input, OutputStream output) {
//        super(input, output);
//        Product product = new Product();
//        this.productList = productList;
    }

    public void printProductList() {
        //System.out.println(productList);
        System.out.println("Please enter item code from list above: ");

    }

    public void selectProduct(Object choice) {
    }

//    public String dispenseProduct() {
//        String dispense = getProduct() + ": " + getPrice() + getRemainingBalance();
//        System.out.println(makeNoise(type));
//        return dispense;
//    }

    public String makeNoise(String type) {
        switch (type) {
            case "Chip":
                return CHIP_NOISE;
            case "Candy":
                return CANDY_NOISE;
            case "Drink":
                return DRINK_NOISE;
            case "Gum":
                return GUM_NOISE;
        }
        return null;
    }
}
