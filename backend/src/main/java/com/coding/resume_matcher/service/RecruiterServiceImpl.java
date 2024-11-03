package com.coding.resume_matcher.service;

import com.coding.resume_matcher.dao.RecruiterDAO;
import com.coding.resume_matcher.entity.Recruiter;
import com.coding.resume_matcher.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterServiceImpl implements RecruiterService{

    RecruiterDAO recruiterDAO;

    @Autowired
    public RecruiterServiceImpl(RecruiterDAO theRecruiterDAO){
        recruiterDAO = theRecruiterDAO;
    }

    @Override
    public List<Recruiter> findAll() {
        return recruiterDAO.findAll();
    }

    @Override
    public Recruiter findById(int id) {
        return recruiterDAO.findById(id);
    }

    @Override
    public Recruiter save(Recruiter recruiter) {
        return recruiterDAO.save(recruiter);
    }

    @Override
    public void deleteById(int id) {
        recruiterDAO.deleteById(id);
    }
}
