package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.dto.CreateCategoryDTO;
import com.example.springboot_4_initial.models.Category;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @GetMapping("")
    public ResponseEntity<?> list_category() {
        List<Category> categoryList = new ArrayList<>();
        Category category1 = new Category(1L, "Desarrollo backend", "Desarrolladores backend", true);
        Category category2 = new Category(1L, "Desarrollo frontend", "Desarrolladores frontend", true);
        Category category3 = new Category(1L, "Desarrollo fullstack", "Desarrolladores fullstack", true);
        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);
        return ResponseEntity.status(HttpStatus.OK).body(categoryList);
    }

    @PostMapping("")
    public ResponseEntity<?> save_category(@Valid @RequestBody CreateCategoryDTO createCategoryDTO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                Map<String, Object> errors = new HashMap<>();
                bindingResult.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
            Category categoryToSave = new Category(1L, createCategoryDTO.getNombre(), createCategoryDTO.getDescription(), true);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryToSave);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> search(@PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("status", true);
        json.put("id", id);
        json.put("message", "Ruta con parametro dinamico");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @GetMapping("/params")
    public ResponseEntity<?> params(
            @RequestParam(name = "param1", required = true) String param1,
            @RequestParam(name = "param2", required = true) String param2
    ) {
        Map<String, Object> json = new HashMap<>();
        json.put("status", true);
        json.put("param1", param1);
        json.put("param2", param2);

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }
}
