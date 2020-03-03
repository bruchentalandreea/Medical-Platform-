import React from "react";
import "bootstrap/dist/css/bootstrap.css";
import "./CaregiverOps.css"; 

const CaregiverOps = ({title1, onListCaregiver,onDeleteCaregiver,onAddCaregiver}) => (
    <div className="container2">
    <div className="col-sm-6">
    <div className="jumbotron">  

   
    <div className="container ">   
    
    <div className="btn-group">
        
        <br></br>
        <br></br>
        <h2>Caregiver</h2>
        <button type="button" className="btn3" onClick={onListCaregiver}>Display </button>
        <button type="button" className="btn3" onClick={onDeleteCaregiver}>Delete</button>
        <button type="button" className="btn3" onClick={onAddCaregiver}>Create </button>

      
        
    </div>
    </div>
    </div>
    </div>
    </div>
);

export default CaregiverOps;