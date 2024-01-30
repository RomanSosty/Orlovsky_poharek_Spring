package org.example.jatspring.service;

import org.example.jatspring.dto.ApplicationDtoRequest;
import org.example.jatspring.entity.ApplicationForm;

import java.util.List;


public interface ApplicationService {

    ApplicationForm createApplicationForm(ApplicationDtoRequest request);

    List<ApplicationForm> getAllForms();
}
