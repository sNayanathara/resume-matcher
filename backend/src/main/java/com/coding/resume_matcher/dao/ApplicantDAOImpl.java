package com.coding.resume_matcher.dao;

import com.coding.resume_matcher.entity.Applicant;
import com.coding.resume_matcher.entity.Recruiter;
import com.coding.resume_matcher.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplicantDAOImpl implements ApplicantDAO {

    private EntityManager entityManager;

    @Autowired
    public ApplicantDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Applicant> findAll() {

//        TypedQuery<Applicant> query = entityManager.createQuery("FROM User WHERE userType = 'Applicant'", Applicant.class);
        TypedQuery<Applicant> query = entityManager.createQuery("FROM Applicant", Applicant.class);
        List<Applicant> users = query.getResultList();
        return users;
    }

    @Override
    public Applicant findById(int id) {

        TypedQuery<Applicant> query = entityManager.createQuery("FROM Applicant WHERE id = "+id, Applicant.class);
        Applicant theApplicant = query.getSingleResult();
        if (theApplicant != null) {
            return theApplicant;
        } else {
            throw new RuntimeException("The applicant with id: "+id +"is not available");
        }

    }

    @Override
    public Applicant save(Applicant applicant) {

        Applicant theApplicant = entityManager.merge(applicant);
        return theApplicant;
    }

    @Override
    public void deleteById(int id) {

        TypedQuery<Applicant> query = entityManager.createQuery("FROM Applicant WHERE id = "+id, Applicant.class);
        Applicant theApplicant = query.getSingleResult();
        if (theApplicant != null) {
            entityManager.remove(theApplicant);
        } else {
            throw new RuntimeException("The applicant with id: "+id +"is not available");
        }

    }

}
