package com.techelevator;

import com.techelevator.view.Menu;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
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

    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        //this.productList = getListOfProducts();
    }

    public void printProductList() {
        System.out.println(productList);
        System.out.println("Please enter item code from list above: ");

    }


    public void finishTransaction(BigDecimal balance) {
        double balance1;
        int quarter;
        int dime;
        int nickel;
        balance1 = (balance.doubleValue() * 100);
        quarter = ((int) balance1 / 25);
        balance1 = balance1 - (quarter * 25);
        dime = ((int) balance1 / 10);
        balance1 = balance1 - (dime* 10);
        nickel = ((int) balance1 / 5);



        System.out.println("Your change is " + quarter + " quarters, " + dime + " dimes and " + nickel + " nickels. ");
    }
}
