package org.hello.helloservlet.web.frontcontroller.v3;

import org.hello.helloservlet.web.frontcontroller.ModelView;
import org.hello.helloservlet.web.frontcontroller.MyView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String,String> parameters);
}
