package com.gadgets.repair.system.controllers;

import com.gadgets.repair.system.models.dtos.responses.TechnicianResponseDTO;
import com.gadgets.repair.system.models.dtos.requests.TechnicianRequestDTO;
import com.gadgets.repair.system.services.technician.TechnicianService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("/api/technicians")
public class TechnicianController {
    private final TechnicianService technicianService;

    public TechnicianController(TechnicianService technicianService) {
        this.technicianService = technicianService;
    }

    @PostMapping
    public ResponseEntity<TechnicianResponseDTO> createTechnician(@Valid @RequestBody TechnicianRequestDTO technicianRequestDTO) {
        return ResponseEntity.ok(technicianService.createTechnician(technicianRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<TechnicianResponseDTO>> getAllTechnicians() {
        return ResponseEntity.ok(technicianService.getAllTechnicians());
    }

    @PutMapping("/{technicianId}")
    public ResponseEntity<TechnicianResponseDTO> updateTechnician(@PathVariable Long technicianId, @Valid @RequestBody TechnicianRequestDTO technicianRequestDTO) {
        return ResponseEntity.ok(technicianService.updateTechnician(technicianId, technicianRequestDTO));
    }
    @DeleteMapping("/{technicianId}")
    public ResponseEntity<Void> deleteTechnician(@PathVariable Long technicianId){
        technicianService.deleteTechnicianById(technicianId);
        return ResponseEntity.ok().build();
    }

}
