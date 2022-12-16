package com.techelevator;

import com.techelevator.data.Repo;
import com.techelevator.models.Product;
import com.techelevator.view.Menu;
import java.util.Scanner;

public class SelectProduct {
    private final Menu menu;
    private static final String ENTER_PRODUCT_CODE_TO_PURCHASE = "Enter product code to purchase";
    private static final String FEED_MONEY_PREVIOUS_MENU = "Return to previous menu";
    private static final String[] SELECT_PRODUCT_MENU_OPTIONS = { ENTER_PRODUCT_CODE_TO_PURCHASE, FEED_MONEY_PREVIOUS_MENU };

    public SelectProduct(Menu menu) {
        this.menu = menu;
    }

    public void displaySelectProductMenu() {
        while(true) {
            Repo.displayListOfProducts();
            var choice = (String) menu.getChoiceFromOptions(SELECT_PRODUCT_MENU_OPTIONS);

            if(choice.equals(ENTER_PRODUCT_CODE_TO_PURCHASE)) {
                makeProductSelection();
            } else if (choice.equals(FEED_MONEY_PREVIOUS_MENU)) { break; }
        }
    }

    public void makeProductSelection() {

        while(true) {
            System.out.print("Enter a code to select an item >>> ");
            var scanner = new Scanner(System.in);
            String productCode = scanner.nextLine().trim();

            Product product = Repo.getProductFromList(productCode);

            if(product != null) {

                if(product.getQuantity() > 0) {
                    //get and update balance needed.
                    String message = Repo.updateProduct(productCode);
                    System.out.println(message);
                    break;
                }
            }
        }
    }
}
