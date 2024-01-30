package org.example.jatspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
 public class ApplicationForm {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private Long id;
        private String contact;
        private String ageCategory;
        private String meansOfTransport;
        private String message;
        @OneToOne
        @JoinColumn(name = "dance_Id")
        private Dance dance;
        @ManyToOne
        @JoinColumn(name = "danceGroup_Id")
        @JsonIgnore
        private DanceGroup dancegroup;

       public Long getId() {
              return id;
       }

       public void setId(Long id) {
              this.id = id;
       }

       public String getContact() {
              return contact;
       }

       public void setContact(String contact) {
              this.contact = contact;
       }

       public String getAgeCategory() {
              return ageCategory;
       }

       public void setAgeCategory(String ageCategory) {
              this.ageCategory = ageCategory;
       }

       public String getMeansOfTransport() {
              return meansOfTransport;
       }

       public void setMeansOfTransport(String meansOfTransport) {
              this.meansOfTransport = meansOfTransport;
       }

       public String getMessage() {
              return message;
       }

       public void setMessage(String message) {
              this.message = message;
       }

       public Dance getDance() {
              return dance;
       }

       public void setDance(Dance dance) {
              this.dance = dance;
       }

       public DanceGroup getDancegroup() {
              return dancegroup;
       }

       public void setDancegroup(DanceGroup dancegroup) {
              this.dancegroup = dancegroup;
       }
}
