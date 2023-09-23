package com.archisacademy.openai.controller;

import com.archisacademy.openai.service.WelcomeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController { //IOC
    private final WelcomeService service;

    public WelcomeController(WelcomeService service) {
        this.service = service;
    } //dependency injection

    @PostMapping("/sayhi")
    public String sayHi(@RequestBody String name) {
        return service.sayHi(name);
    }
}
