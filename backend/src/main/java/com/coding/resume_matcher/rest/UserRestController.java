package com.coding.resume_matcher.rest;

import com.coding.resume_matcher.entity.Applicant;
import com.coding.resume_matcher.entity.Recruiter;
import com.coding.resume_matcher.service.ApplicantService;
import com.coding.resume_matcher.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class UserRestController {

    private ApplicantService applicantService;
    private RecruiterService recruiterService;

    @Autowired
    public UserRestController(ApplicantService theApplicantService, RecruiterService theRecruiterService){
        applicantService = theApplicantService;
        recruiterService = theRecruiterService;
    }

    @GetMapping("/applicants")
    public List<Applicant> findApplicants() {
        return applicantService.findAll();
    }

//    @GetMapping("/applicants/{applicantId}")
    @GetMapping("/applicant")
    public Applicant findApplicantById(@RequestParam("id") int applicantId) {
        return applicantService.findById(applicantId);
    }

    @GetMapping("/recruiters")
    public List<Recruiter> findRecruiters() {
        return recruiterService.findAll();
    }

    @GetMapping("/recruiters/{recruiterId}")
    public Recruiter findRecruiterById(@PathVariable int recruiterId) {
        return recruiterService.findById(recruiterId);
    }

    @PostMapping("/applicants/register")
    public Applicant addApplicant(@RequestBody Applicant theApplicant){
        //set the id to 0 in case an id is passed
        //applicantService.save method force the save of a new item only if the id = 0
        //if id !=0 it will work as an update
        theApplicant.setId(0);

        Applicant dbApplicant = applicantService.save(theApplicant);
        return dbApplicant;
    }

    @PostMapping("/recruiters/register")
    public Recruiter addRecruiter(@RequestBody Recruiter theRecruiter){
        //set the id to 0 in case an id is passed
        //applicantService.save method force the save of a new item only if the id = 0
        //if id !=0 it will work as an update
        theRecruiter.setId(0);

        Recruiter dbRecruiter = recruiterService.save(theRecruiter);
        return dbRecruiter;
    }

    @PutMapping("/applicants")
    public Applicant updateApplicant(@RequestBody Applicant theApplicant){

        Applicant dbApplicant = applicantService.save(theApplicant);
        return dbApplicant;
    }

    @PutMapping("/recruiters")
    public Recruiter updateRecruiter(@RequestBody Recruiter theRecruiter){

        Recruiter dbRecruiter = recruiterService.save(theRecruiter);
        return dbRecruiter;
    }

    @DeleteMapping("/applicants/{applicantId}")
    public String deleteApplicant(@PathVariable int applicantId){

        applicantService.deleteById(applicantId);
        return "Deleted applicant with id "+applicantId;
    }

    @DeleteMapping("/recruiters/{recruiterId}")
    public String deleteRecruiter(@PathVariable int recruiterId){

        recruiterService.deleteById(recruiterId);
        return "Deleted recruiter with id "+recruiterId;
    }
}
