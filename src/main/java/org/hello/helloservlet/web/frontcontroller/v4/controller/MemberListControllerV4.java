package org.hello.helloservlet.web.frontcontroller.v4.controller;

import org.hello.helloservlet.member.Member;
import org.hello.helloservlet.member.MemberRepository;
import org.hello.helloservlet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> parameters, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();
        model.put("members", members);
        return "members";
    }
}
