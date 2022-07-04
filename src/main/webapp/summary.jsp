<%@ page import="com.example.javaeereimbursementapp.Reimbursement" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.example.javaeereimbursementapp.Receipt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Summary</title>
</head>
<body style="background: rgb(56,239,125);
background: radial-gradient(circle, rgba(56,239,125,1) 0%, rgba(17,153,142,1) 100%);">
<jsp:include page="header.jsp"/>

<div class="clear" style="margin: auto; width: 900px; border: 2px solid red">
    <h1>Summary your reimbursement claim</h1>
    <br>
    Id of your reimbursement:
    <%= request.getAttribute("nameReimbursement") %>
    <br>
    Number of days for which the refund is due:
    <%= request.getAttribute("numberDaysOfDailyAllowance") %> day/days
    <br>
    Daily allowance return amount:
    <%= request.getAttribute("dailyAllowanceReturnAmount")%> $
    <br>
    Car mileage:
    <%= request.getAttribute("carMileage")%> km
    <br>
    Car mileage return amount:
    <%= request.getAttribute("carMileageReturnAmount")%> $
    <br>
    List of receipts on this reimbursement:
    <%= request.getAttribute("listOfReceipt")%>
    <br>
    -------------------------------------------------------------------
    <br>
    Total amount for this reimbursement:
    <%= request.getAttribute("totalAmountReimbursement")%>
    <br>
    <div>
        <% List<Receipt> receiptList = (List<Receipt>) request.getAttribute("listOfReceipt");
            PrintWriter xyz = response.getWriter();
            xyz.println("Your List of receipts :");
            xyz.println("<br>");
            for (Receipt recipt : receiptList) {
                xyz.println(recipt.getName() + ": ");
                xyz.println(recipt.getAmount() + " $");
                xyz.println("<br>");
            }
            xyz.println("Remember about return limits for each type of receipt");
        %>
    </div>



</div>

</body>
</html>
