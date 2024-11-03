package com.coding.resume_matcher.dao;

import com.coding.resume_matcher.entity.Applicant;
import com.coding.resume_matcher.entity.Recruiter;
import com.coding.resume_matcher.entity.User;

import java.util.List;

public interface ApplicantDAO {

    List<Applicant> findAll();

    Applicant findById(int id);

    Applicant save(Applicant applicant);

    void deleteById(int id);
}
