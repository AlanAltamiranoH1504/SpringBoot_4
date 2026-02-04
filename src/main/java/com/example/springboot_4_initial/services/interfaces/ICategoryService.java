package com.example.springboot_4_initial.services.interfaces;

import com.example.springboot_4_initial.dto.CreateCategoryDTO;
import com.example.springboot_4_initial.models.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryService {
    public abstract List<Category> list_categories();

    public abstract Category get_category(Long id);

    public abstract Category save_category(Category category);

    public abstract boolean delete_category(Long id);

    public abstract int count_category();

    public abstract void delete_all_soft();

    public abstract boolean exists_category(Long id);

    public abstract List<Category> find_all_by_id(List<Long> ids);

    public abstract boolean create_categories(List<Category> categories);
}
