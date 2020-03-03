import React, { Component } from "react";
import modelPatient from "../model/modelPatient";
import PatientCreate from "./PatientCreate";
import operationsPresenter from "../presenter/operationsPresenter";

const mapModelStateToComponentState = modelState => ({
  
    username: modelState.newPatient.username,
    password: modelState.newPatient.password,
    email: modelState.newPatient.email,
    name: modelState.newPatient.name,
    birth_date: modelState.newPatient.birth_date,
    gender:modelState.newPatient.gender,
    address:modelState.newPatient.address,
    medical_record:modelState.newPatient.medical_record
    

});

export default class SmartPatientCreate extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState( modelPatient.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        modelPatient.addListener("change", this.listener);
    }

    componentWillUnmount() {
        modelPatient.removeListener("change", this.listener);
    }

    render() {
        return (
            <PatientCreate
                onAddPatient={operationsPresenter.onAddPatient}
                onChange={operationsPresenter.onChange}
                
                username={this.state.username}
                password={this.state.password}
                email={this.state.email}
                name={this.state.name}
                birth_date={this.state.birth_date}
                gender={this.state.gender}
                address={this.state.address}
                medical_record={this.state.medical_record}
               
                 />
        );
    }
}