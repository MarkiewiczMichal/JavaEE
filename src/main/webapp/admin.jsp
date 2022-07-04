<%@ page import="com.example.javaeereimbursementapp.Receipt" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
    <style>

        input[type=number], [type=text] {
            width: 15%;
            padding: 5px 5px;
            margin: 8px 0;
            border-radius: 10px;
            background-color: lightgoldenrodyellow;
        }
        input[type=submit] {
            width: 100%;
            height: 5%;
            padding: 5px 5px;
            margin: 8px 0;
            border-radius: 10px;
            background-color: lightgoldenrodyellow;
        }

    </style>
</head>
<body style="background: rgb(56,239,125);
background: radial-gradient(circle, rgba(56,239,125,1) 0%, rgba(17,153,142,1) 100%);">
<jsp:include page="header.jsp"/>
<div class="clear" style="margin: auto; width: 900px;">
    <h1>Administration panel</h1>
    <div style="border: 2px solid red; padding: 5px 5px;">
        Current daily allowance rate:
        <b><%= request.getAttribute("dailyAllowanceRate")%>
        </b> $
        <br>
        Current car rate mileage:
        <b><%= request.getAttribute("carMileageRate") %>
        </b> $/km
        <br>
        Current car mileage limit:
        <b><%= request.getAttribute("carMileageLimit") %>
        </b> km
        <br>
        Current total reimbursement limit:
        <b><%= request.getAttribute("totalReimbursementLimit")%>
        </b> $
        <br>
        Current possible type of receipt:
        <b><%= request.getAttribute("listOfReceipt") %>
        </b>
        <br>
        Current limit per this type of receipt:
        <b><%= request.getAttribute("limitPerReceiptType") %>
        </b>
    </div>


    <div>
        <form action="admin" method="POST">
            Type new daily allowance rate:
            <input type="number" name="dailyAllowanceRate" step="0.01" min="0"
                   placeholder="Current rate:<%= request.getAttribute("dailyAllowanceRate")%>">$

            <br>
            Type new car rate mileage:
            <input type="number" name="carMileageRate" step="0.01" min="0"
                   placeholder="Current rate:<%= request.getAttribute("carMileageRate") %>">$/km
            <br>
            Type new car mileage limit:
            <input type="number" name="carMileageLimit" step="1" min="0"
                   placeholder="Current limit:<%= request.getAttribute("carMileageLimit") %>">km
            <br>
            Type new total reimbursement limit:
            <input type="number" name="totalReimbursementLimit" setp="1" min="0"
                   placeholder="Curr. limit: <%= request.getAttribute("totalReimbursementLimit")%>">$
            <br>
            <br>
            Set new possible receipt type:
            <% List<Receipt> listOfReceipt = (List<Receipt>) request.getAttribute("listOfReceipt");
                Map<String, Double> limitPerReceiptType = (Map<String, Double>) request.getAttribute("limitPerReceiptType");
                Receipt receipt0 = (Receipt) request.getAttribute("onMap0");
                Receipt receipt1 = (Receipt) request.getAttribute("onMap1");
                Receipt receipt2 = (Receipt) request.getAttribute("onMap2");
                Receipt receipt3 = (Receipt) request.getAttribute("onMap3");
                Receipt receipt4 = (Receipt) request.getAttribute("onMap4");
            %>
            <div>
                First: <input type="text" name="firstFromList"
                              value="<%= listOfReceipt.get(0).getName() %>"> Current limit per this type of receipt:
                <input type="number" name="firstFromListValue"
                       placeholder="<%= limitPerReceiptType.get(receipt0.getName()) %>"
                       value="<%= limitPerReceiptType.get(receipt0.getName()) %>" min="0">$
                <br>
                Second: <input type="text" name="secondFromList"
                               value="<%= listOfReceipt.get(1).getName() %>"> Current limit per this type of receipt:
                <input type="number" name="secondFromListValue"
                       placeholder="<%= limitPerReceiptType.get(receipt1.getName()) %>"
                       value="<%= limitPerReceiptType.get(receipt1.getName()) %>" min="0">$
                <br>
                Third <input type="text" name="thirdFromList"
                             value="<%= listOfReceipt.get(2).getName() %>"> Current limit per this type of receipt:
                <input type="number" name="thirdFromListValue"
                       placeholder="<%= limitPerReceiptType.get(receipt2.getName()) %>"
                       value="<%= limitPerReceiptType.get(receipt2.getName()) %>" min="0">$
                <br>
                Fourth <input type="text" name="fourthFromList"
                              value="<%= listOfReceipt.get(3).getName() %>"> Current limit per this type of receipt:
                <input type="number" name="fourthFromListValue"
                       placeholder="<%= limitPerReceiptType.get(receipt3.getName()) %>"
                       value="<%= limitPerReceiptType.get(receipt3.getName()) %>" min="0">$
                <br>
                Fifth <input type="text" name="fifthFromList"
                             value="<%= listOfReceipt.get(4).getName() %>"> Current limit per this type of receipt:
                <input type="number" name="fifthFromListValue"
                       placeholder="<%= limitPerReceiptType.get(receipt4.getName()) %>"
                       value="<%= limitPerReceiptType.get(receipt4.getName()) %>" min="0">$
            </div>

            <br>
            <input type="submit" value="Submit"/>
        </form>
    </div>
</div>
</body>
</html>
