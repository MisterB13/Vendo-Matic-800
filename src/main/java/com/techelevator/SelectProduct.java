package com.techelevator;

import com.techelevator.view.Menu;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class SelectProduct extends Menu, Product, implements Purchasable {

    List<String> productList = new ArrayList<>();
    InputStream input;

    InputStream output;

    public SelectProduct(InputStream input, OutputStream output, List<String> productList) {
        super(input, output);
        this.productList = getListOfProducts();
    }

     public void printProductList() {
         System.out.println(productList);
         System.out.println("Please enter item code from list above: ");
     }

     public void makeSelection() {

     }

    public String makeNoise() {
        if (input.contains()) {

        }
    }
}
