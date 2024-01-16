package org.example.jatspring.service;

import org.example.jatspring.dto.ApplicationDtoRequest;
import org.example.jatspring.entity.ApplicationForm;


public interface ApplicationService {

    ApplicationForm createApplicationForm(ApplicationDtoRequest request);
}
