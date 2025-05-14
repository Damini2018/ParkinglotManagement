package com.dreamCompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/welcome")
public class GeneralApi {

    @GetMapping("/test")
    //@ResponseBody
    public String getWelcomeMessage() {
        return "form";
        //return "Welcome to dream parking";
    }

    @GetMapping("/parking")
    //@ResponseBody
    public String getParkingLandingPage() {
        return "parking-form";
        //return "Welcome to dream parking";
    }

    @GetMapping
   // @ResponseBody
    public String getWelcomeMessage(Model model) {
        String welcome = "Welcome to custom dream parking";
        model.addAttribute("welcome", welcome);
        return "welcome-page";  // maps to welcome-page.html
    }
}
