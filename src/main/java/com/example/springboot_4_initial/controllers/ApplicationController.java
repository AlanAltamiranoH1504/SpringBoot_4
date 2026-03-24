package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.dto.application.CreateApplicationDTO;
import com.example.springboot_4_initial.services.interfaces.IApplicationService;
import com.example.springboot_4_initial.services.interfaces.ICryptoService;
import com.example.springboot_4_initial.services.interfaces.IResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private IApplicationService iApplicationService;
    @Autowired
    private IResponseService iResponseService;

    @GetMapping("/list/by_candidate/{idCandidateCrypt}")
    public ResponseEntity<?> listApplicationByCandidate(@PathVariable String idCandidateCrypt) {
        return ResponseEntity.status(HttpStatus.OK).body(iApplicationService.listByIdCandidate(idCandidateCrypt));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveApplication(@Valid @RequestBody CreateApplicationDTO createApplicationDTO) {
        iApplicationService.saveApplication(createApplicationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                iResponseService.generate_response(true, "Aplicación a vacante realizada de manera correcta")
        );
    }
}
