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
    <form action="dailyAllowance.jsp" method="POST">
        <input type="submit" name="dailyAllowance" value="Set Daily Allowance Rate"/>
    </form>

    <form action="carMillageRate.jsp" method="POST">
        <input type="submit" name="carMillageRate" value="Set Car Millage Rate"/>
    </form>
    <a href="carMillageRate.jsp">Set Car Millage Rate</a>
    <br>

    to be continued...
</body>
</html>
