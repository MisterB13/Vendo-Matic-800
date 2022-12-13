package com.techelevator;

import com.techelevator.view.Menu;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class PurchasingMenu extends Menu {

    private static final String PURCHASING_MENU_FEED_MONEY = "Feed Money";

    private static final String PURCHASING_MENU_SELECT_PRODUCT = "Select Product";

    private static final String PURCHASING_MENU_FINISH_TRANSACTION = "Finish Transaction";
    List<String> productList = new ArrayList<>();

    private Menu menu;
    public PurchasingMenu(InputStream input, OutputStream output) {
        super(input, output);
    }

    public void run() {
        String choice = (String) menu.getChoiceFromOptions();
        while (true) {

        }
    }

    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        this.productList = getListOfProducts();
    }

    public void printProductList() {
        System.out.println(productList);
        System.out.println("Please enter item code from list above: ");

    }


}
