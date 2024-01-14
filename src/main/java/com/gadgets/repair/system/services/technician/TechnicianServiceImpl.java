package com.gadgets.repair.system.services.technician;

import com.gadgets.repair.system.models.dtos.CustomerDTO;
import com.gadgets.repair.system.models.dtos.TechnicianDTO;
import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.models.entities.Technician;
import com.gadgets.repair.system.models.requests.CustomerRequestDTO;
import com.gadgets.repair.system.models.requests.TechnicianRequestDTO;
import com.gadgets.repair.system.repositories.TechnicianRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TechnicianServiceImpl implements TechnicianService {
    private final TechnicianValidationService technicianValidationService;
    private final TechnicianRepository technicianRepository;
    private final ModelMapper modelMapper;

    public TechnicianServiceImpl(TechnicianValidationService technicianValidationService, TechnicianRepository technicianRepository, ModelMapper modelMapper) {
        this.technicianValidationService = technicianValidationService;
        this.technicianRepository = technicianRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public TechnicianDTO createTechnician(TechnicianRequestDTO technicianRequestDTO) {
        technicianValidationService.validateUniqueTechnician(technicianRequestDTO);
        Technician savedTechnician = technicianRepository.save(modelMapper.map(technicianRequestDTO, Technician.class));
        log.info("Technician with id {} saved in data base", savedTechnician.getId());

        return modelMapper.map(savedTechnician, TechnicianDTO.class);
    }

    @Override
    public List<TechnicianDTO> getAllTechnicians() {

        return technicianRepository.findAll().stream()
                .map(technician -> modelMapper.map(technician, TechnicianDTO.class))
                .toList();
    }

    @Override
    public TechnicianDTO updateTechnician(Long technicianId, TechnicianRequestDTO technicianRequestDTO) {
        Technician technician = technicianValidationService.getValidTechnician(technicianId);
        technician.setTechnicianFirstName(technicianRequestDTO.getTechnicianFirstName());
        technician.setTechnicianLastName(technicianRequestDTO.getTechnicianLastName());
        technician.setTechnicianEmail(technicianRequestDTO.getTechnicianEmail());

        Technician savedTechnician = technicianRepository.save(technician);
        log.info("Technician {} : {} updated in data base. ", savedTechnician.getId(), savedTechnician.getTechnicianFirstName());
        return modelMapper.map(savedTechnician, TechnicianDTO.class);
    }

    @Override
    public void deleteTechnicianById(Long technicianId) {
        technicianValidationService.getValidTechnician(technicianId);

        technicianRepository.deleteById(technicianId);
        log.info("Technician with id {} deleted.", technicianId);
    }
}