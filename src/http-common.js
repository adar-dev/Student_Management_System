import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:8081/api",
  auth: {
    username: "user",
    password: "12345"
  },
  headers: {
   
    "Content-type": "application/json",
   
    "Access-Control-Allow-Origin": "*",
   
  }
});