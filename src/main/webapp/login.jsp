<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request.getParameterValues("userName")[0].equals("User"))
        response.sendRedirect("user.jsp");
    else response.sendRedirect("admin.jsp");
%>
