package com.techelevator;

import com.techelevator.data.Log;
import com.techelevator.data.Repo;
import com.techelevator.deprecated.FeedMoneyNYI;
import com.techelevator.deprecated.FinishTransactionNYI;
import com.techelevator.deprecated.PurchaseCLI;
import com.techelevator.interfaces.TypeConstants;
import com.techelevator.models.Chip;
import com.techelevator.models.Product;
import com.techelevator.view.Menu;
import com.techelevator.view.SelectProduct;

import java.io.Console;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchasingMenu extends Menu implements TypeConstants {

    private static final String PURCHASING_MENU_FEED_MONEY = "Feed Money";

    private static final String PURCHASING_MENU_SELECT_PRODUCT = "Select Product";

    private static final String PURCHASING_MENU_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] PURCHASING_MENU_OPTIONS = {PURCHASING_MENU_FEED_MONEY, PURCHASING_MENU_SELECT_PRODUCT, PURCHASING_MENU_FINISH_TRANSACTION};
    List<String> productList = new ArrayList<>();
    Log writer = new Log();

    Product product = new Product() {
        @Override
        public String makeSound() {
            return null;
        }
    };

    Balance balance = new Balance();

    Menu menu = new Menu();

    public PurchasingMenu(InputStream input, OutputStream output) {
        super(input, output);
    }
    public PurchasingMenu(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(PURCHASING_MENU_OPTIONS);

            if (choice.equals(PURCHASING_MENU_FEED_MONEY)) {
                FeedMoneyNYI fm = new FeedMoneyNYI(menu);
                fm.displayFeedMoneyMenu();
            } else if (choice.equals(PURCHASING_MENU_SELECT_PRODUCT)) {
                SelectProduct sp = new com.techelevator.SelectProduct();
                sp.showSelectProductMenu(menu);
            } else if (choice.equals(PURCHASING_MENU_FINISH_TRANSACTION)) {
                FinishTransactionNYI ft = new FinishTransactionNYI(menu);
                ft.displayFinishedTransaction();
            }
        }
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
