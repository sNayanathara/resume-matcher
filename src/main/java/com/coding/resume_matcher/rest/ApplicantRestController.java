package com.coding.resume_matcher.rest;

import com.coding.resume_matcher.entity.Applicant;
import com.coding.resume_matcher.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApplicantRestController {

    private ApplicantService applicantService;

    @Autowired
    public ApplicantRestController(ApplicantService theApplicantService){
        applicantService = theApplicantService;
    }

    @GetMapping("/applicants")
    public List<Applicant> findAll(){

        return applicantService.findAll();
    }

    @GetMapping("/applicants/{applicantId}")
    public Applicant findById(@PathVariable int applicantId){

        if (applicantId < 0 || applicantId > applicantService.findAll().size()){
            throw new ApplicantNotFoundException("Applicant ID "+applicantId+ " not found");
        }

        return  applicantService.findById(applicantId);
    }

    @PostMapping("/applicants")
    public Applicant addApplicant(@RequestBody Applicant theApplicant){

        //set the id to 0 in case an id is passed
        //applicantService.save method force the save of a new item only if the id = 0
        //if id !=0 it will work as an update
        theApplicant.setId(0);

        Applicant dbApplicant = applicantService.save(theApplicant);
        return dbApplicant;

    }

    @PutMapping("/applicants")
    public Applicant updateApplicant(@RequestBody Applicant theApplicant){

        Applicant dbApplicant = applicantService.save(theApplicant);
        return dbApplicant;
    }

    @DeleteMapping("/applicants/{applicantId}")
    public String deleteApplicant(@PathVariable int applicantId){

        if (applicantId < 0 || applicantId > applicantService.findAll().size()){
            throw new ApplicantNotFoundException("Applicant ID "+applicantId+ " not found");
        }
        applicantService.deleteById(applicantId);

        return "Deleted applicant with id "+applicantId;
    }
}
