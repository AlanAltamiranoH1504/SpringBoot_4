package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.exceptions.NotFoundVacancys;
import com.example.springboot_4_initial.models.Vacancy;
import com.example.springboot_4_initial.services.interfaces.IVacacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/base")
public class BaseController {
    @Autowired
    IVacacyService iVacacyService;

    @GetMapping("")
    public ResponseEntity<?> prueba() {
        Map<String, Object> json = new HashMap<>();
        json.put("status", true);
        json.put("message", "Controlador de prueba funcionando");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

//    @GetMapping("/get_vacancy")
    public ResponseEntity<?> get_vacancy() {
        Map<String, Object> json = new HashMap<>();
        Vacancy new_vacancy = new Vacancy(1L, "Desarrollador Backend Jr Laravel", new Date(), "Desarrollador backend Jr con Laravel 12", 15000, true);
        json.put("status", true);
        json.put("vacancy", new_vacancy);
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @GetMapping("/list_vacancy")
    public ResponseEntity<?> list_vacancy() {
        List<Vacancy> vacancy_list = iVacacyService.list_vacancys();

        if (vacancy_list.isEmpty()) {
            throw new NotFoundVacancys("La lista de vacantes esta vacia");
        }
        return ResponseEntity.status(HttpStatus.OK).body(iVacacyService.list_vacancys());
    }

    @GetMapping("get_vacancy/{id}")
    public ResponseEntity<?> get_vacancy(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(iVacacyService.get_vacancy(id));
    }
}
