package com.techelevator.data;

import com.techelevator.exceptions.InvalidProductCodeException;
import com.techelevator.interfaces.TypeConstants;
import com.techelevator.models.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Repo implements TypeConstants {

    private static Map<String, Product> listOfProducts = new TreeMap<>();
    private final static String FILE_PATH = "vendingmachine.csv";
    private static final String[] PRODUCT_CODES =
            {"A1", "A2", "A3", "A4", "B1", "B2", "B3", "B4", "C1", "C2", "C3", "C4", "D1", "D2", "D3", "D4"};


    public static void startup() {
        try (var fileReader = new Scanner(new File(FILE_PATH))) {
            while(fileReader.hasNextLine()) {
                String[] productInfo = fileReader.nextLine().split("\\|");
                createProduct(productInfo);
            }
            System.out.println("Startup complete.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (Exception e) {
            System.out.println("Unknown exception occurred in startup.");
        }
    }

    private static void createProduct(String[] product) {
        switch (product[3].trim()) {
            case TYPE_CANDY:
                listOfProducts.put(product[0], new Candy(product[1], Double.parseDouble(product[2])));
                break;
            case TYPE_CHIP:
                listOfProducts.put(product[0], new Chip(product[1], Double.parseDouble(product[2])));
                break;
            case TYPE_DRINK:
                listOfProducts.put(product[0], new Drink(product[1], Double.parseDouble(product[2])));
                break;
            case TYPE_GUM:
                listOfProducts.put(product[0], new Gum(product[1], Double.parseDouble(product[2])));
                break;
            default:
                System.out.println("Product type does not exist.");
        }
    }

    /**
     * @param productCode key (String) with which the specified value is to be associated value.
     *                          Example - "A1" or "B3".
     * @return the value (object Product) to which the specified key is mapped, or null if this map
     *              contains no mapping for the key.
     */

    public static Product getProductFromList(String productCode) {

        Product product = null;
        try {
            var key = ProductCodeValidation(productCode);

            product = listOfProducts.get(key);

        } catch (Exception e) { System.out.println(e.getMessage()); }
        return product;
    }

    public static String updateProduct(String productCode)  {

        String message = "";
        try {
            var key = ProductCodeValidation(productCode);

            var productToUpdate = listOfProducts.get(key);
            var quantityToUpdate = productToUpdate.getQuantity();

            if (productToUpdate.getQuantity() > 0) {
                productToUpdate.setQuantity(productToUpdate.getQuantity() - 1);

                message = String.format("%s's quantity updated from %d to %d.",
                            productToUpdate.getName(), quantityToUpdate, productToUpdate.getQuantity());
            } else
                message = String.format("%s is SOLD OUT.", productToUpdate.getName());

        } catch (Exception e) { System.out.println(e.getMessage()); }
        return message;
    }

    private void totalSalesReport() {

    }

    public static void displayListOfProducts() {
        for (Map.Entry<String, Product> product : listOfProducts.entrySet()) {
            System.out.printf("%S - %-19s  $%.2f  %-6s %s\n",
                    product.getKey(), product.getValue().getName(), product.getValue().getPrice(), product.getValue().getType(),
                    product.getValue().getQuantity() > 0 ? product.getValue().getQuantity() : "SOLD OUT");
        }
    }
    private static String ProductCodeValidation(String productCode) throws InvalidProductCodeException {
        if(productCode == null)
            throw new InvalidProductCodeException("Product code was null");

        String key = productCode.toUpperCase().trim();
        var isValidCode = Arrays.asList(PRODUCT_CODES).contains(key);

        if (key.length() != 2 || !isValidCode)
            throw new InvalidProductCodeException("Product Code does not exist.");
        return key;
    }

}
