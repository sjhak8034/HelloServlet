package org.hello.helloservlet.web.frontcontroller.v2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.helloservlet.web.frontcontroller.MyView;

import java.io.IOException;

public interface ControllerV2 {
    MyView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}