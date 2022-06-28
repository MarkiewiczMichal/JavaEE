package com.example.javaeereimbursementapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;


@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.getParameter("namee");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String nameReimbuser = request.getParameter("name");
        String s = request.getParameter("carMileage");
        int carMileage = Integer.parseInt(s);
        PrintWriter out = response.getWriter();
        out.println(nameReimbuser);
        out.println(nameReimbuser.length());

        out.println(carMileage);
        out.println(carMileage * 10);

    }

    public void destroy() {
    }
}