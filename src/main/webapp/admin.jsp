<%@ page import="com.example.javaeereimbursementapp.Receipt" %>
<%@ page import="java.util.List" %>
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
        Type new car mileage limit: <input type="number" name="carMileageLimit" step="1"
                                           placeholder="Current limit:<%= request.getAttribute("carMileageLimit") %>"
    <%--                                           value="<%= request.getAttribute("carMileageLimit") %>"> km--%>>
        <br><br>
        Set new possible receipt type:
        <% List<Receipt> listOfReceipt = (List<Receipt>) request.getAttribute("listOfReceipt");%>
        <div>
            First: <input type="text" name="firstFromList"
                          value="<%= listOfReceipt.get(0).getName() %>">

            <br>
            Second: <input type="text" name="secondFromList"
                           value="<%= listOfReceipt.get(1).getName() %>">
            <br>
            Third <input type="text" name="thirdFromList"
                         value="<%= listOfReceipt.get(2).getName() %>">
            <br>
            Fourth <input type="text" name="fourthFromList"
                         value="<%= listOfReceipt.get(3).getName() %>">
            <br>
            Fifth <input type="text" name="fifthFromList"
                          value="<%= listOfReceipt.get(4).getName() %>">
        </div>

        <input type="submit" value="Submit"/>
    </form>


    to be continued...
</div>
</body>
</html>
