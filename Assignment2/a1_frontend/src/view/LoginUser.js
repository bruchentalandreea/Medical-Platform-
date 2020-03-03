import React from "react";
import "bootstrap/dist/css/bootstrap.css";
import "./LoginUser.css";




const LoginUser = ({username,password, onLoginPatient,onLoginDoctor,onCheck }) => (
  <div className="container2">
  <div className="col-sm-6">
  <div className="jumbotron">


<div className="container">
 
<div className="info" role="alert">

  <br></br>
  <h2 className="id1">Login</h2><br></br>
 
  <div>
  
  <div className="form-group">
  <label>Username: </label>
        <input type="username" className="form-control" id="user"value={ username} 
          onChange={ e => onCheck("username", e.target.value) } />
  </div>
  <div className="form-group">
  <label>Password: </label>
        <input type="password" className="form-control" id="pasw" value={ password} 
          onChange={ e => onCheck("password", e.target.value) } />
  </div>
      
      <button type="button" className="btn1" onClick={onLoginDoctor}>Submit</button>
      
    
     
  </div>


</div>

</div>
</div>
</div>
</div>
);

export default LoginUser;
