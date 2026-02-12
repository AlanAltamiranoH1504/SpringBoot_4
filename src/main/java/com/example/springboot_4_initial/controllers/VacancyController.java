package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.dto.vancacy.CreateVacancyDTO;
import com.example.springboot_4_initial.dto.vancacy.ListVacanciesDTO;
import com.example.springboot_4_initial.dto.vancacy.UpdateVacancyDTO;
import com.example.springboot_4_initial.models.Category;
import com.example.springboot_4_initial.models.Vacancy;
import com.example.springboot_4_initial.repositories.ICategoryRepository;
import com.example.springboot_4_initial.services.interfaces.ICategoryService;
import com.example.springboot_4_initial.services.interfaces.IImageService;
import com.example.springboot_4_initial.services.interfaces.IVacancyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {
    @Autowired
    private IVacancyService iVacancyService;
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IImageService iImageService;

    @GetMapping("/list")
    public ResponseEntity<?> list_vacancies(@Valid @RequestBody ListVacanciesDTO listVacanciesDTO, BindingResult bindingResult) {
        Map<String, Object> json = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> {
                json.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
        return ResponseEntity.status(HttpStatus.OK).body(iVacancyService.list_vacancies(listVacanciesDTO.getStatus()));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save_vacancy(@Valid @RequestBody CreateVacancyDTO createVacancyDTO, BindingResult bindingResult) {
        Map<String, Object> json = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> {
                json.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
//        Category category = iCategoryRepository.getReferenceById(createVacancyDTO.getCategory());
        Category category = iCategoryService.get_category(createVacancyDTO.getCategory());

        Vacancy vacancy_to_save = new Vacancy(createVacancyDTO.getName(), new Date(), createVacancyDTO.getDescription(), createVacancyDTO.getSalary(), true, null, category);
        Vacancy vacancy_created = iVacancyService.save_vacancy(vacancy_to_save);
        json.put("status", true);
        json.put("message", "Vacante agregada correctamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(json);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find_vacancy(@PathVariable Long id) {
        Vacancy vacancy_to_show = iVacancyService.get_vacancy(id);
        return ResponseEntity.status(HttpStatus.OK).body(vacancy_to_show);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update_vacancy(@Valid @RequestBody UpdateVacancyDTO updateVacancyDTO, @PathVariable Long id, BindingResult bindingResult) {
        Map<String, Object> json = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> {
                json.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
        Category category = iCategoryService.get_category(updateVacancyDTO.getCategory());
        Vacancy vacancy_to_update = iVacancyService.get_vacancy(id);
        vacancy_to_update.setName(updateVacancyDTO.getName());
        vacancy_to_update.setDescription(updateVacancyDTO.getDescription());
        vacancy_to_update.setSalary(updateVacancyDTO.getSalary());
        vacancy_to_update.setStatus(updateVacancyDTO.getStatus());
        vacancy_to_update.setCategory(category);
        iVacancyService.save_vacancy(vacancy_to_update);
        json.put("status", true);
        json.put("message", "Vacante actualizada");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete_vacancy(@PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        iVacancyService.delete_vacancy(id);
        json.put("status", true);
        json.put("message", "Vacante eliminada");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @PostMapping("/save_img_vacancy/{id}")
    public ResponseEntity<?> save_img_vacancy(@PathVariable Long id, @RequestParam("img_vacancy")MultipartFile multipartFile) throws IOException {
        Map<String, Object> json = new HashMap<>();
        String path_img = "C:/Imagenes_Proyectos/SpringBoot";
        this.find_vacancy(id);

        String result_save_img = iImageService.save_image(path_img, multipartFile);
        if (Objects.equals(result_save_img, "")) {
            json.put("status", false);
            json.put("message", "Ocurrio un error en el guardado de la imagen");
        }
        this.iVacancyService.update_img_vacancy(result_save_img, id);
        json.put("status", true);
        json.put("message", "Imagen de vacante actualizada");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }
}
