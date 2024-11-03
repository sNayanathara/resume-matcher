package com.coding.resume_matcher.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recruiter")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Recruiter extends User{

    @Column(name = "organization")
    private String organization;

}
