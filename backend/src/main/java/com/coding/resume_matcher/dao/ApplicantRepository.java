package com.coding.resume_matcher.dao;

import com.coding.resume_matcher.entity.Applicant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:3000")
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

    
}
