package org.example.jatspring;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.example.jatspring.controller.ApplicationController;
import org.example.jatspring.dto.ApplicationDtoRequest;
import org.example.jatspring.entity.ApplicationForm;
import org.example.jatspring.entity.Member;
import org.example.jatspring.service.ApplicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Arrays;

@SpringBootTest
public class ApplicationTests {

    @Autowired
    ApplicationService applicationService;
    @Autowired
    ApplicationController applicationController;
    @Transactional
    @Test
    void createApplicationForm() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ApplicationDtoRequest jsonData = objectMapper.readValue(getClass().getClassLoader().getResourceAsStream("application-form.json"), ApplicationDtoRequest.class);

        ResponseEntity<ApplicationForm> applicationForm = applicationController.saveApplicationForm(jsonData);
        assertEquals(HttpStatus.CREATED, applicationForm.getStatusCode());

    }

    @Transactional
    @Test
    void saveData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ApplicationDtoRequest jsonData = objectMapper.readValue(getClass().getClassLoader().getResourceAsStream("application-form.json"), ApplicationDtoRequest.class);

        ApplicationForm applicationForm = applicationService.createApplicationForm(jsonData);

        assertEquals("Klíčov",applicationForm.getDance().getName());
        assertEquals("TKJOY", applicationForm.getDancegroup().getName());
        assertEquals(1, applicationForm.getDance().getMembers().size());

        Member member = applicationForm.getDance().getMembers().stream().findFirst().orElse(null);
        assert member != null;
        assertEquals("Roman", member.getName() );
    }
}
