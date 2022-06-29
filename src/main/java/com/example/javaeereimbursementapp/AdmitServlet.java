package com.example.javaeereimbursementapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdmitServlet", value = "/admin")
public class AdmitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("carMileageRate", AdminReimbursementPanel.getCarMileageRate());
        request.setAttribute("dailyAllowanceRate", AdminReimbursementPanel.getDailyAllowanceRate());
        RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringCarMileageRate = request.getParameter("carMileageRate");
        String stringDailyAllowanceRate = request.getParameter("dailyAllowanceRate");

        if (stringCarMileageRate != null && !stringCarMileageRate.equals("")) {
            double carMileage = Double.parseDouble(stringCarMileageRate);
            AdminReimbursementPanel.setCarMileageRate(carMileage);
        }

        if (stringDailyAllowanceRate != null && !stringDailyAllowanceRate.equals("")) {
            double dailyAllowanceRate = Double.parseDouble(stringDailyAllowanceRate);
            AdminReimbursementPanel.setDailyAllowanceRate(dailyAllowanceRate);
        }

        response.sendRedirect("/admin");

    }
}
