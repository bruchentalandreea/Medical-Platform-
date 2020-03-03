import modelPatient from "../model/modelPatient";
import modelCaregiver from "../model/modelCaregiver";
import modelMedication from "../model/modelMedication";


class OperationsPresenter{
    onPatientOps(){
        window.location.assign("#/patient-ops");
    }

    onMedicationOps(){
        window.location.assign("#/medication-ops");
    }

    onCaregiverOps(){
        window.location.assign("#/caregiver-ops");
    }
    ////////

    
    onAddPatient(){
        modelPatient.addPatient(
            modelPatient.state.newPatient.username,
            modelPatient.state.newPatient.password,
            modelPatient.state.newPatient.email,
            modelPatient.state.newPatient.name,
            modelPatient.state.newPatient.birth_date,
            modelPatient.state.newPatient.gender,
            modelPatient.state.newPatient.address,
            modelPatient.state.newPatient.medical_record

        
            );
        modelPatient.changeNewPatientProperty("username",  "");
        modelPatient.changeNewPatientProperty("password",  "");
        modelPatient.changeNewPatientProperty("email",   "");
        modelPatient.changeNewPatientProperty("name",   "");
        modelPatient.changeNewPatientProperty("birth_date",  "");
        modelPatient.changeNewPatientProperty("gender",   "");
        modelPatient.changeNewPatientProperty("address",   "");
        modelPatient.changeNewPatientProperty("medical_record",   "");



        window.location.assign("#/patient/add");
    }
    onAddMedication(){
        modelMedication.addMedication(
            modelMedication.state.newMedication.name,
            modelMedication.state.newMedication.side_effects
        
            );
        modelMedication.changeNewMedicationProperty("name", "");
        modelMedication.changeNewMedicationProperty("side_effects",  "");
      

        window.location.assign("#/medication/add");

    }
    onAddCaregiver(){
        modelCaregiver.addCaregiver(
            modelCaregiver.state.newCaregiver.username,
            modelCaregiver.state.newCaregiver.password,
            modelCaregiver.state.newCaregiver.email,
            modelCaregiver.state.newCaregiver.name,
            modelCaregiver.state.newCaregiver.birth_date,
            modelCaregiver.state.newCaregiver.gender,
            modelCaregiver.state.newCaregiver.address

        
            );

            modelCaregiver.changeNewCaregiverProperty("username", "");
            modelCaregiver.changeNewCaregiverProperty("password", "");
            modelCaregiver.changeNewCaregiverProperty("email", "");
            modelCaregiver.changeNewCaregiverProperty("name", "");
            modelCaregiver.changeNewCaregiverProperty("birth_date",  "");
            modelCaregiver.changeNewCaregiverProperty("gender",   "");
            modelCaregiver.changeNewCaregiverProperty("address",   "");
      

        window.location.assign("#/caregiver/add");


    }


///////
    onListPatients(){
        window.location.assign("#/patient/all");
    }
    onListMedication(){
        window.location.assign("#/medication/all");
    }
    onListCaregiver(){
        window.location.assign("#/caregiver/all");
    }
    

//////////

    onDeletePatients(){
   
      window.location.assign("#/patient/remove" );
    
    }
  onDeletePatient(index){
        modelPatient.deletePatient(index)
        .then(() =>{
          window.location.assign("#/patient/remove" + index);
        });
      }
      

      onDeleteMedications(){
          window.location.assign("#/medication/remove");
      }
    onDeleteMedication(index){
        modelMedication.deleteMedication(index)
        .then(() =>{
          window.location.assign("#/medication/remove" + index);
        });
      }

      
    onDeleteCaregiver(index){
        modelCaregiver.deleteCaregiver(index)
        .then(() =>{
          window.location.assign("#/caregiver/all" + index);
        });
      }

  

    onChange(property, value) {
        modelPatient.changeNewPatientProperty(property, value);
    }
    onChangeMedication(property, value) {
        modelMedication.changeNewMedicationProperty(property, value);
    }
    onChangeCaregiver(property, value) {
        modelCaregiver.changeNewCaregiverProperty(property, value);
    }

    onInitCaregiver(){
        modelCaregiver.loadCaregiver();
    }

    //////////////////
    // onEdit(id) {
    //     modelPatient.editPatient(modelPatient.state.newPatient.medical_record,id).then(() =>{
    //       window.location.assign("#/edit-list" );
    //     });
    // }

   
    // onEditPatient(){
        
    //         window.location.assign("#/edit-list" );
       
    // }




}

const operationsPresenter=new OperationsPresenter();
export default operationsPresenter;