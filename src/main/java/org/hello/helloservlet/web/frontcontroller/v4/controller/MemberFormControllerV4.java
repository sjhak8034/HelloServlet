package org.hello.helloservlet.web.frontcontroller.v4.controller;

import org.hello.helloservlet.member.Member;
import org.hello.helloservlet.member.MemberRepository;
import org.hello.helloservlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {

    @Override
    public String process(Map<String, String> parameters, Map<String, Object> model) {
        return "new-form";
    }
}
