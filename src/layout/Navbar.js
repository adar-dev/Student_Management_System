import React from 'react'
import { Link } from 'react-router-dom'
import { useNavigate } from "react-router-dom";

/*

This is Navbar design with button Add Student.
Student Management System acts as link redirecting to the home page.
Add Student button redirects to the AddStudent page.
*/

export default function Navbar()

{ 
  const navigate = useNavigate();
    return(
        <div>
            <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
             <div className="container-fluid">
              <Link className="navbar-brand" to="/">
                Student Management System
              </Link>
             <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
             <span className="navbar-toggler-icon"></span>
            </button> 
            
            <button onClick={()=> navigate('/addStudent')}  className="btn btn-outline-light">Add Student</button>
           </div>
          </nav>
        </div>
    )
}