class DoctorOperationsPresenter{

    onAddPatient(){
        window.location.assign("#/patient/add");
    }

    onListPatients(){
        window.location.assign("#/patient/all");
    }
    onPatientOps(){
        window.location.assign("#/patient-ops");
    }
    
}

const doctorOperationsPresenter=new DoctorOperationsPresenter();
export default doctorOperationsPresenter;