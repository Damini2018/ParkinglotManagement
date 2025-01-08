package com.dreamCompany.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/welcome")
public class GeneralApi {

    @GetMapping
    public String getWelcomeMessage(){
        return "Welcome to dream parking";
    }
}
