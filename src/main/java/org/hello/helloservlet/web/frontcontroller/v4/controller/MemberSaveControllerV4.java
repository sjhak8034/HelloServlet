package org.hello.helloservlet.web.frontcontroller.v4.controller;

import org.hello.helloservlet.member.Member;
import org.hello.helloservlet.member.MemberRepository;
import org.hello.helloservlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> parameters, Map<String, Object> model) {
        String username = parameters.get("username");
        int age = Integer.parseInt(parameters.get("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);
        model.put("member", member);
        return "save-result";
    }
}
