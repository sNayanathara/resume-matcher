package com.coding.resume_matcher.dao;

import com.coding.resume_matcher.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:3000")
public interface RecruiterRepository extends JpaRepository<Recruiter, Integer> {
}
