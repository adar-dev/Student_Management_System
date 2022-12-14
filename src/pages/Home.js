import React, { useState,useEffect } from 'react'
import axios from 'axios'
import { Link ,useNavigate, useParams} from 'react-router-dom'


import StudentDataService from "../services/student.service"
import StudentRow from "../component/rowComp.js"
export default function Home() {

    

    const {id}=useParams()

    const [studentArr,setStudentArr]=useState([]);

    useEffect(()=>{
        loadStudent();
    },[studentArr])

    const loadStudent=async()=>{
        const result= StudentDataService.getAll().then(response=> {
            setStudentArr(response.data)
            
            
          })
    };
   

    return (
        <div className='container'>
            <div className='py-4'>
                <table className="table border shadow">
                    <thead className="table-secondary">
                        <tr>
                            <th scope="col">Roll No</th>
                            <th scope="col">Name</th>
                            <th scope="col">Physics</th>
                            <th scope="col">Chemistry</th>
                            <th scope="col">Biology</th>
                            <th scope="col">Division</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    {studentArr.map(st=> <StudentRow setStArr= {setStudentArr} stArr={studentArr} name={st.name} phy={st.physics} chem={st.chemistry} bio={st.biology} stuId = {st.id}/>)}
                    </tbody>
                </table>
            </div>
        </div>
    )
}
