import React from "react";

const PatientDelete = ({ patients, onDeletePatient }) => (
    
    <div>
        <div className="jumbotron">  
   
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
                           
                            <td> <button className="button muted-button" onClick={() => onDeletePatient(index)}>Delete</button> </td>
                         
                          
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

export default PatientDelete;