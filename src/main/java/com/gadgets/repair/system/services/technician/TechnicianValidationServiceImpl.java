package com.gadgets.repair.system.services.technician;

import com.gadgets.repair.system.exceptions.DuplicateResourceException;
import com.gadgets.repair.system.exceptions.ResourceNotFoundException;
import com.gadgets.repair.system.models.entities.Technician;
import com.gadgets.repair.system.models.requests.TechnicianRequestDTO;
import com.gadgets.repair.system.repositories.TechnicianRepository;
import org.springframework.stereotype.Service;


@Service
public class TechnicianValidationServiceImpl implements TechnicianValidationService{
    private final TechnicianRepository technicianRepository;

    public TechnicianValidationServiceImpl(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    @Override
    public void validateUniqueTechnician(TechnicianRequestDTO technicianRequestDTO) {
        Technician foundTechnician = technicianRepository.findByTechnicianEmail(technicianRequestDTO.getTechnicianEmail());
        if (foundTechnician != null) {
            throw new DuplicateResourceException("Email already exists!");
        }
    }

    @Override
    public Technician getValidTechnician(Long technicianId) {
        Technician technician = technicianRepository.findById(technicianId)
                .orElseThrow(() -> new ResourceNotFoundException("Technician with id" + technicianId + "not found"));
        return technician;
    }
}
