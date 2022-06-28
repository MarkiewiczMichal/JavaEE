package com.example.javaeereimbursementapp;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class Reimbursement {
    private final String name;
    private int id = 0;
    private double carMileageRate = 0.3;
    private double dailyAllowanceRate = 15;
    private List<Receipt> listOfReceipt;
    private int numberDaysOfDailyAllowance;
    private int carMileage;

    public Reimbursement(String name) {
        this.name = name;
        id++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getCarMileageRate() {
        return carMileageRate;
    }

    public void setCarMileageRate(double carMileageRate) {
        this.carMileageRate = carMileageRate;
    }

    public double getDailyAllowanceRate() {
        return dailyAllowanceRate;
    }

    public void setDailyAllowanceRate(double dailyAllowanceRate) {
        this.dailyAllowanceRate = dailyAllowanceRate;
    }

    public void setNumberDaysOfDailyAllowance(LocalDate start, LocalDate end) {
        Duration diference = Duration.between(start.atStartOfDay(), end.atStartOfDay());
      numberDaysOfDailyAllowance=(int)(diference.toDays());
    }

    public int getNumberDaysOfDailyAllowance() {
        return numberDaysOfDailyAllowance;
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(int carMileage) {
        this.carMileage = carMileage;
    }

    public List<Receipt> getListOfReceipt() {
        return listOfReceipt;
    }
}
