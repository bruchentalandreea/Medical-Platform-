import React from "react";

const PatientEdit = ({ patients, onEdit,newRecord,onChange }) => (
    
    <div>
        <div className="jumbotron jumbotron-fluid">  
   
        <div className="container "> 
         <h1 >Patients</h1>

       
         <table className="table table-bordered">
         <thead>
            <tr className="table-primary">
                    <th>Username</th>
                    <th>Password</th>
                    <th>Email</th>
                    <th>Name</th>
                    <th>Birth Date</th>
                    <th>Gender</th>
                    <th>Address</th>
                    <th>Medical Record</th>
                  


              
                    
                </tr>
            </thead>
            <tbody>
                {
                        patients.map((patient, index) => (
                        <tr className="table-light" key={index}>
                             <td>{patient.username}</td>
                            <td>{patient.password}</td>
                            <td>{patient.email}</td>
                            <td>{patient.name}</td>
                            <td>{patient.birth_date}</td>
                            <td>{patient.gender}</td>
                            <td>{patient.address}</td>
                            <td>{patient.medical_record}</td>
                           

                            <label>Medical_record: </label>
                  
                    <input value={newRecord} onChange={ e => onChange("medical_record", e.target.value)} />
                    <br />
                    <button onClick = {() => onEdit(index)}>Update</button>
                          
                        </tr>
                    ))
                }
            </tbody>
        </table>
        <br />
       
    </div>
    </div>
    </div>
    
);

export default PatientEdit;