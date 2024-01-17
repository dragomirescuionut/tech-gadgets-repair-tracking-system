package com.gadgets.repair.system.services.technician;

import com.gadgets.repair.system.models.dtos.responses.TechnicianResponseDTO;
import com.gadgets.repair.system.models.dtos.requests.TechnicianRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TechnicianService {
    TechnicianResponseDTO createTechnician(TechnicianRequestDTO technicianRequestDTO);
    List<TechnicianResponseDTO> getAllTechnicians();
    TechnicianResponseDTO updateTechnician(Long technicianId, TechnicianRequestDTO technicianRequestDTO);
    void deleteTechnicianById(Long technicianId);
}
