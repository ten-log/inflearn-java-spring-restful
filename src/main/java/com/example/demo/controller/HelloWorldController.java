package com.example.demo.controller;

import com.example.demo.bean.HelloWorldBean;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


/**
 * rest contorller, 일반 contorller 차이는?
 */
@RestController
public class HelloWorldController {
    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //GET
    //
//    @RequestMapping(method = RequestMethod.GET, path = "/asdf")
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "test";
    }

    @GetMapping(path = "/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBean(@Valid
                                         @PathVariable String name
    ) {
        throw new RuntimeException("this is test error");
//        return new HelloWorldBean(String.format("hello , %s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String HelloWorldInternationalized(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale
    ) {
        System.out.println("test");
        return this.messageSource.getMessage("greeting.messages", null, locale);
    }

}
