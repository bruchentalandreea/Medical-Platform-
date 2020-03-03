import {EventEmitter} from "events";
import RestClient from "../rest/RestClient";



const client= new RestClient("doctor","password");


class Model extends EventEmitter{
    constructor(){
        super();
        this.state={
            caregivers: [{
                username: "username1",
                password: "pass1",
                email: "mirela@yahoo.com",
                name: "name1",
                birth_date:"bithdate1",
                gender:"F",
                address:"address1"
              
            },{
                username: "username2",
                password: "pass2",
                email: "mirela2@yahoo.com",
                name: "name2",
                birth_date:"bithdate2",
                gender:"F",
                address:"address2"
            }],
            newCaregiver:{
                username: "",
                password: "",
                email: "",
                name: "",
                birth_date:"",
                gender:"",
                address:""
            },
            selectedCaregiverIndex: -1

        };
    }
    changeSelectedCaregiverIndex(index) {
        this.state = {
            ...this.state,
            selectedCaregiverIndex: index
        };
        this.emit("change", this.state);
    }

    

changeNewCaregiverProperty(property,value) {
    this.state = {
        ...this.state,
        newCaregiver: {
            ...this.state.newCaregiver,
            [property]: value
        }
    };
    this.emit("change", this.state);
}


newCaregiverList(caregivers){
    this.state = {
        ...this.state,
        caregivers:caregivers
    };
    this.emit("change", this.state);

}



loadCaregiver(){
    return client.loadAllCaregivers().then(caregivers => {
        this.state = { 
            ...this.state, 
            caregivers: caregivers
        };
        this.emit("change", this.state);
    })
}

addCaregiver(username,password, email, name,birth_date,gender,address){
    return client.createCaregiver(username,password, email, name,birth_date,gender,address)
    .then(caregiver=> this.appendCaregiver(caregiver));

}

appendCaregiver(caregiver){
    this.state = {
        ...this.state,
        caregivers: this.state.caregivers.concat([caregiver])
    };
   
    this.emit("change", this.state);

}

deleteCaregiver(index){
    var id=this.getCaregiverId(index);
    return client.deleteCaregiver(id);
}

getCaregiverId(index){
    return this.state.caregivers[index].id;

}
     

}


const modelCaregiver = new Model();



export default modelCaregiver;