package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.dto.ListEntityDTO;
import com.example.springboot_4_initial.services.interfaces.IAdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService iAdminService;

    @GetMapping("/list/admins")
    public ResponseEntity<?> list_admins(@Valid @RequestBody ListEntityDTO listEntityDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(iAdminService.list_admin(listEntityDTO.getStatus()));
    }

    @GetMapping("/list/recruiter")
    public ResponseEntity<?> list_recruiter(@Valid @RequestBody ListEntityDTO listEntityDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(iAdminService.list_recruiters(listEntityDTO.getStatus()));
    }

    @GetMapping("/list/candidates")
    public ResponseEntity<?> list_candidates(@Valid @RequestBody ListEntityDTO listEntityDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(iAdminService.list_candidates(listEntityDTO.getStatus()));
    }
}
