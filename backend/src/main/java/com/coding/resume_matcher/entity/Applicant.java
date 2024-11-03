package com.coding.resume_matcher.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "applicant")
public class Applicant extends User{

    @Column(name = "location")
    private String location;

    @Column(name = "years_of_exprnce")
    private int yearsOfExprnce;

    @Column(name = "skills")
    private String skills;

    @Column(name = "interested_field")
    private String appliedDesignation;

}
