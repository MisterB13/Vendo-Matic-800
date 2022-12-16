package com.techelevator.data;

import com.techelevator.models.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Log extends Product {
    LocalTime localTime;
    LocalDate localDate;
    String logLine = localDate.getMonth() + "/" + localDate.getDayOfMonth() + "/" + localDate.getYear() + " " + localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond() + " ";

    private String filePath = "module-1-capstone/Log.txt";

    public Log(String name, double price, String type) {
        super(name, price, type);
    }

    public void changeLog(String logLine) {
        File log = new File(filePath);
        try (PrintWriter addLog = new PrintWriter(new FileOutputStream(log, true))){

        } catch (FileNotFoundException fnaf) {
            System.err.println("File doesn't exist, but really, does anything?");
        } catch (Exception e) {
            System.err.println("There was an unknown error with the log. You might want to look into that.");
        }
    }

    @Override
    public String makeSound() {
        return null;
    }
}
