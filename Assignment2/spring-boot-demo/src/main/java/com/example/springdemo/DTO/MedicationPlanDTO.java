package com.example.springdemo.DTO;

import java.io.Serializable;
import java.util.List;

public class MedicationPlanDTO  {

    private  Integer idPatient;
    private List<IntakeIntervalsDTO> intakes;

    public MedicationPlanDTO(Integer idPatient, List<IntakeIntervalsDTO> intakes) {
        this.idPatient = idPatient;
        this.intakes = intakes;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public List<IntakeIntervalsDTO> getIntakes() {
        return intakes;
    }

    public void setIntakes(List<IntakeIntervalsDTO> intakes) {
        this.intakes = intakes;
    }
}
