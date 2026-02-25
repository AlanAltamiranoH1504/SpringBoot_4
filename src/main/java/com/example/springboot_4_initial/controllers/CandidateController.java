package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.dto.candidate.CreateCandidateDTO;
import com.example.springboot_4_initial.services.interfaces.ICandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private ICandidateService iCandidateService;

    @PostMapping("/save")
    public ResponseEntity<?> save_candidate(@Valid @RequestBody CreateCandidateDTO createCandidateDTO) {
        Map<String, Object> res = new HashMap<>();
        iCandidateService.save_candidate(createCandidateDTO);
        res.put("status", true);
        res.put("message", "Cuenta creada. Confirma en tu correo electronico.");
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
