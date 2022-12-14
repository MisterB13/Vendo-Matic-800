package com.techelevator;

import com.techelevator.models.Product;
import com.techelevator.models.TypeConstants;
import java.util.List;

public class SelectProduct extends Product implements TypeConstants {

<<<<<<< HEAD
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
=======
    List<String> productList = getListOfProducts;

    public SelectProduct(String name, double price, String type) {
        super(name, price, type);
>>>>>>> f096fb575837a6e067ba881d585006f66acc547b
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

    @Override
    public String makeSound() {
        return null;
    }
}
