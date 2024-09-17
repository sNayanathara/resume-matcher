package com.coding.resume_matcher.dao;

import com.coding.resume_matcher.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
}
