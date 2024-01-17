package com.gadgets.repair.system.services.technician;

import com.gadgets.repair.system.models.dtos.TechnicianDTO;
import com.gadgets.repair.system.models.dtos.requests.TechnicianRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TechnicianService {
    TechnicianDTO createTechnician(TechnicianRequestDTO technicianRequestDTO);
    List<TechnicianDTO> getAllTechnicians();
    TechnicianDTO updateTechnician(Long technicianId, TechnicianRequestDTO technicianRequestDTO);
    void deleteTechnicianById(Long technicianId);
}
