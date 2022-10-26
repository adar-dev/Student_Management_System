
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import Navbar from "./layout/Navbar";
import axios from "axios";
import Home from "./pages/Home";
import {BrowserRouter as Router,Routes,Route} from 'react-router-dom';
import AddStudent from "./students/AddStudent";
import UpdateStudent from "./students/UpdateStudent";
import ViewReport from "./students/ViewReport";


function App() {
  return (
    <div className="App">
    <Router>
    <Navbar/>

    <Routes>
      <Route exact path="/" element={<Home/>}/>
      <Route exact path="/addStudent" element={<AddStudent/>}/>
      <Route exact path="/viewReport" element={<ViewReport/>}/>
      <Route exact path="/updateStudent/:id" element={<UpdateStudent/>}/>

    </Routes>
  
    </Router>
    
    </div>
  );
}

export default App;
