import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import { useNavigate } from "react-router-dom";


const CreateApplicantProfile = () =>  {

    const [checked, setChecked] = useState();
    const navigate = useNavigate();
    const [applicantDetails, setApplicantDetails] = useState({
        firstName:"",
        lastName:"",
        email:"",
        phoneNo:"",
        password:"",
        matchingPassword:"",
        city:"",
        country:"",
        zip:"",
        // gender:"",
        yrsExprnce:"",
        designation:"",
        skills:""
    });

    const userProfilePage = (id) =>{
        navigate("/profile", { state: id })
    };

    const handleChange = (e)=> {
        const value = e.target.value;

        setApplicantDetails({
            ...applicantDetails,
            [e.target.name]:value
        })
    };

    const handleSubmit = (e) => {
        e.preventDefault()
        console.log("inside submit");
        const {firstName, lastName, email, phoneNo, password, matchingPassword, city, country, zip, yrsExprnce, designation, skills} = applicantDetails;
        fetch("http://localhost:8080/api/applicants/register", {
            method:'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
              },
            body: JSON.stringify({
                firstName: firstName,
                lastName: lastName,
                email:email,
                phoneNumber: phoneNo,
                password:password,
                matchingPassword:matchingPassword,
                userType:"Applicant",
                location:`${city}, ${country}, ${zip}`,
                yearsOfExprnce: yrsExprnce,
                skills:skills,
                appliedDesignation: designation
            })
        })
        .then((response) => response.json())
        .then((body) => userProfilePage(body.id));
        // userProfilePage();
    };

  return (
    <div style={{backgroundColor:"rgba(192,192,192,0.3)", paddingTop:'100px', paddingBottom:'100px', paddingLeft:'100px',paddingRight:'100px'}}>
    <Form onSubmit={handleSubmit}>
      <Row className="mb-3">
        <Form.Group as={Col} controlId="formGridFirstName">
          <Form.Label>First Name</Form.Label>
          <Form.Control type="text" name="firstName" placeholder="first name" value={applicantDetails.firstName} onChange={handleChange} />
        </Form.Group>

        <Form.Group as={Col} controlId="formGridLastName">
          <Form.Label>Last Name</Form.Label>
          <Form.Control type="text" name="lastName" placeholder="last name" value={applicantDetails.lastName} onChange={handleChange}/>
        </Form.Group>
      </Row>

        <Form.Group className="mb-3" controlId="formGridEmail">
          <Form.Label>Email</Form.Label>
          <Form.Control type="email" name="email" placeholder="Enter email" value={applicantDetails.email} onChange={handleChange}/>
        </Form.Group>

        <Form.Group className="mb-3" controlId="formGridPhoneNo">
          <Form.Label>Phone No</Form.Label>
          <Form.Control type="text" name="phoneNo" placeholder="Enter phone no" value={applicantDetails.phoneNo} onChange={handleChange}/>
        </Form.Group>

      <Row className="mb-3">
        <Form.Group as={Col} controlId="formGridCity">
          <Form.Label>City</Form.Label>
          <Form.Control type="text" name="city" value={applicantDetails.city} onChange={handleChange}/>
        </Form.Group>

        <Form.Group as={Col} controlId="formGridCountry">
          <Form.Label>Country</Form.Label>
          <Form.Control type="text" name="country" value={applicantDetails.country} onChange={handleChange}/>
        </Form.Group>

        <Form.Group as={Col} controlId="formGridZip">
          <Form.Label>Zip</Form.Label>
          <Form.Control type="text" name="zip" value={applicantDetails.zip} onChange={handleChange}/>
        </Form.Group>
      </Row>

      {/* <Form.Group className="mb-3" id="formGridGenderCheckbox">
        <Form.Check inline type="checkbox" label="Male" name="Male" id="inline-checkbox-male" checked={checked} value={applicantDetails.city} onChange={handleChange}/>
        <Form.Check inline type="checkbox" label="Female" name="Female" id="inline-checkbox-female" checked={!checked}/>
      </Form.Group> */}

      <Form.Group className="mb-3" controlId="formGridYrsExprnce">
        <Form.Label>Years of Experience</Form.Label>
        <Form.Control type="number" min={0} placeholder="Years of Experience" name="yrsExprnce" value={applicantDetails.yrsExprnce} onChange={handleChange}/>
      </Form.Group>

      <Form.Group className="mb-3" controlId="formGridSkills">
        <Form.Label>Skills</Form.Label>
        <Form.Control type="text" placeholder="Skills" name="skills" value={applicantDetails.skills} onChange={handleChange}/>
      </Form.Group>

      <Row className="mb-3">
        <Form.Group as={Col} controlId="formGridPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control type="password" name="password" value={applicantDetails.password} onChange={handleChange}/>
        </Form.Group>

        <Form.Group as={Col} controlId="formGridMatchingPassword">
          <Form.Label>Re-Type Password</Form.Label>
          <Form.Control type="password" name="matchingPassword" value={applicantDetails.matchingPassword} onChange={handleChange}/>
        </Form.Group>
      </Row>

      {/* <Link to="/profile" className="btn btn-secondary" type="submit">Submit</Link> */}
      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
    </div>
  );
}

export default CreateApplicantProfile;