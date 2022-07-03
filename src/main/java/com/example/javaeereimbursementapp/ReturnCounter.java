package com.example.javaeereimbursementapp;

public class ReturnCounter {
    private double carMileageReturnAmount;
    private double dailyAllowanceReturnAmount;
    private double returnAmountAllReceipts;
    private double totalReimbursementReturnAmount;


    public void setReturnAmountAllReceipts(Reimbursement reimbursement) {
        double tempTotalReturnAmount = 0;
        double tempPerReceiptTypeAmount;
        for (Receipt receipt : reimbursement.getListOfReceipt()) {

            if (receipt.getAmount() > AdminReimbursementPanel.getLimitPerReceiptType().get(receipt.getName())) {
                tempPerReceiptTypeAmount = AdminReimbursementPanel.getLimitPerReceiptType().get(receipt.getName());
            } else {
                tempPerReceiptTypeAmount = receipt.getAmount();
            }
            tempTotalReturnAmount += tempPerReceiptTypeAmount;
        }
        this.returnAmountAllReceipts = tempTotalReturnAmount;
    }

    public void setTotalReimbursementReturnAmount(Reimbursement reimbursement) {
        double tempTotalAmount = 0;

        setCarMileageReturnAmount(reimbursement);
        setDailyAllowanceReturnAmount(reimbursement);
        setReturnAmountAllReceipts(reimbursement);

        tempTotalAmount += getReturnAmountAllReceipts();
        tempTotalAmount += getCarMileageReturnAmount();
        tempTotalAmount += getDailyAllowanceReturnAmount();

        if (tempTotalAmount > AdminReimbursementPanel.getTotalReimbursementLimit()) {
            tempTotalAmount = AdminReimbursementPanel.getTotalReimbursementLimit();
        }
        this.totalReimbursementReturnAmount = tempTotalAmount;
    }

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

    public double getTotalReimbursementReturnAmount() {
        return totalReimbursementReturnAmount;
    }

    public double getReturnAmountAllReceipts() {
        return returnAmountAllReceipts;
    }
}
