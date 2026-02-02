package com.example.springboot_4_initial.services.interfaces;

import com.example.springboot_4_initial.models.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryService {
    public abstract List<Category> list_categories();
    public abstract Category get_category(Long id);
    public abstract Category save_category(Category category);
    public abstract boolean delete_category(Long id);
}
