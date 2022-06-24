<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<jsp:include page="header.jsp"/>
<div class="clear">
    <form action="index.jsp" method="POST">
        <label>Reimbursement name:
            <input type="text" name="name"/>
        </label>
        <br>
        <label>
            <input type="checkbox" name="receipts"> have you receipts to refund
        </label>
        <br>
        <input type="submit" value="Send"/>
    </form>
</div>

Work in progress
</body>
</html>
