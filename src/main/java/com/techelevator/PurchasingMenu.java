package com.techelevator;

import com.techelevator.data.Log;
import com.techelevator.data.Repo;
import com.techelevator.deprecated.FeedMoneyNYI;
import com.techelevator.deprecated.FinishTransactionNYI;
import com.techelevator.interfaces.TypeConstants;
import com.techelevator.models.Product;
import com.techelevator.view.Menu;
import com.techelevator.controllers.FinishTransaction;

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
                FeedMoney fm = new FeedMoney();
                fm.feedMoney();
            } else if (choice.equals(PURCHASING_MENU_SELECT_PRODUCT)) {
                SelectProduct sp = new SelectProduct();
                sp.showSelectProductMenu(menu);
            } else if (choice.equals(PURCHASING_MENU_FINISH_TRANSACTION)) {
                FinishTransaction ft = new FinishTransaction(menu);
                ft.displayFinishedTransaction();
            }
        }
    }

    public BigDecimal changeRemainingBalance(BigDecimal balance) {
        BigDecimal productPrice = product.getPrice();
        BigDecimal newBalance = balance.subtract(productPrice);
        return newBalance;
    }

}
