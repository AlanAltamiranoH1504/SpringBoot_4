package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.dto.application.CreateApplicationDTO;
import com.example.springboot_4_initial.services.interfaces.IApplicationService;
import com.example.springboot_4_initial.services.interfaces.ICryptoService;
import com.example.springboot_4_initial.services.interfaces.IResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveApplication(
            @RequestPart("file") MultipartFile cv,
            @RequestPart("data") @Valid CreateApplicationDTO createApplicationDTO
    ) throws IOException {
        iApplicationService.saveApplication(createApplicationDTO, cv);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                iResponseService.generate_response(true, "Aplicación a vacante realizada de manera correcta")
        );
    }
}
