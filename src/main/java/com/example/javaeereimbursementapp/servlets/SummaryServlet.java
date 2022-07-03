package com.example.javaeereimbursementapp.servlets;

import com.example.javaeereimbursementapp.Reimbursement;
import com.example.javaeereimbursementapp.ReturnCounter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SummaryServlet", value = "/summary")
public class SummaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int x = Integer.parseInt(request.getParameter("result"));
        request.setAttribute("result", UserServlet.reimbursementsList.get(x));

        Reimbursement reimbursement = UserServlet.reimbursementsList.get(x);

        ReturnCounter returnCounter = new ReturnCounter();
        returnCounter.setCarMileageReturnAmount(reimbursement);
        returnCounter.setDailyAllowanceReturnAmount(reimbursement);
        returnCounter.setTotalReimbursementReturnAmount(reimbursement);

        request.setAttribute("nameReimbursement", reimbursement.getName());
        request.setAttribute("numberDaysOfDailyAllowance", reimbursement.getNumberDaysOfDailyAllowance());
        request.setAttribute("carMileage", reimbursement.getCarMileage());
        request.setAttribute("carMileageReturnAmount",returnCounter.getCarMileageReturnAmount());
        request.setAttribute("dailyAllowanceReturnAmount",returnCounter.getDailyAllowanceReturnAmount());
        request.setAttribute("listOfReceipt",reimbursement.getListOfReceipt());
        request.setAttribute("totalAmountReimbursement", returnCounter.getTotalReimbursementReturnAmount());
        RequestDispatcher rd = request.getRequestDispatcher("/summary.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
