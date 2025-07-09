package org.hello.helloservlet.web.frontcontroller.v3.controller;

import org.hello.helloservlet.member.MemberRepository;
import org.hello.helloservlet.web.frontcontroller.ModelView;
import org.hello.helloservlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String,String> parameters) {
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", memberRepository.findAll());
        return mv;
    }
}
