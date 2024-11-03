package com.coding.resume_matcher.service;

import com.coding.resume_matcher.dao.ApplicantDAO;
import com.coding.resume_matcher.entity.Applicant;
import com.coding.resume_matcher.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    ApplicantDAO applicantDAO;

    @Autowired
    public ApplicantServiceImpl(ApplicantDAO theApplicantDAO){
        applicantDAO = theApplicantDAO;
    }

    @Override
    public List<Applicant> findAll() {
        return applicantDAO.findAll();
    }

    @Override
    public Applicant findById(int id) {
        return applicantDAO.findById(id);
    }

    @Override
    @Transactional
    public Applicant save(Applicant applicant) {
        return applicantDAO.save(applicant);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        applicantDAO.deleteById(id);
    }
}
