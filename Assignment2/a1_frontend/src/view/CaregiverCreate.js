import React from "react";
import "bootstrap/dist/css/bootstrap.css";

const CaregiverCreate = ({ username,password, email, name,birth_date,gender,address, onAddCaregiver, onChangeCaregiver }) => (
    <div>
         <div className="jumbotron jumbotron-fluid">  
        
        <div className="container "> 
        <h1 >Add Caregiver</h1>


        <div className="form-group">
              <label for="aut">Username:</label>
              <input type="username" className="form-control" id="dat" value={username} 
               onChange={ e => onChangeCaregiver("username", e.target.value) } />
        </div>

        <div className="form-group">
              <label for="aut">Password:</label>
              <input type="password" className="form-control" id="dat" value={password} 
               onChange={ e => onChangeCaregiver("password", e.target.value) } />
        </div>

        <div className="form-group">
              <label for="aut">Email:</label>
              <input type="email" className="form-control" id="dat" value={email} 
               onChange={ e => onChangeCaregiver("email", e.target.value) } />
        </div>

        <div className="form-group">
              <label for="aut">Name:</label>
              <input type="name" className="form-control" id="dat" value={name} 
               onChange={ e => onChangeCaregiver("name", e.target.value) } />
        </div>

        <div className="form-group">
              <label for="aut">Birth Date:</label>
              <input type="name" className="form-control" id="dat" value={birth_date} 
                onChange={ e => onChangeCaregiver("birth_date", e.target.value) } />
        </div>

        <div className="form-group">
            <label for="aut">Gender:</label>
             <input type="gender" className="form-control" id="gender" value={gender} 
                onChange={ e => onChangeCaregiver("gender", e.target.value) } />
        </div>
        <div clasNames="form-group">
            <label for="aut">Address:</label>
             <input type="address" className="form-control" id="pat" value={address} 
                onChange={ e => onChangeCaregiver("address", e.target.value) } />
        </div>

            <button type="button" className="btn btn-primary" onClick={onAddCaregiver}>Create!</button>
        </div>
    </div>
    </div>
);

export default CaregiverCreate;