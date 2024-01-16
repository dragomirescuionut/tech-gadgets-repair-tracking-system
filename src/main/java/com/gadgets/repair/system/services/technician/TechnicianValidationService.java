package com.gadgets.repair.system.services.technician;

import com.gadgets.repair.system.models.entities.Technician;
import com.gadgets.repair.system.models.dtos.requests.TechnicianRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface TechnicianValidationService {
    void validateUniqueTechnician(TechnicianRequestDTO technicianRequestDTO);

    Technician getValidTechnician(Long technicianId);
}
