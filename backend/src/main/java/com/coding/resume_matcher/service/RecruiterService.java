package com.coding.resume_matcher.service;

import com.coding.resume_matcher.entity.Recruiter;
import com.coding.resume_matcher.entity.User;

import java.util.List;

public interface RecruiterService {
    List<Recruiter> findAll();

    Recruiter findById(int id);

    Recruiter save(Recruiter recruiter);

    void deleteById(int id);
}
