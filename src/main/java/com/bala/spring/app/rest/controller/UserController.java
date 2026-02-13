package com.bala.spring.app.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/name")
    public String greetings() {

        return "Hi, I am Bala, Welcome to Spring Demo Boot Application";
    }

    @GetMapping("/address")
    public String address() {

        return "Hi, I am Bala, I am in India";
    }

    @PostMapping("/update")
    public String update() {

        return "Hi, Greetings updated successfully!";
    }


}
