package com.example.javaeereimbursementapp.servlets;

import com.example.javaeereimbursementapp.AdminReimbursementPanel;
import com.example.javaeereimbursementapp.Receipt;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdmitServlet", value = "/admin")
public class AdmitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("carMileageRate", AdminReimbursementPanel.getCarMileageRate());
        request.setAttribute("dailyAllowanceRate", AdminReimbursementPanel.getDailyAllowanceRate());
        request.setAttribute("carMileageLimit", AdminReimbursementPanel.getCarMileageLimit());
        request.setAttribute("listOfReceipt", AdminReimbursementPanel.getListOfReceipt());
        request.setAttribute("limitPerReceiptType", AdminReimbursementPanel.getLimitPerReceiptType());
        request.setAttribute("totalReimbursementLimit", AdminReimbursementPanel.getTotalReimbursementLimit());

        request.setAttribute("onMap0", AdminReimbursementPanel.getListOfReceipt().get(0));
        request.setAttribute("onMap1", AdminReimbursementPanel.getListOfReceipt().get(1));
        request.setAttribute("onMap2", AdminReimbursementPanel.getListOfReceipt().get(2));
        request.setAttribute("onMap3", AdminReimbursementPanel.getListOfReceipt().get(3));
        request.setAttribute("onMap4", AdminReimbursementPanel.getListOfReceipt().get(4));
        RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringCarMileageRate = request.getParameter("carMileageRate");
        String stringDailyAllowanceRate = request.getParameter("dailyAllowanceRate");
        String stringCarMileageLimit = request.getParameter("carMileageLimit");
        String stringTotalReimbursementLimit =request.getParameter("totalReimbursementLimit");

        String stringFirstFromList = request.getParameter("firstFromList");
        String stringSecondFromList = request.getParameter("secondFromList");
        String stringThirdFromList = request.getParameter("thirdFromList");
        String stringFourthFromList = request.getParameter("fourthFromList");
        String stringFifthFromList = request.getParameter("fifthFromList");

        String string1FromListValue = request.getParameter("firstFromListValue");
        String string2FromListValue = request.getParameter("secondFromListValue");
        String string3FromListValue = request.getParameter("thirdFromListValue");
        String string4FromListValue = request.getParameter("fourthFromListValue");
        String string5FromListValue = request.getParameter("fifthFromListValue");

        if (stringTotalReimbursementLimit != null && !stringTotalReimbursementLimit.equals("")){
            double totalReimbursementLimit = Double.parseDouble(stringTotalReimbursementLimit);
            AdminReimbursementPanel.setTotalReimbursementLimit(totalReimbursementLimit);
        }

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
            Map<String, Double> limitPerReceiptType = new HashMap<>();

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

            if (string1FromListValue != null && !string1FromListValue.equals("")) {
                double firstFromListValue = Double.parseDouble(string1FromListValue);
                limitPerReceiptType.put(firstReceipt.getName(), firstFromListValue);
            }
            if (string2FromListValue != null && !string2FromListValue.equals("")) {
                double secondFromListValue = Double.parseDouble(string2FromListValue);
                limitPerReceiptType.put(secondReceipt.getName(), secondFromListValue);
            }
            if (string3FromListValue != null && !string3FromListValue.equals("")) {
                double thirdFromListValue = Double.parseDouble(string3FromListValue);
                limitPerReceiptType.put(thirdReceipt.getName(), thirdFromListValue);
            }
            if (string4FromListValue != null && !string4FromListValue.equals("")) {
                double fourthFromListValue = Double.parseDouble(string4FromListValue);
                limitPerReceiptType.put(fourthReceipt.getName(), fourthFromListValue);
            }
            if (string5FromListValue != null && !string5FromListValue.equals("")) {
                double fifthFromListValue = Double.parseDouble(string5FromListValue);
                limitPerReceiptType.put(fifthReceipt.getName(), fifthFromListValue);
            }


            AdminReimbursementPanel.setListOfReceipt(receiptList);
            AdminReimbursementPanel.setLimitPerReceiptType(limitPerReceiptType);


        }

        response.sendRedirect("/admin");

    }
}
