package com.example.javaeereimbursementapp;

public class ReturnCounter {
    private double carMileageReturnAmount;
    private double dailyAllowanceReturnAmount;

    private double totalAmountReimbursement;

    public void setTotalAmountReimbursement(Reimbursement reimbursement) {
        double tempTotalAmount = 0;
        double tempPerReceiptTypeAmount = 0;
        for (Receipt receipt : reimbursement.getListOfReceipt()) {

            if (receipt.getAmount() > AdminReimbursementPanel.getLimitPerReceiptType().get(receipt)) {
                tempPerReceiptTypeAmount = AdminReimbursementPanel.getLimitPerReceiptType().get(receipt);
            } else {
                tempPerReceiptTypeAmount = receipt.getAmount();
            }
            tempTotalAmount += tempPerReceiptTypeAmount;
        }
        this.totalAmountReimbursement = tempTotalAmount;
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

    public double getTotalAmountReimbursement() {
        return totalAmountReimbursement;
    }
}
