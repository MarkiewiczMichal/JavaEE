package com.example.javaeereimbursementapp;

public class ReturnCounter {
    private double carMileageReturnAmount;
    private double dailyAllowanceReturnAmount;

    public void setCarMileageReturnAmount(Reimbursement reimbursement) {
        if (reimbursement.getCarMileage() > AdminReimbursementPanel.getCarMileageLimit()) {
            reimbursement.setCarMileage(AdminReimbursementPanel.getCarMileageLimit());
        }
        this.carMileageReturnAmount = reimbursement.getCarMileage() * AdminReimbursementPanel.getCarMileageRate();
    }

    public void setDailyAllowanceReturnAmount(Reimbursement reimbursement) {
        this.dailyAllowanceReturnAmount = reimbursement.getNumberDaysOfDailyAllowance() * AdminReimbursementPanel.getDailyAllowanceRate();
    }

    public double getCarMileageReturnAmount() {
        return carMileageReturnAmount;
    }

    public double getDailyAllowanceReturnAmount() {
        return dailyAllowanceReturnAmount;
    }
}
