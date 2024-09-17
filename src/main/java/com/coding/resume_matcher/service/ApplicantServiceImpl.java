package com.coding.resume_matcher.service;

import com.coding.resume_matcher.dao.ApplicantRepository;
import com.coding.resume_matcher.entity.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantServiceImpl implements ApplicantService{

    ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantServiceImpl(ApplicantRepository theApplicantRepository){
        applicantRepository = theApplicantRepository;
    }

    @Override
    public List<Applicant> findAll() {
        return applicantRepository.findAll();
    }

    @Override
    public Applicant findById(int id) {
        Optional<Applicant> result = applicantRepository.findById(id);

        Applicant applicant = null;

        if (result.isPresent()){
            applicant = result.get();
        }else {
            throw new RuntimeException("Applicant with id "+id+" not found");
        }
        return applicant;
    }

    @Override
    public Applicant save(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    @Override
    public void deleteById(int id) {
        applicantRepository.deleteById(id);
    }
}
