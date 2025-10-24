package main.java.com.lms.lib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import main.java.com.lms.lib.service.RegService;

@Controller
public class RegController {
    @Autowired private RegService service;

    @GetMapping("/register")
    public String showRegisterPage() { return "register"; }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        boolean isRegistered = service.registerUser(username, password);
        if (isRegistered) {
            model.addAttribute("message", "Registration successful! Please login.");
            return "login";
        } else {
            model.addAttribute("error", "Username already exists!");
            return "register";
        }
    }
}
