package com.example.javaeereimbursementapp;

import java.util.ArrayList;
import java.util.List;

public class AdminReimbursementPanel {

    private static List<Receipt> listOfReceipt;
    private static double carMileageRate = 0.3;
    private static double dailyAllowanceRate = 15;

    private static int carMileageLimit = 1500;

    public static void setListOfReceipt(List<Receipt> listOfReceipt) {
        AdminReimbursementPanel.listOfReceipt = listOfReceipt;
    }

    public static void setCarMileageRate(double carMileageRate) {
        AdminReimbursementPanel.carMileageRate = carMileageRate;
    }

    public static void setDailyAllowanceRate(double dailyAllowanceRate) {
        AdminReimbursementPanel.dailyAllowanceRate = dailyAllowanceRate;
    }

    public static void setCarMileageLimit(int carMileageLimit) {
        AdminReimbursementPanel.carMileageLimit = carMileageLimit;
    }

    public static List<Receipt> getListOfReceipt() {
        return listOfReceipt;
    }

    public static double getCarMileageRate() {
        return carMileageRate;
    }

    public static double getDailyAllowanceRate() {
        return dailyAllowanceRate;
    }

    public static int getCarMileageLimit() {
        return carMileageLimit;
    }
}
