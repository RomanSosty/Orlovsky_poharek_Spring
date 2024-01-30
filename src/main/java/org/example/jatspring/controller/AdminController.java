package org.example.jatspring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AdminController {
    @RequestMapping("/adminPage")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminPage() {
        return "adminPage";
    }
}
