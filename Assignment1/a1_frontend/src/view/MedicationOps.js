import React from "react";
import "bootstrap/dist/css/bootstrap.css";


const MedicationOps = ({title1, onListMedication,onDeleteMedications,onAddMedication}) => (
    <div className="container2">
    <div className="col-sm-6">
    <div className="jumbotron">  

   
    <div className="container ">   
  
    <div className="btn-group-vertical">
   
        <br />
        <br />
        
        <h2>Medication</h2>
       
        <button type="button" className="btn2" onClick={onListMedication}>Display</button>
        <button type="button" className="btn2" onClick={onDeleteMedications}>Delete</button>
        <button type="button" className="btn2" onClick={onAddMedication}>Create</button>

        
    </div>
    </div>
    </div>
    </div>
    </div>
);

export default MedicationOps;