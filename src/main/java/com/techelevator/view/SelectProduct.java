package com.techelevator;


import com.techelevator.data.Log;
import com.techelevator.data.Repo;
import com.techelevator.deprecated.BalanceNYI;
import com.techelevator.deprecated.PurchaseCLI;
import com.techelevator.models.Product;
import com.techelevator.view.Menu;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class SelectProduct  {
    private final static String SELECT_PRODUCT_SELECT_PRODUCT = "Select product";
    private final static String SELECT_PRODUCT_RETURN_TO_PREVIOUS = "Return to previous menu";
    private final static String[] SELECT_PURCHASE_OPTIONS = {SELECT_PRODUCT_SELECT_PRODUCT, SELECT_PRODUCT_RETURN_TO_PREVIOUS};
    private Menu menu;

    Log log = new Log();

    public SelectProduct() {}

    public void showSelectProductMenu(Menu menu) {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(SELECT_PURCHASE_OPTIONS);

            if (choice.equals(SELECT_PRODUCT_SELECT_PRODUCT)) {
                PurchasingMenu pm = new PurchasingMenu(menu);
                Repo.displayListOfProducts();
                selectProduct();
            } else if (choice.equals(SELECT_PRODUCT_RETURN_TO_PREVIOUS)) {
                break;
            }
        }
    }

    public void selectProduct()  {
        while (true) {
            System.out.println("Please select an item using a code from the list above: ");
            var scanner = new Scanner(System.in);
            String code = scanner.nextLine();
            BigDecimal balance = Balance.getBalance();
<<<<<<< HEAD:src/main/java/com/techelevator/view/SelectProduct.java
            Product product = Repo.getProductFromList(code);
=======
            Product product = Repo.getProductFromList(code.toLowerCase());
            BigDecimal productPrice = product.getPrice();
            BigDecimal newBalance = balance.subtract(productPrice);
>>>>>>> 7aa632079ce0e7667d27ca72374d41d6a3b5581b:src/main/java/com/techelevator/SelectProduct.java

            if (product != null) {
                if (product.getQuantity() > 0) {
                    var result = Balance.subtract(product.getPrice());

                    if (result.compareTo(new BigDecimal(0.00)) == 0) {
                        Repo.updateProduct(code);
                        System.out.println(product.makeSound());
                        System.out.println("Your product was dispensed!");
                        System.out.println("Remaining balance: " + newBalance);
                        log.writer(product.getType(), code, product.getPrice(), balance);
                    } else {
                        System.out.println("Insufficient funds. Please use Feed Money to add to your balance.");
                    } break;
                } else {
                    System.out.println("Your product is out of stock. Please try again later.");
                }
            }
        }
    }
}
