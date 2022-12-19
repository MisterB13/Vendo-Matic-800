package com.techelevator;

import com.techelevator.data.Log;

import java.math.BigDecimal;
import java.util.Scanner;

public class FeedMoney {
    private static final String FEED_MONEY = "FEED_MONEY";
    Log writer = new Log();

    public BigDecimal feedMoney(String choice, BigDecimal runningBalance) {
        Scanner scanner = new Scanner(System.in);

        String feedMoney = scanner.nextLine();
        System.out.println("Feed Money");

        BigDecimal amountToAddBack = new BigDecimal(0);

        System.out.println("1: 1 Dollar");
        System.out.println("2: 5 Dollars");
        System.out.println("3: 10 Dollars");
        System.out.println("4: 20 Dollars");
        System.out.println("0: done");
        boolean feedMoneyLoopContinues = true;
        while(feedMoneyLoopContinues){


        if (choice.equals("1")) {
            amountToAddBack = new BigDecimal(1.00);
            writer.writer(FEED_MONEY, new BigDecimal(1.00).setScale(2), runningBalance.add(amountToAddBack) );
        } else if (choice.equals("2")) {
            amountToAddBack = new BigDecimal(2.00);
            writer.writer(FEED_MONEY, new BigDecimal(2.00).setScale(2), runningBalance.add(amountToAddBack));
        } else if (choice.equals("3")) {
            amountToAddBack = new BigDecimal(5.00);
            writer.writer(FEED_MONEY, new BigDecimal(5.00).setScale(2), runningBalance.add(amountToAddBack));
        } else if (choice.equals("4")) {
            amountToAddBack = new BigDecimal(10.00);
            writer.writer(FEED_MONEY, new BigDecimal(10.00).setScale(2), runningBalance.add(amountToAddBack));
        }
        return amountToAddBack;

        if(choice.equals(0)){
            feedMoneyLoopContinues = false;
        }
    }


}
