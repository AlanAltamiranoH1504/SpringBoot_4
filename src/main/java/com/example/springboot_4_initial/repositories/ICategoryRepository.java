package com.example.springboot_4_initial.repositories;

import com.example.springboot_4_initial.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

//public interface ICategoryRepository extends CrudRepository<Category, Long> {
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE c.name =:name")
    public abstract Category name_in_use(@Param("name") String name);

    @Query("SELECT count (c) FROM Category c")
    public abstract int count_categories();

    @Modifying
    @Transactional
    @Query("UPDATE Category c SET c.status = false")
    public abstract void delete_all_soft();
}
