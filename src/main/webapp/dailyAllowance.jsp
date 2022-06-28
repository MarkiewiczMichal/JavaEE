<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="clear">
    <form action="/ServletListType" method="POST">
        <label>simple calculation:
            <input type="text" name="name"/>
        </label>
        <input type="submit" name="dailyAllowance" value="Go to list of receipts"/>
    </form>
</div>
</body>
</html>
