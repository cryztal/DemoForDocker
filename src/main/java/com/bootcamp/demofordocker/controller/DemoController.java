package com.bootcamp.demofordocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api" )
public class DemoController
{

    public static String longest = "Hello, World! Welcome to DevOps World with Docker and Kubernetes I need a long string to test the longest word in a string generate more than 100 characters";
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


