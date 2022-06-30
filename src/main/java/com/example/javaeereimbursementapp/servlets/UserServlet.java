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
import java.util.List;

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

        AdminReimbursementPanel.setListOfReceipt(receiptList);
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

        Reimbursement reimbursement = new Reimbursement();
        Receipt receipt = new Receipt(stringSelect);
        Receipt receipt2 = new Receipt(stringSelect2);
//        Receipt receipt = new Receipt(nameReimbursement);
//
        reimbursement.addReceipt(receipt);
        reimbursement.addReceipt(receipt2);


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
}
