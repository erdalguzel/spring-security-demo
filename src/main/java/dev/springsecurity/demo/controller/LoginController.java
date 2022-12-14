package dev.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginUser() {
        return "fancy-login";
    }

    @GetMapping("/accessdenied")
    public String showAccessDeniedPage() {
        return "accessdenied";
    }
}
