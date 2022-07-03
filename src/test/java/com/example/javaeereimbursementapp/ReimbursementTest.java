package com.example.javaeereimbursementapp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReimbursementTest {


    @Test
    void getName() {
        //given
        Reimbursement reimbursement;
        //when
        reimbursement = new Reimbursement();
        //then
        assertEquals("1", reimbursement.getName());

        //and then
        reimbursement = new Reimbursement();
        assertEquals("2", reimbursement.getName());
    }

    @Test
    void setNumberDaysOfDailyAllowance() {
        //given
        Reimbursement reimbursement = new Reimbursement();
        //when
        reimbursement.setNumberDaysOfDailyAllowance(LocalDate.of(2022, 1, 12),
                LocalDate.of(2022, 1, 13));
        //then
        // 1 day
        assertEquals(1, reimbursement.getNumberDaysOfDailyAllowance());
        //and then
        // end date is before start date
        reimbursement.setNumberDaysOfDailyAllowance(LocalDate.of(2022, 1, 12),
                LocalDate.of(2021, 1, 13));

        assertEquals(0, reimbursement.getNumberDaysOfDailyAllowance());
        //and then
        // 5 days
        reimbursement.setNumberDaysOfDailyAllowance(LocalDate.of(2022, 1, 12),
                LocalDate.of(2022, 1, 17));

        assertEquals(5, reimbursement.getNumberDaysOfDailyAllowance());
    }
}