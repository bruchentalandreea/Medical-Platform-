import React from "react";
import "bootstrap/dist/css/bootstrap.css";
import "./DoctorOperations.css";


const DoctorOperations = ({title1, onMedicationOps,onCaregiverOps,onPatientOps}) => (
    <div className="container2">
    <div className="col-sm-6">
    <div className="jumbotron2">  

   
    <div className="container ">   
    <br></br>
    <br></br>
    <div className="btn-group-vertical">
        <h2 className = "id2 ">Operations</h2>
        
       
        <button type="button" className="btn2" onClick={onPatientOps}> Patients</button>
        <button type="button" className="btn2" onClick={onMedicationOps}> Medication</button>
        <button type="button" className="btn2" onClick={onCaregiverOps}> Caregiver</button>
        <br />
        <br />
        
    </div>
    </div>
    </div>
    </div>
    </div>
);

export default DoctorOperations;