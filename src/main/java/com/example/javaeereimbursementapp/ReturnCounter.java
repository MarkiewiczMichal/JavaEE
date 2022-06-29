package com.example.javaeereimbursementapp;

public class ReturnCounter {
    private double carMileageReturnAmount;
    private double daillyAllowanceReturnAmount;

    public void setCarMileageReturnAmount(Reimbursement reimbursement) {
        this.carMileageReturnAmount = reimbursement.getCarMileage() * AdminReimbursementPanel.getCarMileageRate();
    }

    public void setDaillyAllowanceReturnAmount(Reimbursement reimbursement) {
        this.daillyAllowanceReturnAmount = reimbursement.getNumberDaysOfDailyAllowance() * AdminReimbursementPanel.getDailyAllowanceRate();
    }
}
