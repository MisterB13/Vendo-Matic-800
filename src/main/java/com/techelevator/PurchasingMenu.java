package com.techelevator;

import com.techelevator.deprecated.FinishTransactionNYI;
import com.techelevator.interfaces.TypeConstants;
import com.techelevator.view.Menu;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

public class PurchasingMenu extends Menu implements TypeConstants {

    private static final String PURCHASING_MENU_FEED_MONEY = "Feed Money";

    private static final String PURCHASING_MENU_SELECT_PRODUCT = "Select Product";

    private static final String PURCHASING_MENU_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] PURCHASING_MENU_OPTIONS = {PURCHASING_MENU_FEED_MONEY, PURCHASING_MENU_SELECT_PRODUCT, PURCHASING_MENU_FINISH_TRANSACTION};

    private final Menu menu;
    public PurchasingMenu(InputStream input, OutputStream output, Menu menu) {
        super(input, output);
        this.menu = menu;
    }
    public PurchasingMenu(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(PURCHASING_MENU_OPTIONS);

            if (choice.equals(PURCHASING_MENU_FEED_MONEY)) {
                FeedMoney fm = new FeedMoney();
                fm.feedMoney();
            } else if (choice.equals(PURCHASING_MENU_SELECT_PRODUCT)) {
                SelectProduct sp = new SelectProduct();
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
