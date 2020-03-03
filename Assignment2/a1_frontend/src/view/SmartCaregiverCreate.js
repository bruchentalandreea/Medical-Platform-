import React, { Component } from "react";
import modelCaregiver from "../model/modelCaregiver";
import CaregiverCreate from "./CaregiverCreate";
import operationsPresenter from "../presenter/operationsPresenter";

const mapModelStateToComponentState = modelState => ({
  
    username: modelState.newCaregiver.username,
    password: modelState.newCaregiver.password,
    email: modelState.newCaregiver.email,
    name: modelState.newCaregiver.name,
    birth_date: modelState.newCaregiver.birth_date,
    gender:modelState.newCaregiver.gender,
    address:modelState.newCaregiver.address
    


});

export default class SmartCaregiverCreate extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState( modelCaregiver.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        modelCaregiver.addListener("change", this.listener);
    }

    componentWillUnmount() {
        modelCaregiver.removeListener("change", this.listener);
    }

    render() {
        return (
            <CaregiverCreate
                onAddCaregiver={operationsPresenter.onAddCaregiver}
                onChangeCaregiver={operationsPresenter.onChangeCaregiver}
                
                username={this.state.username}
                password={this.state.password}
                email={this.state.email}
                name={this.state.name}
                birth_date={this.state.birth_date}
                gender={this.state.gender}
                address={this.state.address}
        
               
                 />
        );
    }
}