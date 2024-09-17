package com.coding.resume_matcher.dao;

import com.coding.resume_matcher.entity.Applicant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplicantDAOJpaImpl implements  ApplicantDAO{

    private EntityManager entityManager;

    @Autowired
    public ApplicantDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Applicant> findAll() {

        TypedQuery<Applicant> query = entityManager.createQuery("from Applicant", Applicant.class);

        List<Applicant> applicants = query.getResultList();

        return applicants;
    }

    @Override
    public Applicant findById(int id) {

        Applicant theApplicant = entityManager.find(Applicant.class,id);

        return theApplicant;
    }

    @Override
    public Applicant save(Applicant applicant) {

        Applicant theApplicant = entityManager.merge(applicant);

        return applicant;
    }

    @Override
    public void deleteById(int id) {

        Applicant theApplicant = entityManager.find(Applicant.class, id);
        entityManager.remove(theApplicant);
    }
}
