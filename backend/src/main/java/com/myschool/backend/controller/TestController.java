package com.myschool.backend.controller;

import com.myschool.backend.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public String test(Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        return "Authenticated as: "
                + user.getLoginId()
                + " | Role: "
                + user.getRole();
    }
}