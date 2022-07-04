<%@ page import="com.example.javaeereimbursementapp.Receipt" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.javaeereimbursementapp.AdminReimbursementPanel" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
</head>
<body style="background: rgb(56,239,125);
background: radial-gradient(circle, rgba(56,239,125,1) 0%, rgba(17,153,142,1) 100%);">
<% Receipt receiptTaxi = new Receipt("taxi");
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

    Map<String, Double> limitPerReceiptType = new HashMap<>();
    limitPerReceiptType.put(receiptTaxi.getName(), 150.0);
    limitPerReceiptType.put(receiptHotel.getName(), 150.0);
    limitPerReceiptType.put(receiptRestaurant.getName(), 150.0);
    limitPerReceiptType.put(receiptAuto.getName(), 150.0);
    limitPerReceiptType.put(receiptTrain.getName(), 150.0);

    AdminReimbursementPanel.setListOfReceipt(receiptList);
    AdminReimbursementPanel.setLimitPerReceiptType(limitPerReceiptType);
%>

<jsp:include page="header.jsp"/>
<div class="clear" style="margin: auto; width: 900px; ">
    <h1>Log in to your account</h1>
    <br/>
    Reimbursement app is easy to use.
    <br>

    <h3>*** As a user you can: ***</h3>
    <ol>
        <li> Create new reimbursement claim</li>
        <li> Add 5 receipts tp claim refund</li>
        <li> Add days or periods for which you get daily allowance</li>
        <li> Add personal car mileage</li>
    </ol>
    <b>App calculate total amount of the reimbursement</b>
    <br>
    <br>
    <h3>*** As an administrator you can: ***</h3>
    <ol>
        <li>Change rates for daily allowance</li>
        <li>Change rates for car mileage</li>
        <li>Edit the list of available receipts types</li>
        <li>Define reimbursement limit per receipt type</li>
        <li>Define total reimbursement limit</li>
        <li>Define limit of number kilometer per reimbursement</li>
    </ol>
</div>
</body>
</html>