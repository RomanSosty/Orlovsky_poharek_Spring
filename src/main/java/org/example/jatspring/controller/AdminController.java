package org.example.jatspring.controller;

import org.example.jatspring.entity.ApplicationForm;
import org.example.jatspring.service.ApplicationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    private final ApplicationService applicationService;

    public AdminController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping("/adminPage")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminPage(Model model) {
        List<ApplicationForm> applicationForms =applicationService.getAllForms();
        model.addAttribute("forms", applicationForms);
        return "adminPage";
    }
}
