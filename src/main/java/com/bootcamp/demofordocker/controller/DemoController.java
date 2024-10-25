package com.bootcamp.demofordocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api" )
public class DemoController
{
    @GetMapping( "/hello" )
    public String sayHello()
    {
        return "Hello, World!";
    }

    @GetMapping( "/bye" )
    public String sayBye()
    {
        return "Goodbye World";
    }
    @GetMapping("/devops")
    public String getDevopsEnv() {
        String devopsValue = System.getenv("DEVOPS");
        return "DEVOPS name is " + devopsValue;
    }
}
