import React from "react";

const MedicationList = ({ medications }) => (
    
    <div>
        <div className="jumbotron jumbotron-fluid">  
   
        <div className="container"> 
         <h1 >All the medication</h1>

       
         <table className="table table-bordered">
         <thead>
            <tr className="table-primary">
                    <th>Name</th>
                    <th>Side effects</th>
    
                 
                </tr>
            </thead>
            <tbody>
                {
                    medications.map(( medication, index) => (
                        <tr className="table-light" key={index}>
                            <td>{medication.name}</td>
                            <td>{medication.side_effects}</td>

                            
 
                          
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

export default MedicationList;