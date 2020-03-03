package com.example.springdemo.controller;


import com.example.springdemo.DTO.CreateCaregiverDTO;
import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.errorhandler.NotFoundException;
import com.example.springdemo.repositories.CaregiverRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/caregiver")
@CrossOrigin
public class CaregiverController {

    @Autowired
    private CaregiverRepository caregiverRepository;

    @GetMapping("/all")
    public List<Caregiver> getAll() {
        return caregiverRepository.findAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public String addCaregiver(@Valid @RequestBody Caregiver caregiver) {
        caregiverRepository.save(caregiver);
        return "Succes";
    }


    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCaregiver(@Valid @RequestBody Caregiver caregiver) {
        caregiverRepository.delete(caregiver);
        return "Caregiver deleted";
    }


    @PostMapping(value = "/remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String removeCaregiver(@PathVariable("id") Integer id) {
        Caregiver caregiver = caregiverRepository.findById(id).orElseThrow(NotFoundException::new);
        caregiverRepository.delete(caregiver);
        return "Patient removed";

    }

}

    /*

        private final CaregiverService cms;

    public CaregiverController(CaregiverService cms) {
        this.cms = cms;
    }


    //CAREGIVER
    @GetMapping("/caregiver")
    public List<CreateCaregiverDTO> readAllCaregivers() {
        return cms.listCaregiverDTO();
    }

    @DeleteMapping("/caregiver/{id}")
    public void removeCaregiver(@PathVariable int id) {
        cms.removeCaregiver(id);
    }

    @PostMapping("/caregiver")
    public CreateCaregiverDTO createCaregiver(@RequestBody CreateCaregiverDTO dto) {
        return cms.addCaregiverDTO(dto);
    }
    */


