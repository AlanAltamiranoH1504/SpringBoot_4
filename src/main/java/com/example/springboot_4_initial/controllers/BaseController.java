package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.models.Vacancy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/base")
public class BaseController {

    @GetMapping("")
    public ResponseEntity<?> prueba() {
        Map<String, Object> json = new HashMap<>();
        json.put("status", true);
        json.put("message", "Controlador de prueba funcionando");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @GetMapping("/get_vacancy")
    public ResponseEntity<?> get_vacancy() {
        Map<String, Object> json = new HashMap<>();
        Vacancy new_vacancy = new Vacancy(1L, "Desarrollador Backend Jr Laravel", new Date(), "Desarrollador backend Jr con Laravel 12", 15000, true);
        json.put("status", true);
        json.put("vacancy", new_vacancy);
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @GetMapping("/list_vacancy")
    public ResponseEntity<?> list_vacancy() {
        List<Vacancy> list_vacancy = new ArrayList<>();
        Vacancy vacancy1 = new Vacancy(1L, "Desarrollador Laravel", new Date(), "Desarrollador backend Laravel", 17000, true);
        Vacancy vacancy2 = new Vacancy(2L, "Desarrollador SpringBoot", new Date(), "Desarrollador backend SpringBoot", 20000, true);
        Vacancy vacancy3 = new Vacancy(3L, "Desarrollador NestJs", new Date(), "Desarrollador backend NetsJs", 18500, true);
        list_vacancy.add(vacancy1);
        list_vacancy.add(vacancy2);
        list_vacancy.add(vacancy3);
        return ResponseEntity.status(HttpStatus.OK).body(list_vacancy);
    }


}
