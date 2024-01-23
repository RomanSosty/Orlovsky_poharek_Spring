package org.example.jatspring.controller;

import org.example.jatspring.dto.ApplicationDtoRequest;
import org.example.jatspring.entity.ApplicationForm;
import org.example.jatspring.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/form")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<ApplicationForm> saveApplicationForm(@RequestBody ApplicationDtoRequest request){
        ApplicationForm applicationForm = applicationService.createApplicationForm(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationForm);
    }
}
