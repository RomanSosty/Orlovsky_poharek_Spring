package org.example.jatspring.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String dateOfBirth;
    @Transient
    private Integer age;
    @ManyToMany
    @JoinTable(
            name = "member_dance",
            joinColumns = @JoinColumn(name="member_id"),
            inverseJoinColumns = @JoinColumn(name = "dance_id")
    )
    private Set<Dance> dances = new HashSet<>();

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Dance> getDances() {
        return dances;
    }

    public void setDances(Set<Dance> dances) {
        this.dances = dances;
    }

    public Integer getAge() {
        return Period.between(LocalDate.parse(this.dateOfBirth), LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
