package com.techelevator.data;

import com.techelevator.models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DataProcess implements TypeConstants {

    private static Map<String, Product> listOfProducts = new TreeMap<>();
    private final static String FILE_PATH = "vendingmachine.csv";


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


    public static Product getProductFromList(String productCode) throws InvalidProductCodeException {

        Product product = null;
        try {
            String key = productCode.toUpperCase().trim();

            if (key.length() != 2 || !listOfProducts.containsKey(key))
                throw new InvalidProductCodeException("Product Code doesn't exist.");

            product = listOfProducts.get(key);
        } catch (NullPointerException npe) {
                throw new InvalidProductCodeException("Product Code was null.");
        } catch (Exception e) {
            System.out.println("Unknown exception occurred in getProductFromList.");
        }
        return product;
    }

    public static String updateProduct(String productCode) throws InvalidProductCodeException {

        String message;
        try {
            String key = productCode.toUpperCase().trim();

            if (key.length() != 2 || !listOfProducts.containsKey(key))
                throw new InvalidProductCodeException("Product Code doesn't exist.");

            var productToUpdate = listOfProducts.get(key);

            if (productToUpdate.getQuantity() > 0) {
                productToUpdate.setQuantity(productToUpdate.getQuantity() - 1);
                var updatedProduct= listOfProducts.replace(key, productToUpdate);

                message = String.format("%s's quantity was updated to %d.",
                        updatedProduct.getName(), updatedProduct.getQuantity());
            } else
                message = String.format("%s is currently SOLD OUT.", productToUpdate.getName());

        } catch (NullPointerException npe) {
                throw new InvalidProductCodeException("Product Code was null.");
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }


    public static void displayListOfProducts() {
        for (Map.Entry<String, Product> product:
                listOfProducts.entrySet()) {
            System.out.printf("%S - %-19s  $%.2f  %-6s %s\n",
                    product.getKey(), product.getValue().getName(), product.getValue().getPrice(), product.getValue().getType(),
                    product.getValue().getQuantity() > 0 ? product.getValue().getQuantity() : "SOLD OUT");
        }
    }

}
