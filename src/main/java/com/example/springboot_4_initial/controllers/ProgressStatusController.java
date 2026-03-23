package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.dto.ListEntityDTO;
import com.example.springboot_4_initial.dto.progressStatus.CreateProgressStatusDTO;
import com.example.springboot_4_initial.dto.progressStatus.UpdateProgressStatusDTO;
import com.example.springboot_4_initial.services.interfaces.IProgressStatusService;
import com.example.springboot_4_initial.services.interfaces.IResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/progress_status")
public class ProgressStatusController {
    @Autowired
    private IProgressStatusService iProgressStatusService;
    @Autowired
    private IResponseService iResponseService;

    @GetMapping("/list")
    public ResponseEntity<?> listProgressStatus(@Valid @RequestBody ListEntityDTO listEntityDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(iProgressStatusService.findAll(listEntityDTO));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProgressStatus(@Valid @RequestBody CreateProgressStatusDTO createProgressStatusDTO) {
        iProgressStatusService.save(createProgressStatusDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                iResponseService.generate_response(true, "Estado de progreso creado correctamente")
        );
    }

    @GetMapping("/find/{idProgress}")
    public ResponseEntity<?> findProgressStatus(@PathVariable Long idProgress) {
        return ResponseEntity.status(HttpStatus.OK).body(iProgressStatusService.findById(idProgress));
    }

    @PutMapping("/update/{idProgress}")
    public ResponseEntity<?> updateProgressStatus(@Valid @RequestBody UpdateProgressStatusDTO updateProgressStatusDTO, @PathVariable Long idProgress) {
        iProgressStatusService.update(updateProgressStatusDTO, idProgress);
        return ResponseEntity.status(HttpStatus.OK).body(
                iResponseService.generate_response(true, "Estado de progreso actualizado correctamente")
        );
    }

    @DeleteMapping("/delete/{idProgress}")
    public ResponseEntity<?> deleteProgressStatus(@PathVariable Long idProgress) {
        iProgressStatusService.delete(idProgress);
        return ResponseEntity.status(HttpStatus.OK).body(
                iResponseService.generate_response(true, "Estado de progreso eliminado correctamente")
        );
    }

    @DeleteMapping("/destroy/{idProgress}")
    public ResponseEntity<?> destroyProgressStatus(@PathVariable Long idProgress) {
        iProgressStatusService.destroy(idProgress);
        return ResponseEntity.status(HttpStatus.OK).body(
                iResponseService.generate_response(true, "Estado de progreso destruido correctamente")
        );
    }
}
