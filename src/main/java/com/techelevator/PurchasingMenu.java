package com.techelevator;

import com.techelevator.data.Log;
import com.techelevator.models.Product;
import com.techelevator.view.Menu;

import java.io.Console;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchasingMenu extends Menu {

  //  private static final String PURCHASING_MENU_FEED_MONEY = "Feed Money";

    private static final String PURCHASING_MENU_SELECT_PRODUCT = "Select Product";

   // private static final String PURCHASING_MENU_FINISH_TRANSACTION = "Finish Transaction";
    List<String> productList = new ArrayList<>();
    Log writer = new Log();

    private Menu menu;
    public PurchasingMenu(InputStream input, OutputStream output) {
        super(input, output);
    }

//    public void run() {
//        String choice = (String) menu.getChoiceFromOptions();
//        while (true) {
//
//        }
//    }

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

    public BigDecimal feedMoney(String choice, BigDecimal runningBalance) {
        BigDecimal amountToAddBack = new BigDecimal(0);
        String typeOfTransaction = "FEED MONEY:";


        if (choice.equals("Feed 1 dollars")) {
            amountToAddBack = new BigDecimal(1.00);
            writer.writer(typeOfTransaction, new BigDecimal(1.00).setScale(2), runningBalance.add(amountToAddBack) );
        } else if (choice.equals("Feed 2 dollars")) {
            amountToAddBack = new BigDecimal(2.00);
            writer.writer(typeOfTransaction, new BigDecimal(2.00).setScale(2), runningBalance.add(amountToAddBack));
        } else if (choice.equals("Feed 5 dollars")) {
            amountToAddBack = new BigDecimal(5.00);
            writer.writer(typeOfTransaction, new BigDecimal(5.00).setScale(2), runningBalance.add(amountToAddBack));
        } else if (choice.equals("Feed 10 dollars")) {
            amountToAddBack = new BigDecimal(10.00);
            writer.writer(typeOfTransaction, new BigDecimal(10.00).setScale(2), runningBalance.add(amountToAddBack));
        }
        return amountToAddBack;
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
