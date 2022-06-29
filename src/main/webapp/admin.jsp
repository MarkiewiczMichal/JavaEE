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
<br>
<div>
    <form action="admin" method="POST">
        Type new daily allowance rate: <input type="number" name="dailyAllowanceRate" step="0.01"
                                              placeholder="Current rate:<%= request.getAttribute("dailyAllowanceRate")%>"
                                              value="<%= request.getAttribute("dailyAllowanceRate")%>">$

        <br>
        Type new car rate mileage: <input type="number" name="carMileageRate" step="0.01"
                                          placeholder="Current rate:<%= request.getAttribute("carMileageRate") %>"
                                          value="<%= request.getAttribute("carMileageRate") %>">$/km
        <br>
        Type ner car mileage limit: <input type="number" name="carMileageLimit" step="0.01"
                                           placeholder="Current limit:<%= request.getAttribute("carMileageLimit") %>"
                                           value="<%= request.getAttribute("carMileageLimit") %>"> km
        <br>

        <input type="submit" value="Submit"/>
    </form>


    to be continued...
</div>
</body>
</html>
