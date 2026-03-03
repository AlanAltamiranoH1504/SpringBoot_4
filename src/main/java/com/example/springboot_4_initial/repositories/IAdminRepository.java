package com.example.springboot_4_initial.repositories;

import com.example.springboot_4_initial.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAdminRepository extends JpaRepository<Admin, Long> {
    @Query("SELECT a FROM Admin a WHERE a.status = :status")
    public abstract List<Admin> admins_by_status(@Param("status") boolean status);
}
