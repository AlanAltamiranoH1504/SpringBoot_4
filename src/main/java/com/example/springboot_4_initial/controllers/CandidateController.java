package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.dto.ShowEntityDTO;
import com.example.springboot_4_initial.dto.candidate.UpdateCandidateDTO;
import com.example.springboot_4_initial.services.interfaces.ICandidateService;
import com.example.springboot_4_initial.services.interfaces.IResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private IResponseService iResponseService;
    @Autowired
    private ICandidateService iCandidateService;

    @GetMapping("/find_candidate/{id_candidate}")
    public ResponseEntity<?> findCandidate(@PathVariable Long id_candidate) {
        return ResponseEntity.status(HttpStatus.OK).body(iCandidateService.get_candidate(id_candidate));
    }

    @GetMapping("/show_candidate")
    public ResponseEntity<?> showCandidate(@Valid @RequestBody ShowEntityDTO showEntityDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(iCandidateService.show_candidate(showEntityDTO));
    }

    @DeleteMapping("/destroy_candidate/{id_candidate}")
    private ResponseEntity<?> deleteCandidate(@PathVariable Long id_candidate) {
        iCandidateService.destroy_candidate(id_candidate);
        return ResponseEntity.status(HttpStatus.OK)
                .body(iResponseService.generate_response(true, "Candidato eliminado de base de datos"));
    }

    @PostMapping("/update_img_profile/{id_candidate_crypt}")
    public ResponseEntity<?> update_img_profile(@PathVariable String id_candidate_crypt, @RequestParam("file") MultipartFile img_profile) throws IOException {
        iCandidateService.update_img_profile(img_profile, id_candidate_crypt);
        return ResponseEntity.status(HttpStatus.OK).body(
                iResponseService.generate_response(true, "Imagen de candidato guardada correctamente")
        );
    }

    @PutMapping("/update_candidate")
    public ResponseEntity<?> update_candiate(@Valid @RequestBody UpdateCandidateDTO updateCandidateDTO) {
        iCandidateService.update_candidate(updateCandidateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                iResponseService.generate_response(true, "Candidato Actualizado correctamente. Inicia sesion nuevamente.")
        );
    }
}
