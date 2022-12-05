package com.mucahitarslan.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/index")
    public String index()
    {
        return "Index Page";
    }

    @GetMapping("/dashboard")
    public String dashboard()
    {
        return "Dashboard - Login";
    }
}
