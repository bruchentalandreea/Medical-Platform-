import React from "react";

const MedicationDelete = ({ medications, onDeleteMedication }) => (
    
    <div>
        <div className="jumbotron jumbotron-fluid">  
   
        <div className="container "> 
         <h1 >Medication</h1>

       
         <table className="table table-bordered">
         <thead>
            <tr clasNames="table-primary">
                    <th>Name</th>
                    <th>Side effects</th>

                    
                </tr>
            </thead>
            <tbody>
                {
                    medications.map((medication, index) => (
                        <tr className="table-light" key={index}>
                            <td>{medication.name}</td>
                            <td>{medication.side_effects}</td>
                        
                           
                            <td> <button className="button muted-button" onClick={() => onDeleteMedication(index)}>Delete</button> </td>
                         
                          
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

export default MedicationDelete;