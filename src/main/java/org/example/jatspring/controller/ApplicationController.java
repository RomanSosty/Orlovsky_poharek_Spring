package org.example.jatspring.controller;

import org.example.jatspring.dto.ApplicationDtoRequest;
import org.example.jatspring.entity.ApplicationForm;
import org.example.jatspring.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/form")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationForm saveApplicationForm(@RequestBody ApplicationDtoRequest request){
        return applicationService.createApplicationForm(request);
    }
}
