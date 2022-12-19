package com.techelevator;

import com.techelevator.data.Log;
import com.techelevator.data.Repo;
import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.Scanner;

public class FeedMoney {
    private static final String FEED_MONEY = "FEED_MONEY";
    Log writer = new Log();


    public BigDecimal feedMoney() {
        BigDecimal runningBalance = BigDecimal.valueOf(14.0);
        runningBalance = runningBalance.add(new BigDecimal(1.0));
        BigDecimal amountToAddBack = new BigDecimal(0);
        while (true) {
            Scanner scanner = new Scanner(System.in);


            System.out.println("Feed Money");




            System.out.println("1: 1 Dollar");
            System.out.println("2: 5 Dollars");
            System.out.println("3: 10 Dollars");
            System.out.println("4: 20 Dollars");
            System.out.println("0: done");
            String choice = scanner.nextLine();



            if (choice.equals("1")) {
                amountToAddBack = new BigDecimal(1.0);
                runningBalance = runningBalance.add(new BigDecimal(1.0));

                writer.writer(FEED_MONEY, new BigDecimal(1.00).setScale(2), runningBalance.add(runningBalance));
                System.out.println("$1 is added, balance is now " + runningBalance);
            } else if (choice.equals("2")) {
                amountToAddBack = new BigDecimal(2.00);
                runningBalance = runningBalance.add(new BigDecimal(5.0));
                writer.writer(FEED_MONEY, new BigDecimal(2.00).setScale(2), runningBalance.add(runningBalance));
                System.out.println("$5 is added, balance is now " + runningBalance);
            } else if (choice.equals("3")) {
                amountToAddBack = new BigDecimal(5.00);
                runningBalance = runningBalance.add(new BigDecimal(10.0));
                writer.writer(FEED_MONEY, new BigDecimal(5.00).setScale(2), runningBalance.add(amountToAddBack));
                System.out.println("$10 is added, balance is now " + runningBalance);
            } else if (choice.equals("4")) {
                amountToAddBack = new BigDecimal(10.00);
                runningBalance = runningBalance.add(new BigDecimal(20.0));
                writer.writer(FEED_MONEY, new BigDecimal(10.00).setScale(2), runningBalance.add(amountToAddBack));
                System.out.println("$20 is added, balance is now " + runningBalance);
            } else if (choice.equals("0")) {
                break;
            }


        }

        return amountToAddBack;
    }



    }
