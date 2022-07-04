package com.example.javaeereimbursementapp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReturnCounterTest {

    void initListofReceipt() {
        Receipt receiptTaxi = new Receipt("taxi");
        Receipt receiptRestaurant = new Receipt("restaurant");
        Receipt receiptHotel = new Receipt("hotel");
        Receipt receiptAuto = new Receipt("auto");
        Receipt receiptTrain = new Receipt("train");
        List<Receipt> receiptList = new ArrayList<>();
        receiptList.add(receiptTaxi);
        receiptList.add(receiptHotel);
        receiptList.add(receiptRestaurant);
        receiptList.add(receiptAuto);
        receiptList.add(receiptTrain);

        Map<String, Double> limitPerReceiptType = new HashMap<>();
        limitPerReceiptType.put(receiptTaxi.getName(), 150.0);
        limitPerReceiptType.put(receiptHotel.getName(), 150.0);
        limitPerReceiptType.put(receiptRestaurant.getName(), 150.0);
        limitPerReceiptType.put(receiptAuto.getName(), 150.0);
        limitPerReceiptType.put(receiptTrain.getName(), 150.0);

        AdminReimbursementPanel.setListOfReceipt(receiptList);
        AdminReimbursementPanel.setLimitPerReceiptType(limitPerReceiptType);
    }

    @Test
    void setReturnAmountAllReceipts() {
        //given
        Reimbursement reimbursement = new Reimbursement();
        ReturnCounter returnCounter = new ReturnCounter();
        initListofReceipt();
        Receipt receiptRestaurant = new Receipt("restaurant");
        //when
        reimbursement.addReceipt(receiptRestaurant);
        returnCounter.setReturnAmountAllReceipts(reimbursement);

        //then
        // no amount set in receipt
        assertEquals(0, returnCounter.getReturnAmountAllReceipts());

        //and then
        // amount is bigger then limit
        receiptRestaurant.setAmount(200);
        returnCounter.setReturnAmountAllReceipts(reimbursement);
        assertEquals(150, returnCounter.getReturnAmountAllReceipts());

        //and then
        receiptRestaurant.setAmount(-1);
        returnCounter.setReturnAmountAllReceipts(reimbursement);
        assertEquals(0, returnCounter.getReturnAmountAllReceipts());

    }

    @Test
    void setTotalReimbursementReturnAmount() {
        //given
        Reimbursement reimbursement = new Reimbursement();
        ReturnCounter returnCounter = new ReturnCounter();
        initListofReceipt();
        Receipt receiptRestaurant = new Receipt("restaurant");
        reimbursement.addReceipt(receiptRestaurant);
        receiptRestaurant.setAmount(200);
        reimbursement.setCarMileage(1200);
        reimbursement.setNumberDaysOfDailyAllowance(LocalDate.of(2022, 1, 12),
                LocalDate.of(2022, 1, 13));
        //when
        returnCounter.setTotalReimbursementReturnAmount(reimbursement);
        //then
        assertEquals(525,returnCounter.getTotalReimbursementReturnAmount());

        //and then
        // amount is bigger then limit
        reimbursement.setNumberDaysOfDailyAllowance(LocalDate.of(2021, 1, 12),
                LocalDate.of(2022, 1, 13));
        returnCounter.setTotalReimbursementReturnAmount(reimbursement);
        assertEquals(2000,returnCounter.getTotalReimbursementReturnAmount());
    }

    @Test
    void setCarMileageReturnAmount() {
        //given
        Reimbursement reimbursement = new Reimbursement();
        ReturnCounter returnCounter = new ReturnCounter();
        //when
        reimbursement.setCarMileage(1200);
        returnCounter.setCarMileageReturnAmount(reimbursement);
        //then
        assertEquals(1200*0.3, returnCounter.getCarMileageReturnAmount());
        //and then
        /*
        Actual car mileage limit is set to 1500 km so every kilometer over this limit
        aren't counted
         */
        reimbursement.setCarMileage(2500);
        returnCounter.setCarMileageReturnAmount(reimbursement);
        assertEquals(1500 * 0.3, returnCounter.getCarMileageReturnAmount());

        //and then
        reimbursement.setCarMileage(0);
        returnCounter.setCarMileageReturnAmount(reimbursement);
        assertEquals(0, returnCounter.getCarMileageReturnAmount());

        //and then
        reimbursement.setCarMileage(-1);
        returnCounter.setCarMileageReturnAmount(reimbursement);
        assertEquals(0, returnCounter.getCarMileageReturnAmount());
    }

    @Test
    void setDailyAllowanceReturnAmount() {
        //given
        Reimbursement reimbursement = new Reimbursement();
        ReturnCounter returnCounter = new ReturnCounter();
        //when
        reimbursement.setNumberDaysOfDailyAllowance(LocalDate.of(2022, 1, 12),
                LocalDate.of(2022, 1, 13));
        returnCounter.setDailyAllowanceReturnAmount(reimbursement);
        //then
        // 1 day
        assertEquals(15, returnCounter.getDailyAllowanceReturnAmount());

        //and then
        // end date is before start date
        reimbursement.setNumberDaysOfDailyAllowance(LocalDate.of(2022, 1, 12),
                LocalDate.of(2021, 1, 13));
        returnCounter.setDailyAllowanceReturnAmount(reimbursement);
        assertEquals(0, returnCounter.getDailyAllowanceReturnAmount());

        //and then
        // 5 days
        reimbursement.setNumberDaysOfDailyAllowance(LocalDate.of(2022, 1, 12),
                LocalDate.of(2022, 1, 17));
        returnCounter.setDailyAllowanceReturnAmount(reimbursement);
        assertEquals(75, returnCounter.getDailyAllowanceReturnAmount());
    }
}