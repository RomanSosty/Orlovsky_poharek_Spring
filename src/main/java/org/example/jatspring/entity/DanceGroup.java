package org.example.jatspring.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class DanceGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int numOfDancer;
    @OneToMany(mappedBy = "dancegroup", cascade = CascadeType.ALL)
    private List<ApplicationForm> applicationForms = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfDancer() {
        return numOfDancer;
    }

    public void setNumOfDancer(int numOfDancer) {
        this.numOfDancer = numOfDancer;
    }

    public List<ApplicationForm> getApplicationForms() {
        return applicationForms;
    }

    public void setApplicationForms(List<ApplicationForm> applicationForms) {
        this.applicationForms = applicationForms;
    }
}
