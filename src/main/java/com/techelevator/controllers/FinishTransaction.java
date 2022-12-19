package com.techelevator.controllers;

import com.techelevator.data.Log;
import com.techelevator.data.Repo;
import com.techelevator.util.Balance;
import com.techelevator.view.Menu;

//@Deprecated
public class FinishTransaction {

//    private static final BigDecimal VALUE_OF_QUARTER = BigDecimal.valueOf(0.25);
//    private static final BigDecimal VALUE_OF_DIME = BigDecimal.valueOf(0.10);
//    private static final BigDecimal VALUE_OF_NICKLE = BigDecimal.valueOf(0.05);

    private final Menu menu;

    public FinishTransaction(Menu menu) {
        this.menu = menu;
    }

    public void displayFinishedTransaction() {
        //var balance = BalanceNYI.getBalance();
        var typeOfTransaction = "GIVE CHANGE:";
        var balance = Balance.getBalance();
        Balance.calculateChange();
        Repo.totalSalesReport();
    }


//    public void giveCorrectChange(BigDecimal change) {
//        var balance = change;
//        var quarters = 0;
//        var dimes = 0;
//        var nickles = 0;
//
//        try {
//            while(balance.compareTo(BigDecimal.ZERO) > 0) {
//                if(BigDecimal.ZERO.compareTo(balance.remainder(VALUE_OF_QUARTER)) == 0) {
//                    //System.out.println("added quarter");
//                    quarters++;
//                    //System.out.println("quarters = " + quarters);
//                    //System.out.println("subtracting from balance.");
//                    balance = balance.subtract(VALUE_OF_QUARTER);
//                    //System.out.println("balance = " + balance);
//                } else if (BigDecimal.ZERO.compareTo(balance.remainder(VALUE_OF_DIME)) == 0) {
//                    //System.out.println("added dime");
//                    dimes++;
//                    //System.out.println("dimes = " + dimes);
//                    //System.out.println("subtracting from balance.");
//                    balance = balance.subtract(VALUE_OF_DIME);
//                    //System.out.println();
//                    //System.out.println("balance = " + balance);
//                } else if (BigDecimal.ZERO.compareTo(balance.remainder(VALUE_OF_NICKLE)) == 0) {
//                    //System.out.println("added nickle");
//                    nickles++;
//                    //System.out.println("nickles = " + nickles);
//                    //System.out.println("subtracting from balance.");
//                    balance = balance.subtract(VALUE_OF_NICKLE);
//                    //System.out.println("balance = " + balance);
//                }
//            }
//            System.out.printf("Balance: %s Quarters: %d Dimes: %d Nickles: %d", balance, quarters, dimes, nickles);
//        } catch (Exception e) {
//            System.out.println("Error in giveCorrectChange");
//        }
//    }
}

