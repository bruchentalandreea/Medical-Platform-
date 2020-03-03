const BASE_URL = "http://localhost:8080";

export default class RestClient {
    constructor(username, password) {
        this.authorization = "Basic " + btoa(username + ":" + password);
    }

    //LOAD OPERATION

    loadAllPatients() {
        return fetch(BASE_URL + "/patient/all", {
            credentials:"include",
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    loadAllMedication() {
        return fetch(BASE_URL + "/medication/all", {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }


    loadAllCaregivers() {
        return fetch(BASE_URL + "/caregiver/all", {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }



    //CREATE OPERATION

    createPatient(id,username,password,email,name,birth_date,gender,address) {
        return fetch(BASE_URL + "/patient/add", {
            method: "POST", 
            body: JSON.stringify({
                id:null,
                username:username,
                password:password,
                email:email,
                name:name,
                birth_date:birth_date,
                gender:gender,
                address:address
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());
    }


    
    
    // editPatient(medical_record,id) {
    //     return fetch(BASE_URL + "/patients/" + id, {
    //         method: "PUT",
    //         headers: {
    //             "Authorization": this.authorization,
    //             "Content-Type": "application/json"
    //         },
    //         body: JSON.stringify({
    //             id:id,
    //             name:null ,
    //             birth_date: null,
    //             gender:null,
    //             addr:null,
    //             medical_record:medical_record
    //         })
    //     }).then(response => response.json());
    // }

 



    createMedication(name,side_effects) {
        return fetch(BASE_URL + "/medication/add", {
            method: "POST", 
            body: JSON.stringify({
                id:null,
                name:name,
                side_effects:side_effects
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json",
                "Accept": "application/json"
            }
        }).then(response => response.json());
    }

    createCaregiver(username,password,email,name,birth_date,gender,address) {
        return fetch(BASE_URL + "/caregiver/add", {
            method: "POST", 
            body: JSON.stringify({
                 id:null,
                username:username,
                password:password,
                email:email,
                name:name,
                birth_date:birth_date,
                gender:gender,
                address:address
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());
    }





    //DELETE OPERATION    

    deletePatient(id){
        return fetch(BASE_URL + "/patient/remove/"+ id, {
            method: "POST",
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());

    }

    deleteMedication(id){
        return fetch(BASE_URL + "/medication/remove/"+ id, {
            method: "POST",
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());

    }

    deleteCaregiver(id){
        return fetch(BASE_URL + "/caregiver/remove/"+ id, {
            method: "POST",
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());

    }

 
  
   
    

}