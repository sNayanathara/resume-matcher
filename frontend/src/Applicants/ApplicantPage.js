import { React, useState, createContext } from "react";
import Navigationbar from "../Navbar";
import Search from "./Search";
import ApplicantList from "./ApplicantList";

// Create a new context and export
export const UrlContext = createContext();

// Create a Context Provider
const UrlContextProvider = ({ children }) => {
    const [url, setUrl] = useState('http://localhost:8080/api/applicants');

    return (
        <UrlContext.Provider value={{ url, setUrl }}>
            {children}
        </UrlContext.Provider>
    );
};

const Applicant = () => {
    return (
        <div style={{backgroundColor:"rgba(192,192,192,0.3)", paddingBottom:"300px"}}>
            <div>
                <Navigationbar/>
                <UrlContextProvider>
                    <Search />
                    <ApplicantList />
                </UrlContextProvider>
            </div>
        </div>
    );
};

export default Applicant;