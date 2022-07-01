<%@ page import="com.example.javaeereimbursementapp.Receipt" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
    <style>
        a {
            text-decoration: none;
            font-size: 20px;
        }

    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1><%= "Panel administracyjny" %>
</h1>
<br>
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
Current possible type of receipt:
<b><%= request.getAttribute("listOfReceipt") %>
</b>
<br>
Current limit per this type of receipt:
<b><%= request.getAttribute("limitPerReceiptType") %>
</b>
<br>


<br>
<br>
<div>
    <form action="admin" method="POST">
        Type new daily allowance rate: <input type="number" name="dailyAllowanceRate" step="0.01"
                                              placeholder="Current rate:<%= request.getAttribute("dailyAllowanceRate")%>"
                                              value="<%= request.getAttribute("dailyAllowanceRate")%>">$

        <br>
        Type new car rate mileage: <input type="number" name="carMileageRate" step="0.01"
                                          placeholder="Current rate:<%= request.getAttribute("carMileageRate") %>"
    <%--                                          value="<%= request.getAttribute("carMileageRate") %>">$/km--%>>$/km
        <br>
        Type new car mileage limit: <input type="number" name="carMileageLimit" step="1" min="0"
                                           placeholder="Current limit:<%= request.getAttribute("carMileageLimit") %>"
    <%--                                           value="<%= request.getAttribute("carMileageLimit") %>"> km--%>>
        <br><br>
        Set new possible receipt type:
        <% List<Receipt> listOfReceipt = (List<Receipt>) request.getAttribute("listOfReceipt");
            Map<Receipt, Double> limitPerReceiptType = (Map<Receipt, Double>) request.getAttribute("limitPerReceiptType");
            Receipt receipt0 = (Receipt) request.getAttribute("onMap0");
            Receipt receipt1 = (Receipt) request.getAttribute("onMap1");
            Receipt receipt2 = (Receipt) request.getAttribute("onMap2");
            Receipt receipt3 = (Receipt) request.getAttribute("onMap3");
            Receipt receipt4 = (Receipt) request.getAttribute("onMap4");
        %>
        <div>
            First: <input type="text" name="firstFromList"
                          value="<%= listOfReceipt.get(0).getName() %>"> Current limit per this type of receipt:
            <input type="number" name="firstFromListValue" placeholder="<%= limitPerReceiptType.get(receipt0) %>"
            value="<%= limitPerReceiptType.get(receipt0) %>" min="0">$
            <br>
            Second: <input type="text" name="secondFromList"
                           value="<%= listOfReceipt.get(1).getName() %>"> Current limit per this type of receipt:
            <input type="number" name="secondFromListValue" placeholder="<%= limitPerReceiptType.get(receipt1) %>"
            value="<%= limitPerReceiptType.get(receipt1) %>" min="0">$
            <br>
            Third <input type="text" name="thirdFromList"
                         value="<%= listOfReceipt.get(2).getName() %>"> Current limit per this type of receipt:
            <input type="number" name="thirdFromListValue" placeholder="<%= limitPerReceiptType.get(receipt2) %>"
            value="<%= limitPerReceiptType.get(receipt2) %>" min="0">$
            <br>
            Fourth <input type="text" name="fourthFromList"
                          value="<%= listOfReceipt.get(3).getName() %>"> Current limit per this type of receipt:
            <input type="number" name="fourthFromListValue" placeholder="<%= limitPerReceiptType.get(receipt3) %>"
            value="<%= limitPerReceiptType.get(receipt3) %>" min="0">$
            <br>
            Fifth <input type="text" name="fifthFromList"
                         value="<%= listOfReceipt.get(4).getName() %>"> Current limit per this type of receipt:
            <input type="number" name="fifthFromListValue" placeholder="<%= limitPerReceiptType.get(receipt4) %>"
            value="<%= limitPerReceiptType.get(receipt4) %>" min="0">$
        </div>

        <input type="submit" value="Submit"/>
    </form>


    to be continued...
</div>
</body>
</html>
