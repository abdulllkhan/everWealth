package com.project.everWealth.healthstatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("api/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("healthstatus")
    public String healthStatus() {
        return "I have asthma";
    }
}