package com.techelevator;

import com.techelevator.view.Menu;
public class PurchaseCLI {

    private static final String PURCHASING_MENU_FEED_MONEY = "Feed Money";

    private static final String PURCHASING_MENU_SELECT_PRODUCT = "Select Product";

    private static final String PURCHASING_MENU_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] PURCHASING_MENU_OPTIONS = { PURCHASING_MENU_FEED_MONEY, PURCHASING_MENU_SELECT_PRODUCT, PURCHASING_MENU_FINISH_TRANSACTION };

    private final Menu menu;

    public PurchaseCLI(Menu menu) {
        this.menu = menu;
    }

    public void displayPurchasingMenu() {
        while(true) {
            var choice = (String) menu.getChoiceFromOptions(PURCHASING_MENU_OPTIONS);

            if(choice.equals(PURCHASING_MENU_FEED_MONEY)) {
                FeedMoney feedMoney = new FeedMoney(menu);
                feedMoney.displayFeedMoneyMenu();
            } else if (choice.equals(PURCHASING_MENU_SELECT_PRODUCT)) {
                SelectProduct selectProduct = new SelectProduct(menu);
                selectProduct.displaySelectProductMenu();

            } else if (choice.equals(PURCHASING_MENU_FINISH_TRANSACTION)) {

            }
        }
    }
}
