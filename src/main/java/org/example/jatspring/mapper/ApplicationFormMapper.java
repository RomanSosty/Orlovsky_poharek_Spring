package org.example.jatspring.mapper;

import org.example.jatspring.dto.ApplicationDtoRequest;
import org.example.jatspring.entity.ApplicationForm;
import org.example.jatspring.entity.Dance;
import org.example.jatspring.entity.DanceGroup;

public class ApplicationFormMapper {

    public static ApplicationForm applicationFormToEntity(ApplicationDtoRequest request, Dance dance, DanceGroup danceGroup){
        ApplicationForm applicationForm = new ApplicationForm();

        applicationForm.setAgeCategory(request.ageCategory());
        applicationForm.setContact(request.contact());
        applicationForm.setMessage(request.message());
        applicationForm.setMeansOfTransport(request.meansOfTransport());
        applicationForm.setDance(dance);
        applicationForm.setDancegroup(danceGroup);

        return applicationForm;
    }
}
