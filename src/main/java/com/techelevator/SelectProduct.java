package com.techelevator;


import com.techelevator.data.Repo;
import com.techelevator.deprecated.PurchaseCLI;
import com.techelevator.view.Menu;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class SelectProduct  {
    private final static String SELECT_PRODUCT_SELECT_PRODUCT = "Select product";
    private final static String SELECT_PRODUCT_RETURN_TO_PREVIOUS = "Return to previous menu";
    private final static String[] SELECT_PURCHASE_OPTIONS = {SELECT_PRODUCT_SELECT_PRODUCT, SELECT_PRODUCT_RETURN_TO_PREVIOUS};
    Menu menu;


    public SelectProduct(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(SELECT_PURCHASE_OPTIONS);

            if (choice.equals(SELECT_PRODUCT_SELECT_PRODUCT)) {
                Repo.displayListOfProducts();

            } else if (choice.equals(SELECT_PRODUCT_RETURN_TO_PREVIOUS)) {
                PurchaseCLI purchaseCLI = new PurchaseCLI(menu);
                purchaseCLI.displayPurchasingMenu();
            }
        }
    }
}
