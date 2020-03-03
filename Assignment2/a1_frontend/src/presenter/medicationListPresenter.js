import modelMedication from "../model/modelMedication";

class MedicationListPresenter{
    onCreateMedication(){
        modelMedication.addMedication(
            modelMedication.state.newMedication.name,
            modelMedication.state.newMedication.side_effects
            );

    }

    onInit(){
        modelMedication.loadMedication();
    }

    
}

const medicationListPresenter=new MedicationListPresenter();
export default medicationListPresenter;