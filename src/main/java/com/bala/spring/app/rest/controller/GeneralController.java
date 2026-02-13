package com.bala.spring.app.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController   {

    @GetMapping()
    public String greetings() {

        return "Hi, Welcome to Spring Demo Boot Application";
    }

    @PostMapping()
    public String putgreetings() {

        return "Hi, Welcome to Spring Demo Boot Application , by post method";
    }


}
