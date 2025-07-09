package org.hello.helloservlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {
    String process(Map<String,String> parameters, Map<String,Object> model);
}
