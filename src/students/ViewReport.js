
import React, { useEffect, useState } from 'react'
import {Link} from "react-router-dom"
import StudentDataService from "../services/student.service"
import { useLocation } from "react-router-dom";
export default function ViewReport(props) {
  /*
  View Report card to show the information of the particular student id.
  */
  const location = useLocation();
  console.log(location.state.userId)

    const stId= location.state.userId

    const[student,setStudent]=useState({})
    const[place,setPlace]=useState()

    useEffect(()=>{
        loadStudent()
    },[]);
    

    const loadStudent=async()=>{
        StudentDataService.get(stId).then(response=> {
          setStudent(response.data)
          
        })
        StudentDataService.findDivision(stId).then(response=> setPlace(response.data))
        
    };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 brorder rounded p-4 mt-2 shadow">
          <h2 className="text-centre m-4">Student Report</h2>
          <div className="card">
            <div className="card-header">
                Marks Obtained: {student.physics+student.chemistry+student.biology}
                <ul className="list-group list-group-flush">
                    <li className="list-group-item">
                        <b>Roll No: </b>
                        {student.id}

                    </li>
                    <li className="list-group-item">
                        <b>Name: </b>
                        {student.name}

                    </li>
                    <li className="list-group-item">
                        <b>Physics: </b>
                        {student.physics}

                    </li>
                    <li className="list-group-item">
                        <b>Chemistry: </b>
                        {student.chemistry}

                    </li>
                    <li className="list-group-item">
                        <b>Biology: </b>
                        {student.biology}

                    </li>
                    <li className="list-group-item">
                        <b>Division: </b>
                        {place}
                        

                    </li>

                </ul>
            </div>

          </div>
          <Link className="btn btn-primary my-2 "to={"/"}>Back to Home</Link>
        </div>
      </div>
    </div>
  )
}
