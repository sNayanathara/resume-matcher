import CreateApplicantProfile from "./CreateApplicantProfile";
import Navigationbar from "../Navbar";

const CreateApplicant = () => {

    return(
        <div style={{backgroundColor:"rgba(192,192,192,0.3)", paddingBottom:"300px"}}>
            <Navigationbar/>
        {/* </div> */}
            <div style={{backgroundColor:"rgba(192,192,192,0.3)", paddingTop:'40px', paddingBottom:'100px', paddingLeft:'100px',paddingRight:'100px'}}>
                <h1>Hi!!!</h1>
                <h1>Let's start job seeking</h1>
                <h2>Start with creating your profile</h2>
                <br></br>
                <CreateApplicantProfile/>
            </div>
        </div>
    )

}

export default CreateApplicant;