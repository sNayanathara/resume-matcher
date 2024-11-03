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
public class RecruiterDAOImpl implements RecruiterDAO{

    private EntityManager entityManager;

    @Autowired
    public RecruiterDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Recruiter> findAll() {

//        TypedQuery<Recruiter> query = entityManager.createQuery("FROM User WHERE userType = 'Recruiter'", Recruiter.class);
        TypedQuery<Recruiter> query = entityManager.createQuery("FROM Recruiter", Recruiter.class);
        List<Recruiter> users = query.getResultList();
        return users;
    }

    @Override
    public Recruiter findById(int id) {

        TypedQuery<Recruiter> query = entityManager.createQuery("FROM Recruiter WHERE id = "+id, Recruiter.class);
        Recruiter theRecruiter = query.getSingleResult();

        if (theRecruiter != null) {
            return theRecruiter;
        } else {
            throw new RuntimeException("The recruiter with id: "+id +"is not available");
        }

    }

    @Override
    public Recruiter save(Recruiter recruiter) {

        Recruiter theRecruiter = entityManager.merge(recruiter);
        return theRecruiter;
    }

    @Override
    public void deleteById(int id) {

        TypedQuery<Recruiter> query = entityManager.createQuery("FROM Recruiter WHERE id = "+id, Recruiter.class);
        Recruiter theRecruiter = query.getSingleResult();

        if (theRecruiter != null) {
            entityManager.remove(theRecruiter);
        } else {
            throw new RuntimeException("The recruiter with id: "+id +"is not available");
        }
    }
}
