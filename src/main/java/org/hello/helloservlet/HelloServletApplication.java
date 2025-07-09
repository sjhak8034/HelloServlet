package org.hello.helloservlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class HelloServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloServletApplication.class, args);
    }

}
