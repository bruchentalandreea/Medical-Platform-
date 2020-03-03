import React from "react";
import "bootstrap/dist/css/bootstrap.css";

const PatientCreate = ({ username,password, email, name,birth_date,gender,address,medical_record, onAddPatient, onChange }) => (
    <div>
         <div className="jumbotron jumbotron-fluid">  
        
        <div className="container "> 
        <h1 >Add Patient</h1>

        <div className="form-group">
              <label htmlFor="aut">Username:</label>
              <input type="username" className="form-control" id="dat" value={username} 
               onChange={ e => onChange("username", e.target.value) } />
        </div>

        <div className="form-group">
              <label htmlFor="aut">Password:</label>
              <input type="password" className="form-control" id="dat" value={password} 
               onChange={ e => onChange("password", e.target.value) } />
        </div>

        <div className="form-group">
              <label htmlFor="aut">Email:</label>
              <input type="email" className="form-control" id="dat" value={email} 
               onChange={ e => onChange("email", e.target.value) } />
        </div>

        <div className="form-group">
              <label htmlFor="aut">Name:</label>
              <input type="name" className="form-control" id="dat" value={name} 
               onChange={ e => onChange("name", e.target.value) } />
        </div>

        <div className="form-group">
              <label htmlFor="aut">Birth Date:</label>
              <input type="name" className="form-control" id="dat" value={birth_date} 
                onChange={ e => onChange("birth_date", e.target.value) } />
        </div>

        <div className="form-group">
            <label htmlFor="aut">Gender:</label>
             <input type="gender" className="form-control" id="gender" value={gender} 
                onChange={ e => onChange("gender", e.target.value) } />
        </div>
        <div className="form-group">
            <label htmlFor="aut">Address:</label>
             <input type="address" className="form-control" id="pat" value={address} 
                onChange={ e => onChange("address", e.target.value) } />
        </div>

        <div className="form-group">
            <label htmlFor="aut">Medical Record:</label>
             <input type="patient_id_id" className="form-control" id="pat" value={medical_record} 
                onChange={ e => onChange("medical_record", e.target.value) } />
        </div>

            <button type="button" className="btn btn-primary" onClick={onAddPatient}>Create!</button>
        </div>
    </div>
    </div>
);

export default PatientCreate;