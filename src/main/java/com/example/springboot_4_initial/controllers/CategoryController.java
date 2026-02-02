package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.dto.CreateCategoryDTO;
import com.example.springboot_4_initial.models.Category;
import com.example.springboot_4_initial.services.interfaces.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<?> list_category() {
        return ResponseEntity.status(HttpStatus.OK).body(iCategoryService.list_categories());
    }

    @PostMapping("")
    public ResponseEntity<?> save_category(@Valid @RequestBody CreateCategoryDTO createCategoryDTO, BindingResult bindingResult) {
        Map<String, Object> json = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> {
                json.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
        Category category_to_save = new Category(createCategoryDTO.getName(), createCategoryDTO.getDescription(), true);
        iCategoryService.save_category(category_to_save);
        json.put("status", true);
        json.put("message", "Categoria guardada");
        return ResponseEntity.status(HttpStatus.CREATED).body(json);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> search(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(iCategoryService.get_category(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        iCategoryService.delete_category(id);
        json.put("status", true);
        json.put("message", "La categoria fue eliminada correctamente");
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
