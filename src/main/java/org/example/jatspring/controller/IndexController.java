package org.example.jatspring.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String home() {
        return "index";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/loginPage")
    public String endpoint() {
        return "loginPage";
    }
}
