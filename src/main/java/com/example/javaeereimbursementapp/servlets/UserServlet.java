package com.example.javaeereimbursementapp.servlets;

import com.example.javaeereimbursementapp.AdminReimbursementPanel;
import com.example.javaeereimbursementapp.Receipt;
import com.example.javaeereimbursementapp.Reimbursement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {

    public static List<Reimbursement> reimbursementsList = new ArrayList<>();

    public void init() {
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

        Map<Receipt,Double> limitPerReceiptType = new HashMap<>();
        limitPerReceiptType.put(receiptTaxi,150.0);
        limitPerReceiptType.put(receiptHotel,150.0);
        limitPerReceiptType.put(receiptRestaurant,150.0);
        limitPerReceiptType.put(receiptAuto,150.0);
        limitPerReceiptType.put(receiptTrain,150.0);

        AdminReimbursementPanel.setListOfReceipt(receiptList);
        AdminReimbursementPanel.setLimitPerReceiptType(limitPerReceiptType);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("listOfReceipt", AdminReimbursementPanel.getListOfReceipt());
        request.setAttribute("firstFromList", AdminReimbursementPanel.getListOfReceipt().get(0));
        request.setAttribute("secondFromList", AdminReimbursementPanel.getListOfReceipt().get(1));
        request.setAttribute("thirdFromList", AdminReimbursementPanel.getListOfReceipt().get(2));
        RequestDispatcher rd = request.getRequestDispatcher("/user.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String nameReimbursement = request.getParameter("name");
        String stringCarMileage = request.getParameter("carMileage");
        String dailyAllowanceStart = request.getParameter("dailyAllowanceStart");
        String dailyAllowanceEnd = request.getParameter("dailyAllowanceEnd");

        String stringSelect = request.getParameter("select");
        String stringSelect2 = request.getParameter("select2");
        String stringSelect3 = request.getParameter("select3");
        String stringSelect4 = request.getParameter("select4");
        String stringSelect5 = request.getParameter("select5");

        String stringSelect1Amount =request.getParameter("select1Amount");
        String stringSelect2Amount =request.getParameter("select2Amount");
        String stringSelect3Amount =request.getParameter("select3Amount");
        String stringSelect4Amount =request.getParameter("select4Amount");
        String stringSelect5Amount =request.getParameter("select5Amount");

        Reimbursement reimbursement = new Reimbursement();

//        if (stringSelect != null && !stringSelect.equals("")) {
//            Receipt receipt = new Receipt(stringSelect);
//            reimbursement.addReceipt(receipt);
//            if (stringSelect1Amount != null && !stringSelect1Amount .equals("")) {
//                receipt.setAmount(Double.parseDouble(stringSelect1Amount));
//            }
//        }

        changeSelectToObject(stringSelect, stringSelect1Amount, reimbursement);
        changeSelectToObject(stringSelect2, stringSelect2Amount, reimbursement);
        changeSelectToObject(stringSelect3, stringSelect3Amount, reimbursement);
        changeSelectToObject(stringSelect4, stringSelect4Amount, reimbursement);
        changeSelectToObject(stringSelect5, stringSelect5Amount, reimbursement);

        if (stringCarMileage != null && !stringCarMileage.equals("")) {
            int carMileage = Integer.parseInt(stringCarMileage);
            reimbursement.setCarMileage(carMileage);
        }
        if (dailyAllowanceStart != null && dailyAllowanceEnd != null &&
                !dailyAllowanceStart.equals("") && !dailyAllowanceEnd.equals("")) {
            LocalDate startDate = LocalDate.parse(dailyAllowanceStart);
            LocalDate endDate = LocalDate.parse(dailyAllowanceEnd);
            reimbursement.setNumberDaysOfDailyAllowance(startDate, endDate);
        }

        reimbursementsList.add(reimbursement);
        request.setAttribute("result", reimbursementsList);
        response.sendRedirect("summary?result=" + (reimbursementsList.size() - 1));
    }

    private void changeSelectToObject(String stringSelect, String stringSelect1Amount, Reimbursement reimbursement) {
        if (stringSelect != null && !stringSelect.equals("")) {
            Receipt receipt = new Receipt(stringSelect);
            reimbursement.addReceipt(receipt);
            if (stringSelect1Amount != null && !stringSelect1Amount .equals("")) {
                receipt.setAmount(Double.parseDouble(stringSelect1Amount));
            }
        }
    }
}

