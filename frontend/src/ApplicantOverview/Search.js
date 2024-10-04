import React, { useState,  useContext  } from "react";
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import {UrlContext} from './ApplicantPage';
import Row from 'react-bootstrap/Row';

const Search = () => {

    const [applicantDetails, setApplicantDetails] = useState({
        location:"",
        yrsExprnce:"",
        designation:""
    });
    const { setUrl } = useContext(UrlContext);

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

  return (
    <Form onSubmit={handleSubmit}>
      <Row className="justify-content-start" style={{paddingTop: "50px", paddingBottom:"20px", paddingLeft:"15px"}}>
        <Col xs="auto">
          <Form.Label htmlFor="inlineFormInput" visuallyHidden>
            Location
          </Form.Label>
          <Form.Control
            className="mb-2"
            id="inlineFormInput"
            type="text"
            placeholder="location"
            name="location"
            value={applicantDetails.location} 
            onChange={handleChange}
          />
        </Col>
        <Col xs="auto">
          <Form.Label htmlFor="inlineFormInputGroup" visuallyHidden>
            Years of Experience
          </Form.Label>
          <Form.Control
            className="mb-2"
            id="inlineFormInput"
            type="number"
            min={0}
            placeholder="years of experience"
            name="yrsExprnce"
            value={applicantDetails.yrsExprnce} 
            onChange={handleChange}
          />
        </Col>
        <Col xs="auto">
        <Form.Select aria-label="designation" name="designation" value={applicantDetails.designation} onChange={handleChange}>
            <option value="Accountant">Accountant</option>
            <option value="Business Analyst">Business Analyst</option>
            <option value="Database Engineers">Database Engineer</option>
            <option value="DevOps">DevOps</option>
            <option value="Software Developer">Software Developer</option>
        </Form.Select>
        </Col>
        <Col xs="auto">
          <Button type="submit" className="mb-2" variant="secondary">
            Search
          </Button>
        </Col>
      </Row>
    </Form>
  );
}

export default Search;