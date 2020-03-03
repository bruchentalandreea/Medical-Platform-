import React from "react";

const CaregiverList = ({ caregivers }) => (
    
    <div>
        <div className="jumbotron jumbotron-fluid">  
   
        <div className="container "> 
         <h1 >All the caregivers</h1>


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


              
                    
                </tr>
            </thead>

            <tbody>
                {
                    caregivers.map((caregiver, index) => (
                        <tr className="table-light" key={index}>
                            <td>{caregiver.username}</td>
                            <td>{caregiver.password}</td>
                            <td>{caregiver.email}</td>
                            <td>{caregiver.name}</td>
                            <td>{caregiver.birth_date}</td>
                            <td>{caregiver.gender}</td>
                            <td>{caregiver.address}</td>
 
                          
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

export default CaregiverList;