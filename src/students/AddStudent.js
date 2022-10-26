import React,{useState} from 'react'

import { Link,useNavigate } from 'react-router-dom';
/*
  Add Student Form
*/

export default function AddStudent() {
  /**
   * Object for Student information
   */

  let navigate=useNavigate()

  const [student,setStudent]=useState({
    id:"",
    name:"",
    dateOfAdmission:"06/08/2000",
    physics:"",
    chemistry:"",
    biology:""
  });

/**
 * 
 * @param {e} e : event onInputChange to store the input given by the user and onSubmit passing the information tp the backend 
 */
  
  const onInputChange=(e)=>{

    e.preventDefault()
    const{name,value}= e.target

    setStudent({...student,[name]:value});

  };

  const onSubmit=async(e)=>{

    e.preventDefault();
    
    // StudentDataService.create(JSON.stringify(student)).then(response=> console.log(response.data)).catch((e)=> console.log(e))
    // .catch((error) => console.log(error.response.data.trace))

    await fetch('http://localhost:8081/api/students' , {
      method: 'POST',
      headers: { 
        'Content-Type': 'application/json',
        'Authorization': 'Basic '+btoa('user:12345'), 
      },
      body: JSON.stringify(student)
    });
    
   
    navigate("/")
  };
  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 brorder rounded p-4 mt-2 shadow">
          <h2 className="text-centre m-4">Add Student</h2>
          <form onSubmit={(e)=>onSubmit(e)}>
          <div className="mb-3">
            <label htmlFor="id" className="form-label">
              Roll No
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Enter Roll no"
              name="id"
              value={student.id}
              onChange={(e)=>onInputChange(e)}
              />
          </div>
          <div className="mb-3">
            <label htmlFor="Name" className="form-label">
              Name
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Enter name"
              name="name"
              value={student.name}
              onChange={(e)=>onInputChange(e)}
              />
          </div>
          <div className="mb-3">
            <label htmlFor="Physics Score" className="form-label">
              Physics score
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Enter Physics score"
              name="physics"
              value={student.physics}
              onChange={(e)=>onInputChange(e)}
              />
          </div>
          <div className="mb-3">
            <label htmlFor="Chemistry score" className="form-label">
              Chemistry score
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Enter Chemistry score"
              name="chemistry"
              value={student.chemistry}
              onChange={(e)=>onInputChange(e)}
              />
          </div>
          <div className="mb-3">
            <label htmlFor="Biology score" className="form-label">
              Biology score
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Enter Biology score"
              name="biology"
              value={student.biology}
              onChange={(e)=>onInputChange(e)}
              />
          </div>
          <button type="submit" className="btn btn-outline-primary">Submit</button>
          <Link className="btn btn-outline-danger mx-2" to="/">Cancel</Link>
          </form>
        </div>
      </div>
    </div>
  )
}
