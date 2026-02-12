package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.dto.user.AddProfilesDTO;
import com.example.springboot_4_initial.dto.user.CreateUserDTO;
import com.example.springboot_4_initial.dto.ListEntityDTO;
import com.example.springboot_4_initial.dto.user.RemoveProfileDTO;
import com.example.springboot_4_initial.dto.user.UpdateUserDTO;
import com.example.springboot_4_initial.models.Profile;
import com.example.springboot_4_initial.models.User;
import com.example.springboot_4_initial.services.interfaces.IProfileService;
import com.example.springboot_4_initial.services.interfaces.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IProfileService iProfileService;

    @PostMapping("/save")
    public ResponseEntity<?> save_user(@Valid @RequestBody CreateUserDTO createUserDTO) {
        Map<String, Object> json = new HashMap<>();
        List<Profile> profiles = iProfileService.get_profiles_by_id(createUserDTO.getProfiles());
        iUserService.save_user(new User(createUserDTO.getName(), createUserDTO.getSurnames(), createUserDTO.getEmail(), createUserDTO.getUsername(), createUserDTO.getPassword(), createUserDTO.getImg_profile(), true, new Date(), profiles));

        json.put("status", true);
        json.put("message", "Usuario creado correctamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(json);
    }

    @GetMapping("/list")
    public ResponseEntity<?> list_users(@Valid @RequestBody ListEntityDTO listEntityDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(iUserService.list_users(listEntityDTO.getStatus()));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find_user(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(iUserService.get_user(id));
    }

    @PutMapping("/add_profile/{id}")
    public ResponseEntity<?> add_profile_to_user(@Valid @RequestBody AddProfilesDTO addProfilesDTO, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();

        iUserService.add_profile(id, addProfilesDTO.getProfiles());
        json.put("status", true);
        json.put("message", "Perfiles agregados a usuario");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @DeleteMapping("/remove_profiles/{id}")
    public ResponseEntity<?> remove_profiles_to_user(@Valid @RequestBody RemoveProfileDTO removeProfileDTO, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        iUserService.remove_profiles(id, removeProfileDTO.getProfiles());

        json.put("status", true);
        json.put("message", "Perfiles eliminados al usuario");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @PutMapping("/update_user/{id}")
    public ResponseEntity<?> update_user(@Valid @RequestBody UpdateUserDTO updateUserDTO, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();

        iUserService.update_user(id, updateUserDTO.getProfiles(), updateUserDTO);
        json.put("status", true);
        json.put("message", "Usuario actualizado correctamente");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }
}
