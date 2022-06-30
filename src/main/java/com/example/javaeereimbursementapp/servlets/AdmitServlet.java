package com.example.javaeereimbursementapp.servlets;

import com.example.javaeereimbursementapp.AdminReimbursementPanel;
import com.example.javaeereimbursementapp.Receipt;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdmitServlet", value = "/admin")
public class AdmitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("carMileageRate", AdminReimbursementPanel.getCarMileageRate());
        request.setAttribute("dailyAllowanceRate", AdminReimbursementPanel.getDailyAllowanceRate());
        request.setAttribute("carMileageLimit", AdminReimbursementPanel.getCarMileageLimit());
        request.setAttribute("listOfReceipt", AdminReimbursementPanel.getListOfReceipt());
        RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringCarMileageRate = request.getParameter("carMileageRate");
        String stringDailyAllowanceRate = request.getParameter("dailyAllowanceRate");
        String stringCarMileageLimit = request.getParameter("carMileageLimit");
        String stringFirstFromList = request.getParameter("firstFromList");
        String stringSecondFromList = request.getParameter("secondFromList");
        String stringThirdFromList = request.getParameter("thirdFromList");
        String stringFourthFromList = request.getParameter("fourthFromList");
        String stringFifthFromList = request.getParameter("fifthFromList");

        if (stringCarMileageRate != null && !stringCarMileageRate.equals("")) {
            double carMileage = Double.parseDouble(stringCarMileageRate);
            AdminReimbursementPanel.setCarMileageRate(carMileage);
        }

        if (stringDailyAllowanceRate != null && !stringDailyAllowanceRate.equals("")) {
            double dailyAllowanceRate = Double.parseDouble(stringDailyAllowanceRate);
            AdminReimbursementPanel.setDailyAllowanceRate(dailyAllowanceRate);
        }

        if (stringCarMileageLimit != null && !stringCarMileageLimit.equals("")) {
            int carMileageLimit = Integer.parseInt(stringCarMileageLimit);
            AdminReimbursementPanel.setCarMileageLimit(Math.max(carMileageLimit, 0));
        }

        if (stringFirstFromList != null && !stringFirstFromList.equals("")
                && stringSecondFromList != null && !stringSecondFromList.equals("")
                && stringThirdFromList != null && !stringThirdFromList.equals("")
                && stringFourthFromList != null && !stringFourthFromList.equals("")
                && stringFifthFromList != null && !stringFifthFromList.equals("")) {
            List<Receipt> receiptList = new ArrayList<>();
            Receipt firstReceipt = new Receipt(stringFirstFromList);
            Receipt secondReceipt = new Receipt(stringSecondFromList);
            Receipt thirdReceipt = new Receipt(stringThirdFromList);
            Receipt fourthReceipt = new Receipt(stringFourthFromList);
            Receipt fifthReceipt = new Receipt(stringFifthFromList);
            receiptList.add(firstReceipt);
            receiptList.add(secondReceipt);
            receiptList.add(thirdReceipt);
            receiptList.add(fourthReceipt);
            receiptList.add(fifthReceipt);
            AdminReimbursementPanel.setListOfReceipt(receiptList);

        }

        response.sendRedirect("/admin");

    }
}
