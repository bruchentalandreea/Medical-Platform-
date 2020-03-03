package com.example.springdemo.controller;

import com.example.springdemo.entities.Patient;
import com.example.springdemo.errorhandler.NotFoundException;
import com.example.springdemo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/all")
    public List<Patient> getAll(){
        return patientRepository.findAll();
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public String addPatient(@Valid @RequestBody  Patient patient) {
        patientRepository.save(patient);
        return"Succes";
    }


    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deletePatient(@Valid @RequestBody  Patient patient) {
        patientRepository.delete(patient);
        return "Patient deleted";
    }


    @PostMapping(value = "/remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String  removePatient(@PathVariable("id") Integer id) {
        Patient patient = patientRepository.findById(id).orElseThrow(NotFoundException::new);
        patientRepository.delete(patient);
        return "Patient removed";

    }


}
