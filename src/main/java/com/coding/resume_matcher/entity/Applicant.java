package com.coding.resume_matcher.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "applicant")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "location")
    private String location;

    @Column(name = "years_of_exprnce")
    private int yearsOfExprnce;

    @Column(name = "skills")
    private String skills;

    public Applicant(String firstName, String lastName, String email, String location, int yearsOfExprnce, String skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.location = location;
        this.yearsOfExprnce = yearsOfExprnce;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", yearsOfExprnce=" + yearsOfExprnce +
                ", skills='" + skills + '\'' +
                '}';
    }
}
