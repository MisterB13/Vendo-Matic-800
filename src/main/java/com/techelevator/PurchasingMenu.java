package com.techelevator;

import com.techelevator.view.Menu;

import java.io.InputStream;
import java.io.OutputStream;

public class PurchasingMenu extends Menu {

    public PurchasingMenu(InputStream input, OutputStream output) {
        super(input, output);
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



        System.out.println(
                "Your change is " + quarter + " quarters, " + dime + " dimes and " + nickel + " nickels. ");
    }
}
