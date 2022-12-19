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

<<<<<<< HEAD
    public void setProductList(List<String> productList) {
        //this.productList = Repo.getListOfProducts();
    }
=======
    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(PURCHASING_MENU_OPTIONS);
>>>>>>> 7aa632079ce0e7667d27ca72374d41d6a3b5581b

            if (choice.equals(PURCHASING_MENU_FEED_MONEY)) {
                FeedMoneyNYI fm = new FeedMoneyNYI(menu);
                fm.displayFeedMoneyMenu();
            } else if (choice.equals(PURCHASING_MENU_SELECT_PRODUCT)) {
                SelectProduct sp = new SelectProduct();
                sp.showSelectProductMenu(menu);
            } else if (choice.equals(PURCHASING_MENU_FINISH_TRANSACTION)) {
                FinishTransactionNYI ft = new FinishTransactionNYI(menu);
                ft.displayFinishedTransaction();
            }
        }
    }

<<<<<<< HEAD
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
=======

>>>>>>> 7aa632079ce0e7667d27ca72374d41d6a3b5581b

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
