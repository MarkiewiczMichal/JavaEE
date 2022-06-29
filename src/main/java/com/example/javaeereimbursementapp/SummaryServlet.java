package com.example.javaeereimbursementapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SummaryServlet", value = "/summary")
public class SummaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      int x= Integer.parseInt( request.getParameter("result"));
        request.setAttribute("result",UserServlet.reimbursementsList.get(x));

        Reimbursement reimB = UserServlet.reimbursementsList.get(x);


        request.setAttribute("nameReimbursement", reimB.getName());
        request.setAttribute("numberDaysOfDailyAllowance", reimB.getNumberDaysOfDailyAllowance());
        RequestDispatcher rd = request.getRequestDispatcher("/summary.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
