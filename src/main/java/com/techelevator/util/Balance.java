package com.techelevator.util;
import java.math.BigDecimal;

public class Balance {

    private static final BigDecimal VALUE_OF_QUARTER = BigDecimal.valueOf(0.25);
    private static final BigDecimal VALUE_OF_DIME = BigDecimal.valueOf(0.10);
    private static final BigDecimal VALUE_OF_NICKLE = BigDecimal.valueOf(0.05);

    private static BigDecimal balance = BigDecimal.ZERO;

    public static void addToBalance(BigDecimal funds) {
        balance = balance.add(funds);
    }

    public static boolean subtractFromBalance(BigDecimal priceOfProduct) {
        if(balance.compareTo(priceOfProduct) >= 0) {
            balance = balance.subtract(priceOfProduct);
            return true;
        }
        return false;
    }

    public static void calculateChange() {
        var quarters = 0;
        var dimes = 0;
        var nickles = 0;

        try {
            while(balance.compareTo(BigDecimal.ZERO) > 0) {
                if(BigDecimal.ZERO.compareTo(balance.remainder(VALUE_OF_QUARTER)) == 0) {
                    quarters++;
                    balance = balance.subtract(VALUE_OF_QUARTER);
                } else if (BigDecimal.ZERO.compareTo(balance.remainder(VALUE_OF_DIME)) == 0) {
                    dimes++;
                    balance = balance.subtract(VALUE_OF_DIME);
                } else if (BigDecimal.ZERO.compareTo(balance.remainder(VALUE_OF_NICKLE)) == 0) {
                    nickles++;
                    balance = balance.subtract(VALUE_OF_NICKLE);
                }
            }
            System.out.printf("Balance: %s Quarters: %d Dimes: %d Nickles: %d", balance, quarters, dimes, nickles);
        } catch (Exception e) {
            System.out.println("Error in giveCorrectChange");
        }
    }

    public static void displayBalance() { System.out.printf(System.lineSeparator() + "Current Money Provided: $%.2f" + System.lineSeparator(), balance); }

    public static BigDecimal getBalance() {
        return balance;
    }
}



