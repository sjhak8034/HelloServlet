package org.hello.helloservlet.web.frontcontroller.v3.controller;

import org.hello.helloservlet.member.Member;
import org.hello.helloservlet.member.MemberRepository;
import org.hello.helloservlet.web.frontcontroller.ModelView;
import org.hello.helloservlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> parameters) {
        String username = parameters.get("username");
        int age = Integer.parseInt(parameters.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);
        ModelView mv =  new ModelView("save-result");
        mv.getModel().put(
                "member", member
        );
        return mv;
    }
}
