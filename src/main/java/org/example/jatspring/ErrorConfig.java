package org.example.jatspring;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

@Configuration
public class ErrorConfig {
    @Bean
    public ErrorViewResolver customErrorViewResolver(){
        return((request, status, model) -> {
            if(status == HttpStatus.NOT_FOUND){
                return new ModelAndView("errorPage", Collections.emptyMap(), HttpStatus.NOT_FOUND);
            }
            return null;
        });
    }
}
