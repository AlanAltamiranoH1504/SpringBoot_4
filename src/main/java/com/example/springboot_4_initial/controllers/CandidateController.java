package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.dto.ListEntityDTO;
import com.example.springboot_4_initial.services.interfaces.ICandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private ICandidateService iCandidateService;

    @GetMapping("/list")
    public ResponseEntity<?> list_candidates(@Valid @RequestBody ListEntityDTO listEntityDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(iCandidateService.list_candidates(listEntityDTO.getStatus()));
    }

    @GetMapping("/find_candidate/{id_candidate}")
    public ResponseEntity<?> find_candidate(@PathVariable() Long id_candidate) {
        return ResponseEntity.status(HttpStatus.OK).body(iCandidateService.get_candidate(id_candidate));
    }

    @DeleteMapping("/delete_candidate/{id_candidate}")
    public ResponseEntity<?> delete_candidate(@PathVariable() Long id_candidate) {
        Map<String, Object> res = new HashMap<>();
        res.put("status", true);
        res.put("message", "Candidato deshabilitado");
        iCandidateService.delete_candidate(id_candidate);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/destroy_candidate/{id_candidate}")
    public ResponseEntity<?> destroy_candidate(@PathVariable() Long id_candidate) {
        Map<String, Object> res = new HashMap<>();
        res.put("status", true);
        res.put("message", "Candidato eliminado");
        iCandidateService.destroy_candidate(id_candidate);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
