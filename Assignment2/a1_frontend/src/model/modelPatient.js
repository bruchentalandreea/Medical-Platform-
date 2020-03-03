import {EventEmitter} from "events";
import RestClient from "../rest/RestClient";



const client= new RestClient("doctor","password");


class Model extends EventEmitter{
    constructor(){
        super();
        this.state={
            patients: [{
                username: "username1",
                password: "pass1",
                email: "mirela@yahoo.com",
                name: "name1",
                birth_date:"bithdate1",
                gender:"F",
                address:"address1",
                medical_record:"med record1"
            },{
                username: "username1",
                password: "pass1",
                email: "mirela@yahoo.com",
                name: "name1",
                birth_date:"bithdate1",
                gender:"F",
                address:"address1",
                medical_record:"med record2"
            }],
            newPatient:{
                username: "",
                password: "",
                email: "",
                name: "",
                birth_date:"",
                gender:"",
                address:"",
                medical_record:""
            },
            selectedPatientIndex: -1

        };
    }
    changeSelectedPatientsIndex(index) {
        this.state = {
            ...this.state,
            selectedPatientIndex: index
        };
        this.emit("change", this.state);
    }

    

changeNewPatientProperty(property,value) {
    this.state = {
        ...this.state,
        newPatient: {
            ...this.state.newPatient,
            [property]: value
        }
    };
    this.emit("change", this.state);
}


newPatientList(patients){
    this.state = {
        ...this.state,
        patients:patients
    };
    this.emit("change", this.state);

}

/*
deletePatient(id){
    this.state = {
        ...this.state,
        patients: this.state.patients.splice(id, 1)
    };
    this.emit("change", this.state);
}


*/
loadPatients(){
    return client.loadAllPatients().then(patients => {
        this.state = { 
            ...this.state, 
            patients: patients
        };
        this.emit("change", this.state);
    })
}


addPatient(username,password,email,name,birth_date,gender,addrres,medical_record){
    return client.createPatient(username,password,email,name,birth_date,gender,addrres,medical_record)
    .then(patient=> this.appendPatient(patient));

}


deletePatient(index){
    var id=this.getPatientId(index);
    return client.deletePatient(id);
}

getPatientId(index){
    return this.state.patients[index].id;

}



appendPatient(patient){
    this.state = {
        ...this.state,
        patients: this.state.patients.concat([patient])
    };
   
    this.emit("change", this.state);

}


// editPatient(medical_record, index){
//     var id = this.getPatientId(index);

//     return client.editPatient(medical_record, id).then(patient=>{
//         this.setState = {
//             ...this.state[index],
//             medical_record: medical_record
//         }
// });
// } 


}



const modelPatient = new Model();



export default modelPatient;