package com.fgorostiaga.springcourse.controller;


import com.fgorostiaga.springcourse.model.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final MessageSource messageSource;

    public HelloWorldController(@Autowired MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean getHelloWorldBean() {
        return new HelloWorldBean("Hello world");
    }

    @GetMapping("/hello-world")
    public String getHelloWorld() {
        return messageSource.getMessage("hello.world.message", null, LocaleContextHolder.getLocale());
    }


}
