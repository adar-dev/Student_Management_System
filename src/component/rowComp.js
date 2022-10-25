import { Link} from "react-router-dom"

import { useNavigate } from "react-router-dom";
import React, { useState,useEffect } from 'react'
import StudentDataService from "../services/student.service"


export default function StudentRow(props) {

    const navigate = useNavigate();
    const[place,setPlace]=useState()
    

    const handleDelete= (recId)=>{
        StudentDataService.delete(recId)
        props.setStArr(props.stArr)

    }

    useEffect(()=>{
        loadStudent()
    },[]);
    

    const loadStudent=async()=>{
        
        StudentDataService.findDivision(props.stuId).then(response=> setPlace(response.data))
        
    };
    return (
        
        <tr>
        <th scope="row">{props.stuId}</th>
        <td>{props.name}</td>
        <td>{props.phy}</td>
        <td>{props.chem}</td>
        <td>{props.bio}</td>
        <td>{place}</td>
        <td>
        <button onClick={()=> navigate('/viewReport', {
      state: {
        userId: props.stuId,
      }
    })} className="btn btn-primary mx-2"
            >ViewReport</button>
        

   <button onClick={()=> navigate(`/updateStudent/:${props.stuId}`, {
      state: {
        userId: props.stuId,
      }
    })}  className="btn btn-primary mx-2">Update</button>

    <button onClick={()=> handleDelete(props.stuId) }  className="btn btn-primary mx-2">Delete</button>

           

            
        </td>
        
    </tr>
    )
}