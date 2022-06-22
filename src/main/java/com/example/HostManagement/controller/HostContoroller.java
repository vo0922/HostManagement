package com.example.HostManagement.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HostContoroller {

    @GetMapping("/")
    public String home() {
        return  "/home";
    }
}
