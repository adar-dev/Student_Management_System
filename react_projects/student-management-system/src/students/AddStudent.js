import React,{useState} from 'react'
import axios from 'axios';
import { Link,useNavigate } from 'react-router-dom';
export default function AddStudent() {

  let navigate=useNavigate()

  const [student,setStudent]=useState({
    Rollno:"",
    name:"",
    Physics:"",
    Chemistry:"",
    Biology:""

  });

  const{Rollno,name,Physics,Chemistry,Biology}=student;

  const onInputChange=(e)=>{

    setStudent({...student,[e.target.Rollno]:e.target.value});

  };

  const onSubmit=async(e)=>{
    e.preventDefault();
    await axios.post("")
    navigate("/")
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 brorder rounded p-4 mt-2 shadow">
          <h2 className="text-centre m-4">Add Student</h2>
          <form onSubmit={(e)=>onSubmit(e)}>
          <div className="mb-3">
            <label htmlFor="Rollno" className="form-label">
              Roll No
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Enter Roll no"
              name="Rollno"
              value={Rollno}
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
              value={name}
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
              name="Physics"
              value={Physics}
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
              name="Chemistry"
              value={Chemistry}
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
              name="Biology"
              value={Biology}
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
