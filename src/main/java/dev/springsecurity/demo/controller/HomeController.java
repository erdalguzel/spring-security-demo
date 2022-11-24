package dev.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/managers")
    public String showManagers() {
        return "managers";
    }

    @GetMapping("/admin")
    public String showAdmins() {
        return "admin";
    }

    @GetMapping("/systems")
    public String showSystems() {
        return "systems";
    }
}
