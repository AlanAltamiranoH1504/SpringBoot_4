package com.example.springboot_4_initial.repositories;

import com.example.springboot_4_initial.models.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ICategoryRepository extends CrudRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE c.name =:name")
    public abstract Category name_in_use(@Param("name") String name);
}
