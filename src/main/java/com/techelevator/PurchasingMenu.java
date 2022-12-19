package com.techelevator;

import com.techelevator.data.Log;
import com.techelevator.data.Repo;
import com.techelevator.interfaces.TypeConstants;
import com.techelevator.models.Chip;
import com.techelevator.models.Product;
import com.techelevator.view.Menu;

import java.io.Console;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchasingMenu extends Menu implements TypeConstants {

    private static final String PURCHASING_MENU_FEED_MONEY = "Feed Money:";

    private static final String PURCHASING_MENU_SELECT_PRODUCT = "Select Product:";

    private static final String PURCHASING_MENU_FINISH_TRANSACTION = "Finish Transaction:";
    List<String> productList = new ArrayList<>();
    Log writer = new Log();

    String in = System.in.toString();

    Product product = new Product() {
        @Override
        public String makeSound() {
            return null;
        }
    };

    Balance balance = new Balance();

    public PurchasingMenu(InputStream input, OutputStream output) {
        super(input, output);
    }

    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        //this.productList = Repo.getListOfProducts();
    }

    public void printProductList() {
        System.out.println(productList);
        System.out.println("Please enter item code from list above: ");
    }

    public BigDecimal feedMoney(String choice, BigDecimal runningBalance) {
        BigDecimal amountToAddBack = new BigDecimal(0);
        String typeOfTransaction = PURCHASING_MENU_FEED_MONEY;

        System.out.println("1: 1 Dollar");
        System.out.println("2: 5 Dollars");
        System.out.println("3: 10 Dollars");
        System.out.println("4: 20 Dollars");

        if (choice.equals("1")) {
            amountToAddBack = new BigDecimal(1.00);
            writer.writer(typeOfTransaction, new BigDecimal(1.00).setScale(2), runningBalance.add(amountToAddBack) );
        } else if (choice.equals("2")) {
            amountToAddBack = new BigDecimal(2.00);
            writer.writer(typeOfTransaction, new BigDecimal(2.00).setScale(2), runningBalance.add(amountToAddBack));
        } else if (choice.equals("3")) {
            amountToAddBack = new BigDecimal(5.00);
            writer.writer(typeOfTransaction, new BigDecimal(5.00).setScale(2), runningBalance.add(amountToAddBack));
        } else if (choice.equals("4")) {
            amountToAddBack = new BigDecimal(10.00);
            writer.writer(typeOfTransaction, new BigDecimal(10.00).setScale(2), runningBalance.add(amountToAddBack));
        }
        return amountToAddBack;
    }

    public String selectProduct()  {
        System.out.println(getProductList());
        System.out.println("Please enter the item code of the product you wish to purchase: ");
        String userIn = in;
        String typeOfTransaction = product.getName();
        String type = product.getType();
        String selection = "You have selected: " + Repo.getProductByProductCode(userIn);
        switch (type) {
            case (TYPE_CHIP) :
                System.out.println("Crunch Crunch, Yum!");
                break;
            case (TYPE_CANDY) :
                System.out.println("Munch Munch, Yum!");
                break;
            case (TYPE_DRINK) :
                System.out.println("Glug Glug, Yum!");
                break;
            case (TYPE_GUM) :
                System.out.println("Chew Chew, Yum!");
                break;
        }
        writer.writer(typeOfTransaction, in, balance.getBalance(), changeRemainingBalance(balance.getBalance()));
        return selection;
    }

    public BigDecimal changeRemainingBalance(BigDecimal balance) {
        BigDecimal productPrice = product.getPrice();
        BigDecimal newBalance = balance.subtract(productPrice);
        return newBalance;
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
