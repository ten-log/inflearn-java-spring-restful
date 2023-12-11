package com.example.demo.controller;

import com.example.demo.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * rest contorller, 일반 contorller 차이는?
 */
@RestController
public class HelloWorldController {

    //GET
    //
//    @RequestMapping(method = RequestMethod.GET, path = "/asdf")
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "test";
    }

    @GetMapping(path = "/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBean(
            @PathVariable String name
    ) {
        return new HelloWorldBean(String.format("hello , %s", name));
    }
}
