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
<b><%= request.getAttribute("dailyAllowanceRate")%></b> $
<br>
Current car rate mileage:
<b><%= request.getAttribute("carMileageRate") %></b> $/km

<br>
<br>
<div>
    <form action="admin" method="POST">
        Type new daily allowance rate: <input type="number" name="dailyAllowanceRate"
                                              placeholder="Current rate:<%= request.getAttribute("dailyAllowanceRate")%>"
                                              value="<%= request.getAttribute("dailyAllowanceRate")%>">$

        <br>
        Type new car rate mileage: <input type="number" name="carMileageRate"
                                          placeholder="Current rate:<%= request.getAttribute("carMileageRate") %>"
                                          value="<%= request.getAttribute("carMileageRate") %>">$/km
        <br>
        <input type="submit" value="Submit"/>
    </form>

    <a href="carMillageRate.jsp">Set Car Millage Rate</a>
    <br>

    <form action="listOfreceiptToEdit.jsp" method="POST">
        <input type="submit" value="Edit list of available receipt"/>
    </form>
    <br>

    <form action="reimbursementDailyLimit.jsp" method="POST">
        <input type="submit" value="Set reimbursement daily limit"/>
    </form>
    <br>

    <form action="carMillageLimit.jsp" method="POST">
        <input type="submit" value="Set car millage limit"/>
    </form>
    <br>

    <form action="totalReimbursementLimit.jsp" method="POST">
        <input type="submit" value="Set total reimbursement limit"/>
    </form>
    <br>

    to be continued...
</div>
</body>
</html>
