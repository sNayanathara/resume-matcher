import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import { useNavigate } from "react-router-dom";

const Registration = () => {

    const [userDetails, setUserDetails] = useState({
        firstName:"",
        lastName:"",
        email:"",
        password:"",
        confirmPass:""
    });

    const handleChange = (e)=> {
        const value = e.target.value;

        setUserDetails({
            ...userDetails,
            [e.target.name]:value
        })
    };

    const handleSubmit = (e) => {
        e.preventDefault()
        console.log("inside submit");
        const {firstName, lastName, email, city, country, zip, yrsExprnce, designation, skills} = userDetails;
        fetch("http://localhost:8080/api/applicants", {
            method:'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
              },
            body: JSON.stringify({
                firstName: firstName,
                lastName: lastName,
                email:email,
                location:`${city} ${country} ${zip}`,
                yearsOfExprnce: yrsExprnce,
                skills:skills,
                appliedDesignation: designation
            })
        })
        .then((response) => response.json())
        .then((body) => console.log(body));
        // userProfilePage();
    };

    return (
        <div style={{backgroundColor:"rgba(192,192,192,0.3)", paddingTop:'100px', paddingBottom:'100px', paddingLeft:'100px',paddingRight:'100px'}}>
            <Form onSubmit={handleSubmit}>
                <Row className="mb-3">
                    <Form.Group as={Col} controlId="formGridFirstName">
                    <Form.Label>First Name</Form.Label>
                    <Form.Control type="text" name="firstName" placeholder="first name" value={userDetails.firstName} onChange={handleChange} />
                    </Form.Group>

                    <Form.Group as={Col} controlId="formGridLastName">
                    <Form.Label>Last Name</Form.Label>
                    <Form.Control type="text" name="lastName" placeholder="last name" value={userDetails.lastName} onChange={handleChange}/>
                    </Form.Group>
                </Row>

                <Form.Group className="mb-3" controlId="formGridEmail">
                    <Form.Label>Email</Form.Label>
                    <Form.Control type="email" name="email" placeholder="Enter email" value={userDetails.email} onChange={handleChange}/>
                </Form.Group>

                <Row className="mb-3">
                    <Form.Group as={Col} controlId="formGridFirstName">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" name="password" placeholder="password" value={userDetails.password} onChange={handleChange} />
                    </Form.Group>

                    <Form.Group as={Col} controlId="formGridLastName">
                    <Form.Label>Confirm Password</Form.Label>
                    <Form.Control type="password" name="confirmPass" placeholder="confirm password" value={userDetails.confirmPass} onChange={handleChange}/>
                    </Form.Group>
                </Row>

                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        </div>

    );

}

export default Registration;