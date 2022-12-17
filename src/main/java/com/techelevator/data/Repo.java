package com.techelevator.data;

import com.techelevator.exceptions.IllegalProductQuantityException;
import com.techelevator.exceptions.IllegalProductCodeException;
import com.techelevator.exceptions.IllegalProductTypeException;
import com.techelevator.interfaces.TypeConstants;
import com.techelevator.models.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
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
            System.out.println(e.getMessage());
        }
    }

    private static void createProduct(String[] product) throws IllegalProductTypeException {
        switch (product[3].trim()) {
            case TYPE_CANDY:
                listOfProducts.put(product[0], new Candy(product[1], new BigDecimal(product[2])));
                break;
            case TYPE_CHIP:
                listOfProducts.put(product[0], new Chip(product[1], new BigDecimal(product[2])));
                break;
            case TYPE_DRINK:
                listOfProducts.put(product[0], new Drink(product[1], new BigDecimal(product[2])));
                break;
            case TYPE_GUM:
                listOfProducts.put(product[0], new Gum(product[1], new BigDecimal(product[2])));
                break;
            default:
                throw new IllegalProductTypeException("Product code not found.");
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

    public static void updateProduct(String productCode)  {

        try {
            var key = ProductCodeValidation(productCode);

            var productToUpdate = listOfProducts.get(key);
            var quantityToUpdate = productToUpdate.getQuantity();

            if(quantityToUpdate <= 0)
                throw new IllegalProductQuantityException("Product is SOLD OUT.");

            productToUpdate.setQuantity(productToUpdate.getQuantity() - 1);

            System.out.printf("%s's quantity updated from %d to %d.",
                      productToUpdate.getName(), quantityToUpdate, productToUpdate.getQuantity());

        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    private void totalSalesReport() {
            //NYI
    }

    public static void displayListOfProducts() {
        for (Map.Entry<String, Product> product : listOfProducts.entrySet()) {
            System.out.printf("%S - %-19s  $%-6.2f %s\n",
                    product.getKey(), product.getValue().getName(), product.getValue().getPrice(),
                    product.getValue().getQuantity() > 0 ? product.getValue().getQuantity() : "SOLD OUT");
        }
    }
    private static String ProductCodeValidation(String productCode) throws IllegalProductCodeException {
        if(productCode == null)
            throw new IllegalProductCodeException("Product code was null");

        String key = productCode.toUpperCase().trim();
        var isValidCode = Arrays.asList(PRODUCT_CODES).contains(key);

        if (key.length() != 2 || !isValidCode)
            throw new IllegalProductCodeException("Product Code does not exist.");
        return key;
    }

}
