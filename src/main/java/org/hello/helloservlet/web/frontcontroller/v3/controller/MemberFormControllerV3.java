package org.hello.helloservlet.web.frontcontroller.v3.controller;

import org.hello.helloservlet.web.frontcontroller.ModelView;
import org.hello.helloservlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> parameters) {
        return new ModelView("new-form");

    }
}
