package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.dto.CreateCategoriesDTO;
import com.example.springboot_4_initial.dto.CreateCategoryDTO;
import com.example.springboot_4_initial.dto.ListCategoriesByIdDTO;
import com.example.springboot_4_initial.dto.UpdateCategoryDTO;
import com.example.springboot_4_initial.models.Category;
import com.example.springboot_4_initial.services.interfaces.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
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

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody UpdateCategoryDTO updateCategoryDTO, @PathVariable Long id, BindingResult bindingResult) {
        Map<String, Object> json = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> {
                json.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
        Category category = new Category(id, updateCategoryDTO.getName(), updateCategoryDTO.getDescription(), updateCategoryDTO.isStatus());
        iCategoryService.save_category(category);
        json.put("status", true);
        json.put("message", "Categoria actualizada");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        iCategoryService.delete_category(id);
        json.put("status", true);
        json.put("message", "La categoria fue eliminada correctamente");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @GetMapping("/count_categories")
    public ResponseEntity<?> count_categories() {
        Map<String, Object> json = new HashMap<>();
        int total_categories = iCategoryService.count_category();
        json.put("status", true);
        json.put("total_categories", total_categories);

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @DeleteMapping("/delete_all")
    public ResponseEntity<?> delete_all() {
        Map<String, Object> json = new HashMap<>();
        iCategoryService.delete_all_soft();

        json.put("status", true);
        json.put("message", "Categorias deshabilitadas");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<?> exists_category(@PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        boolean result_exists_category = iCategoryService.exists_category(id);
        if (result_exists_category) {
            json.put("exists", result_exists_category);
        }else {
            json.put("exists", result_exists_category);
        }
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @GetMapping("/list_by_ids")
    public ResponseEntity<?> list_categories_by_id(@Valid @RequestBody ListCategoriesByIdDTO listCategoriesByIdDTO, BindingResult bindingResult) {
        Map<String, Object> json = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> {
                json.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
        return ResponseEntity.status(HttpStatus.OK).body(iCategoryService.find_all_by_id(listCategoriesByIdDTO.getIds()));
    }

    @PostMapping("/save_categories")
    public ResponseEntity<?> save_categories(@Valid @RequestBody CreateCategoriesDTO createCategoriesDTO, BindingResult bindingResult) {
        Map<String, Object> json = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> {
                json.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
        json.put("status", true);
        json.put("message", "Array de categorias guardado correctamente");

        List<Category> categories = new ArrayList<>();
        for (var cate: createCategoriesDTO.getCategories()) {
            categories.add(new Category(cate.getName(), cate.getDescription(), true));
        }

        iCategoryService.create_categories(categories);
        return ResponseEntity.status(HttpStatus.CREATED).body(json);

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
