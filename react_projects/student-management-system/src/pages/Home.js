import React, { useState,useEffect } from 'react'
import axios from 'axios'
import { Link ,useNavigate, useParams} from 'react-router-dom'
export default function Home() {

    const [student,setStudent]=useState([]);

    const {id}=useParams()

    useEffect(()=>{
        loadStudent();
    },[])

    

    const loadStudent=async()=>{
        const result=await axios.get("");
        setStudent(result.data);
    };

    const deleteStudent=async()=>{
        await axios.delete(``);
        loadStudent()

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
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>80</td>
                            <td>86</td>
                            <td>70</td>
                            <td>1</td>
                            <td>
                                <button className="btn btn-primary mx-2">View Report</button>
                                <Link className="btn btn-primary mx-2" 
                                to={`/updateStudent/${student.id}`}
                                >Update</Link>
                                <button className="btn btn-primary mx-2"
                                onClick={()=>deleteStudent(student.id)}
                                >Delete</button>
                            </td>
                        </tr>
                        
                    </tbody>
                </table>
            </div>
        </div>
    )
}
