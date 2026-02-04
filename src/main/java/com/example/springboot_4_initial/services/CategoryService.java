package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.dto.CreateCategoryDTO;
import com.example.springboot_4_initial.exceptions.categories.CreatedCategory;
import com.example.springboot_4_initial.exceptions.categories.NameCategoryError;
import com.example.springboot_4_initial.exceptions.categories.NotFoundCategories;
import com.example.springboot_4_initial.exceptions.categories.NotFoundCategory;
import com.example.springboot_4_initial.models.Category;
import com.example.springboot_4_initial.repositories.ICategoryRepository;
import com.example.springboot_4_initial.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> list_categories() {
        List<Category> list_categories = (List<Category>) iCategoryRepository.findAll();
        if (list_categories.isEmpty()) {
            throw new NotFoundCategories("No existen categorias registradas en la base de datos");
        }
        return list_categories;
    }

    @Override
    public Category get_category(Long id) {
        Optional<Category> category_to_show = iCategoryRepository.findById(id);
        if (category_to_show.isEmpty()) {
            throw new NotFoundCategory("La categoria no se encuentra registrada");
        }
        return category_to_show.get();
    }

    @Override
    public Category save_category(Category category) {
        Category name_in_use = iCategoryRepository.name_in_use(category.getName());
        if (name_in_use != null && category.getId() != name_in_use.getId()) {
            throw new NameCategoryError("El nombre de la categoria ya se encuentra en uso");
        }

        Category category_to_save = iCategoryRepository.save(category);
        if (category_to_save.getId() != null) {
            return category_to_save;
        }
        throw new CreatedCategory("Ocurrio un error en la creacion de la categoria dentro de la base datos");
    }

    @Override
    public boolean delete_category(Long id) {
        Category category_to_delete = this.get_category(id);
        category_to_delete.setStatus(false);
        iCategoryRepository.save(category_to_delete);
        return true;
    }

    @Override
    public int count_category() {
        return iCategoryRepository.count_categories();
    }

    @Override
    public void delete_all_soft() {
        iCategoryRepository.delete_all_soft();;
    }

    @Override
    public boolean exists_category(Long id) {
        return iCategoryRepository.existsById(id);
    }

    @Override
    public List<Category> find_all_by_id(List<Long> ids) {
        List<Category> list_category_by_id = (List<Category>) iCategoryRepository.findAllById(ids);
        if (list_category_by_id.isEmpty()) {
            throw new NotFoundCategories("No existen esas categorias regsitradas en la base de datos");
        }
        return list_category_by_id;
    }

    @Override
    public boolean create_categories(List<Category> categories) {
        iCategoryRepository.saveAll(categories);
        return true;
    }


}
