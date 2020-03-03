package com.example.springdemo.controller;

import com.example.springdemo.entities.MedicationPlan;
import com.example.springdemo.errorhandler.NotFoundException;
import com.example.springdemo.repository.MedicationPlanRepository;
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
public class MedicationPlanController {


    @Autowired
    private MedicationPlanRepository medicationRepository;

    @GetMapping("/all")
    public List<MedicationPlan> getAll(){
        return medicationRepository.findAll();
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public String addMedication(@Valid @RequestBody  MedicationPlan medication) {
        medicationRepository.save(medication);
        return"Succes";
    }


    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteMedication(@Valid @RequestBody  MedicationPlan medication) {
        medicationRepository.delete(medication);
        return "Medication deleted";
    }


    @PostMapping(value = "/remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String  removeMedication(@PathVariable("id") Integer id) {
        MedicationPlan medication = medicationRepository.findById(id).orElseThrow(NotFoundException::new);
        medicationRepository.delete(medication);
        return "Medication removed";

    }

}
