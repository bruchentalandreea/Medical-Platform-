import React from 'react';
import "bootstrap/dist/css/bootstrap.css";

const MedicationCreate = ({ name,side_effects, onAddMedication, onChangeMedication }) => (
    <div>
         <div className="jumbotron jumbotron-fluid">  
        
        <div className="container "> 
        <h1 >Add Medication</h1>



        <div className="form-group">
              <label htmlFor="aut">Name:</label>
              <input type="name" className="form-control" id="dat" value={name} 
                onChange={ e => onChangeMedication("name", e.target.value) } />
        </div>

        <div className="form-group">
              <label htmlFor="aut">Side effects:</label>
              <input type="name" className="form-control" id="dat" value={side_effects} 
                onChange={ e => onChangeMedication("side_effects", e.target.value) } />
        </div>
       

            <button type="button" className="btn btn-primary" onClick={onAddMedication}>Create!</button>
        </div>
    </div>
    </div>
);

export default MedicationCreate;