package com.example.springdemo.controller;


import com.example.springdemo.entities.Medication;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.errorhandler.NotFoundException;
import com.example.springdemo.repositories.MedicationRepository;
import com.example.springdemo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/medication")
@CrossOrigin
public class MedicationController {


    @Autowired
    private MedicationRepository medicationRepository;

    @GetMapping("/all")
    public List<Medication> getAll(){
        return medicationRepository.findAll();
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public String addMedication(@Valid @RequestBody  Medication medication) {
        medicationRepository.save(medication);
        return"Succes";
    }


    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteMedication(@Valid @RequestBody  Medication medication) {
        medicationRepository.delete(medication);
        return "Medication deleted";
    }


    @PostMapping(value = "/remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String  removeMedication(@PathVariable("id") Integer id) {
        Medication medication = medicationRepository.findById(id).orElseThrow(NotFoundException::new);
        medicationRepository.delete(medication);
        return "Medication removed";

    }

}
