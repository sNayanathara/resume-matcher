import React, { useEffect, useState, useContext } from "react";
import Table from 'react-bootstrap/Table';
import {UrlContext} from './ApplicantPage';

const ApplicantList = () => {

    const [applicants, setApplicants] = useState([]);
    const { url } = useContext(UrlContext);

    const showApplicants = () => applicants.map((applicant, index) => (
        <tr key={index}>
        <td>{applicant.firstName} {applicant.lastName}</td>
        <td>{applicant.yearsOfExprnce}</td>
        <td>{applicant.skills}</td>
        <td>{applicant.email}</td>
        <td>{applicant.location}</td>
        <td>{applicant.appliedDesignation}</td>
        </tr>
    ));

    useEffect(() => {
        fetch(url)
        .then(result => result.json())
        .then(data => setApplicants(data._embedded.applicants))
        .catch(error => console.log(error));
    },[url]);

  return (
    <div style={{marginLeft:'20px', marginRight:'20px'}}>
        <Table striped hover variant="secondary">
        <thead>
            <tr>
            <th>Applicant Name</th>
            <th>Years Of Experience</th>
            <th>Skills</th>
            <th>Email</th>
            <th>Location</th>
            <th>Interested Designation</th>
            </tr>
        </thead>
        <tbody>
            {showApplicants()}
        </tbody>
        </Table>
    </div>
  );
}

export default ApplicantList;