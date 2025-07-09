package org.hello.helloservlet.web.frontcontroller.v5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.helloservlet.web.frontcontroller.ModelView;
import org.hello.helloservlet.web.frontcontroller.MyView;
import org.hello.helloservlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import org.hello.helloservlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import org.hello.helloservlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import org.hello.helloservlet.web.frontcontroller.v4.ControllerV4;
import org.hello.helloservlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import org.hello.helloservlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import org.hello.helloservlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import org.hello.helloservlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import org.hello.helloservlet.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;
import org.springframework.web.servlet.HandlerAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {
    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new
                MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new
                MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new
                MemberListControllerV3());
        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new
                MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new
                MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new
                MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        Object handler = getHandler(request);
        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        MyHandlerAdapter adapter = getHandlerAdapter(handler);

        ModelView mv = adapter.handle(request, response, handler);

        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName);
        view.render(mv.getModel(), request, response);
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for( MyHandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }
        throw new IllegalArgumentException("No handler adapter found for handler " + handler);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    // 뷰 이름 -> 뷰 경로로 변환
    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}