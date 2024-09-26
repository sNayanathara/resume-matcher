import React, { useEffect, useState } from "react";
import './App.css';
import { Button, ButtonGroup, Container, Table, Navbar, NavbarBrand } from 'reactstrap';

const App = () => {

    const [applicants, setApplicants] = useState([]);
    const [applicantDetails, setApplicantDetails] = useState({
        location:"",
        yrsExprnce:"",
        designation:""
    });
    const [url, setUrl] = useState('http://localhost:8080/api/applicants');
    // 'http://localhost:8080/api/applicants/search/findApplicantsByCriteria?location=%20&yearsOfExprnce=-1'

    // const fetchApplicants = () => {
    //     fetch(url)
    //     .then(result => result.json())
    //     .then(data => setApplicants(data._embedded.applicants))
    //     .catch(error => console.log(error));
    // };

    const handleChange = (e)=> {
        const value = e.target.value;

        setApplicantDetails({
            ...applicantDetails,
            [e.target.name]:value
        })
      };
    
      const handleSubmit = (e) => {
        e.preventDefault()

        const {location, yrsExprnce, designation} = applicantDetails;
        setUrl(`http://localhost:8080/api/applicants/search/findApplicantsByCriteria?location=${location}&yearsOfExprnce=${yrsExprnce}&appliedDesignation=${designation}`)
        
      };

    const showFilterForm =() => (
        <form onSubmit={handleSubmit}>
            <input type="text" placeholder="Location" name="location" value={applicantDetails.location} onChange={handleChange}/>
            <input type="number" min="0" placeholder="Years of Experience" name="yrsExprnce" value={applicantDetails.yrsExprnce} onChange={handleChange}/>
            {/* <label> */}
                <select name="designation" value={applicantDetails.designation} onChange={handleChange} >
                    <option value="Accountant">Accountant</option>
                    <option value="Consultant">Business Analyst</option>
                    <option value="DatabaseEngi">Database Engineer</option>
                    <option value="DevOps">DevOPs</option>
                    <option value="SoftwareDev">Software Developer</option>
                </select>
            {/* </label> */}
            <button>Search</button>
        </form>
    );

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

    return(
        <div>
            <Navbar className="navbar navbar-light" style={{ backgroundColor: '#e3f2fd'}}>
                <NavbarBrand className="navbar-brand">Job Seekers</NavbarBrand>
                {showFilterForm()}
            </Navbar >
            <Container fluid>
                <Table className="table table-bordered table-hover">
                <thead className="table-info">
                    <tr>
                    <th scope="col">Applicant Name</th>
                    <th scope="col">Years Of Experience</th>
                    <th scope="col">Skills</th>
                    <th scope="col">Email</th>
                    <th scope="col">Location</th>
                    <th scope="col">Interested Designation</th>
                    </tr>
                </thead>
                <tbody>
                    {showApplicants()}
                </tbody>
                </Table>
            </Container>
        </div>
    )
};
export default App;