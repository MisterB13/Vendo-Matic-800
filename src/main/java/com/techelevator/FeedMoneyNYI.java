package com.techelevator;

import com.techelevator.view.Menu;
import java.util.Arrays;
import java.util.Scanner;

public class FeedMoneyNYI {
    private static final String FEED_MONEY_MONEY_TO_DEPOSIT = "Deposit Money";

    private static final String FEED_MONEY_PREVIOUS_MENU = "Return to previous menu";

    private static final String[] FEED_MONEY_MENU_OPTIONS = { FEED_MONEY_MONEY_TO_DEPOSIT, FEED_MONEY_PREVIOUS_MENU };

    private static final Integer[] DOLLAR_AMOUNTS = {1, 5, 10, 20};

    private double balance;
    private final Menu menu;

    public FeedMoneyNYI(Menu menu) {
        this.menu = menu;
    }

    public void displayFeedMoneyMenu() {

        while(true) {
            var choice = (String) menu.getChoiceFromOptions(FEED_MONEY_MENU_OPTIONS);

            if(choice.equals(FEED_MONEY_MONEY_TO_DEPOSIT)) {
                displayBalance();
                makeTransaction();

            } else if (choice.equals(FEED_MONEY_PREVIOUS_MENU)) {break;}
        }
    }

    private void makeTransaction() {

        try {

          while(true) {
                System.out.print("Insert Dollar Amount >>> ");
                var scanner = new Scanner(System.in);

                int inputDollarAmount = Integer.parseInt(scanner.nextLine());
                var correctIncrement = Arrays.stream(DOLLAR_AMOUNTS).anyMatch(n -> n == inputDollarAmount);

                if(correctIncrement) {
                    balance += inputDollarAmount;
                    System.out.printf(System.lineSeparator() +"$%d was received, current balance updated to $%.2f" + System.lineSeparator(),inputDollarAmount, balance);
                    break;
                }
                else {
                    System.out.println(System.lineSeparator() + "Please insert an amount in increments of $1, $5, $10 or $20."+ System.lineSeparator());
                }
            }

        } catch (NumberFormatException nfe) {
           System.out.println(System.lineSeparator() + "Input is not a number." + System.lineSeparator());
        }
    }

    private void displayBalance() { System.out.printf(System.lineSeparator() + "Current Money Provided: $%.2f" + System.lineSeparator(), balance); }
}
