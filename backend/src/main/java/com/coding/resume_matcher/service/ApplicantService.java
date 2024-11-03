package com.coding.resume_matcher.service;

import com.coding.resume_matcher.entity.Applicant;
import com.coding.resume_matcher.entity.User;

import java.util.List;

public interface ApplicantService {

    List<Applicant> findAll();

    Applicant findById(int id);

    Applicant save(Applicant applicant);

    void deleteById(int id);
}
