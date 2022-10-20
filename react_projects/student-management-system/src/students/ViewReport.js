import axios from 'axios';
import React, { useEffect, useState } from 'react'
import {Link, useParams} from "react-router-dom"
export default function ViewReport() {

    const[student,setStudent]=useState({
        Rollno:"",
        name:"",
        Physics:"",
        Chemistry:"",
        Biology:""

    })

    const {id}=useParams();

    useEffect(()=>{
        loadStudent()

    },[]);

    const loadStudent=async()=>{
        const result=await axios.get(``);
        setStudent(result.data);
    };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 brorder rounded p-4 mt-2 shadow">
          <h2 className="text-centre m-4">Student Report</h2>
          <div className="card">
            <div className="card-header">
                Marks Obtained: {student.id}
                <ul className="list-group list-group-flush">
                    <li className="list-group-item">
                        <b>Roll No:</b>
                        {student.Rollno}

                    </li>
                    <li className="list-group-item">
                        <b>Name:</b>
                        {student.name}

                    </li>
                    <li className="list-group-item">
                        <b>Physics:</b>
                        {student.Physics}

                    </li>
                    <li className="list-group-item">
                        <b>Chemistry:</b>
                        {student.Chemistry}

                    </li>
                    <li className="list-group-item">
                        <b>Biology:</b>
                        {student.Biology}

                    </li>
                    <li className="list-group-item">
                        <b>Division:</b>
                        

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
