package org.hello.helloservlet.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends jakarta.servlet.http.HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service() called");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);
        String userName = req.getParameter("username");
        System.out.println("HelloServlet.service() username = " + userName);
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Hello, " + userName + "!\n");
    }
}
