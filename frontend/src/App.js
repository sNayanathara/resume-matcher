import React from "react";
import './App.css';
import {
    BrowserRouter,
    Routes,
    Route,
} from "react-router-dom";
// import Applicant from "./ApplicantOverview/ApplicantPage";
import CreateApplicantProfile from "./Applicants/CreateApplicantProfile";
import CreateApplicant from "./Applicants/CreateApplicantPage";
import ApplicantProfile from "./Applicants/ApplicantProfile";

const App = () => {

    return(
        <>
            <BrowserRouter>
            
                <Routes>
                    <Route
                        path="/"
                        element={<CreateApplicant />}
                    />
                    <Route
                        path="/profile"
                        element={<ApplicantProfile />}
                    />
                </Routes>
            </BrowserRouter>
        </>
    );
}
export default App;

        //     // <div>
        //     {/* <Applicant></Applicant> */}
        //     {/* <CreateApplicantProfile></CreateApplicantProfile> */}
        //     // <CreateApplicant></CreateApplicant>
        // // </div> 
        // // </>
        
