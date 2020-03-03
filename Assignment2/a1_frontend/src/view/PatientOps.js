import React from "react";
import "bootstrap/dist/css/bootstrap.css";
import "./PatientOps.css"; 


const PatientOps = ({title1, onListPatients,onDeletePatients,onAddPatient,onEditPatient}) => (
    <div className="container2 "> 
    <div className="col-sm-6">
    <div className="jumbotron">  

   
    <div className="container ">   
    
    <div className="btn-group-vertical">
        <br></br>
        <br></br>
        <h2>Patients</h2>
       
        <button type="button" className="btn2" onClick={onListPatients}>Display</button>
        <button type="button" className="btn2" onClick={onDeletePatients}>Delete</button>
        <button type="button" className="btn2" onClick={onAddPatient}>Create</button>
        <button type="button" className="btn2" onClick={onEditPatient}>Edit</button>

        
    </div>
    </div>
    </div>
    </div>
    </div>
);

export default PatientOps;