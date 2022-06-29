package com.example.javaeereimbursementapp;

public class Receipt {
    private final String name;
    private double amount;

    public Receipt(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return name;
    }
}
