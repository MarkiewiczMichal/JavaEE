package com.example.javaeereimbursementapp;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reimbursement {
    private final String name;
    private static int id = 1;

    private List<Receipt> listOfReceipt = new ArrayList<>();
    private int numberDaysOfDailyAllowance;
    private int carMileage;

    public Reimbursement() {
        this.name = String.valueOf(id);
        id++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setNumberDaysOfDailyAllowance(LocalDate start, LocalDate end) {
        if (end.isBefore(start)) {
            numberDaysOfDailyAllowance = 0;
        } else {
            Duration difference = Duration.between(start.atStartOfDay(), end.atStartOfDay());
            numberDaysOfDailyAllowance = (int) (difference.toDays());
        }
    }

    public int getNumberDaysOfDailyAllowance() {
        return numberDaysOfDailyAllowance;
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(int carMileage) {
        if (carMileage < 0) this.carMileage = 0;
        else {
            this.carMileage = carMileage;
        }
    }

    public List<Receipt> getListOfReceipt() {
        return listOfReceipt;
    }

    public void addReceipt(Receipt receipt) {
        this.listOfReceipt.add(receipt);
    }

    @Override
    public String toString() {
        return getName();
    }
}
