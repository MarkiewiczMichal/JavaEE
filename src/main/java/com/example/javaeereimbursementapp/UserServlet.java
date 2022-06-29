package com.example.javaeereimbursementapp;

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("listOfReceipts", AdminReimbursementPanel.getListOfReceipt());
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

        Reimbursement reimbursement = new Reimbursement();
        Receipt receipt = new Receipt(nameReimbursement);

        reimbursement.addReceipt(receipt);


        if (stringCarMileage != null && !stringCarMileage.equals("")) {
            int carMileage = Integer.parseInt(stringCarMileage);
            carMileage *= AdminReimbursementPanel.getCarMileageRate();
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
