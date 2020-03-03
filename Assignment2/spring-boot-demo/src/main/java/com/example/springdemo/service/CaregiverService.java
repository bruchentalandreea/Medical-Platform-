/*package com.example.springdemo.service;


import com.example.springdemo.DTO.CaregiverDTO;
import com.example.springdemo.DTO.CreateCaregiverDTO;
import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.errorhandler.NotFoundException;
import com.example.springdemo.repositories.CaregiverRepository;
import com.example.springdemo.repositories.RepositoryFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaregiverService {

    private RepositoryFactory repositoryFactory;

    @Transactional
    public List<CreateCaregiverDTO> listCaregiverDTO() {

        return repositoryFactory.createCaregiverRepository().findAll().stream()
                .map(CreateCaregiverDTO::ofEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public CreateCaregiverDTO addCaregiverDTO(CreateCaregiverDTO dto) {
        Caregiver caregiver = new Caregiver();

        caregiver.setUsername(dto.getUsername());
        caregiver.setPassword(dto.getPassword());
        caregiver.setName(dto.getName());
        caregiver.setEmail(dto.getEmail());
        caregiver.setBirth_date(dto.getBirthDate());
        caregiver.setAddress(dto.getAddress());
        caregiver.setGender(dto.getGender());


        CreateCaregiverDTO output = CreateCaregiverDTO.ofEntity(repositoryFactory.createCaregiverRepository().save(caregiver));
        //  eventPublisher.publishEvent(new PatientCreatedEvent(output));
        return output;

    }

    @Transactional
    public void removeCaregiver(int id) {
        CaregiverRepository repository = repositoryFactory.createCaregiverRepository();
        Caregiver caregiver = repository.findById(id).orElseThrow(NotFoundException::new);
        repository.remove(caregiver);

    }
}
*/