package com.example.springdemo.repositories;

public interface RepositoryFactory {
    UserRepository createUserRepository();

    PatientRepository createPatientRepository();

    MedicationRepository createMedicationRepository();

    CaregiverRepository createCaregiverRepository();
}
