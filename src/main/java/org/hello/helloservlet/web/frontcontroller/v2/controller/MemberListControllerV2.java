package org.hello.helloservlet.web.frontcontroller.v2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.helloservlet.member.Member;
import org.hello.helloservlet.member.MemberRepository;
import org.hello.helloservlet.web.frontcontroller.MyView;
import org.hello.helloservlet.web.frontcontroller.v1.ControllerV1;
import org.hello.helloservlet.web.frontcontroller.v2.ControllerV2;

import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);
        String viewPath = "/WEB-INF/views/members.jsp";
        return new MyView(viewPath);
    }
}
