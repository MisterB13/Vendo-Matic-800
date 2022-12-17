package com.techelevator.data;

import com.techelevator.models.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Log extends Product {
    LocalTime localTime;
    LocalDate localDate;
    String logLine = localDate.getMonth() + "/" + localDate.getDayOfMonth() + "/" + localDate.getYear() + " " + localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond() + " ";

    private String filePath = "module-1-capstone/Log.txt";

    public Log(String name, BigDecimal price, String type) {
        super(name, price, type);
    }
    public Log(){}




    public void changeLog(String logLine) {
        File log = new File(filePath);
        try (PrintWriter addLog = new PrintWriter(new FileOutputStream(log, true))){

        } catch (FileNotFoundException fnaf) {
            System.err.println("File doesn't exist, but really, does anything?");
        } catch (Exception e) {
            System.err.println("There was an unknown error with the log. You might want to look into that.");
        }
    }
    public void writer(String typeOfTransaction, BigDecimal amount, BigDecimal balance) {

        LocalDate todaysDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(new File("./log.txt"), true))) {

            String printToday = todaysDate.toString();
            String printTime = currentTime.toString().substring(0, currentTime.toString().length() - 4);
            String printAmount = amount.toString();
            String printBalance = balance.toString();

            logWriter.println(printToday + " " + printTime + " " + String.format("%-25s", typeOfTransaction)
                    + String.format("%-10s", "$" + printAmount) + String.format("%-10s", "$" + printBalance));

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    public void writer(String typeOfTransaction, String choice, BigDecimal amount, BigDecimal balance) {

        LocalDate todaysDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(new File("./log.txt"), true))) {

            String printToday = todaysDate.toString();
            String printTime = currentTime.toString().substring(0, currentTime.toString().length() - 4);
            String printAmount = amount.toString();
            String printBalance = balance.toString();

            logWriter.println(printToday + " " + printTime + " " + String.format("%-25s", typeOfTransaction) + String.format("%-25s", choice)
                    + String.format("%-10s", "$" + printAmount) + String.format("%-10s", "$" + printBalance));

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    @Override
    public String makeSound() {
        return null;
    }
}
