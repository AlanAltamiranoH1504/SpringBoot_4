package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.dto.profile.CreateProfileDTO;
import com.example.springboot_4_initial.dto.profile.ListProfileDTO;
import com.example.springboot_4_initial.models.Profile;
import com.example.springboot_4_initial.services.interfaces.IProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    @Autowired
    private IProfileService iProfileService;

    @GetMapping("/list")
    public ResponseEntity<?> list_profiles(@Valid @RequestBody ListProfileDTO listProfileDTO) {
        List<Profile> list_profiles = iProfileService.list_profiles(listProfileDTO.getStatus());
        return ResponseEntity.status(HttpStatus.OK).body(list_profiles);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save_profile(@Valid @RequestBody CreateProfileDTO createProfileDTO) {
        Map<String, Object> json = new HashMap<>();
        this.iProfileService.save_profile(new Profile(createProfileDTO.getProfile(), true));
        json.put("status", true);
        json.put("message", "Perfil creado correctamente");

        return ResponseEntity.status(HttpStatus.CREATED).body(json);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find_profile(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(iProfileService.get_profile(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete_profile(@PathVariable Long id) {
        iProfileService.delete_profile(id);
        Map<String, Object> json = new HashMap<>();
        json.put("status", true);
        json.put("message", "Perfil deshabilitado");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }
}
