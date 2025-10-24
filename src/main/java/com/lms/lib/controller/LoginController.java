package main.java.com.lms.lib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import main.java.com.lms.lib.domain.Login;
import main.java.com.lms.lib.service.LoginService;

@Controller
public class LoginController {
    @Autowired private LoginService service;

    @GetMapping({"/", "/login"})
    public String showLoginPage() { return "login"; }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        Login user = service.log(username, password);
        if (user != null) return "redirect:/welcome";
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }
}
