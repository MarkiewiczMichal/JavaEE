<%@ page import="com.example.javaeereimbursementapp.Reimbursement" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div>
    <h1>Summary your reimbursement claim</h1>
    <br>
    Number of your reimbursement:
    <%= request.getAttribute("nameReimbursement") %>
    <br>
    Number of days for which the refund is due:
    <%= request.getAttribute("numberDaysOfDailyAllowance") %> day/days
    <br>
    Car mileage:
    <%= request.getAttribute("carMileage")%> km
    <br>
    Car mileage return amount:
    <%= request.getAttribute("carMileageReturnAmount")%> $
    <br>
    Daily allowance return amount:
    <%= request.getAttribute("dailyAllowanceReturnAmount")%> $
    <br>
    List of receipts on this reimbursement:
    <%= request.getAttribute("listOfReceipt")%>
    <br>
</div>

___
</body>
</html>
