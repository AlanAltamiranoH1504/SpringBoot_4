package com.example.springboot_4_initial.repositories;

import com.example.springboot_4_initial.models.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVacancyRepository extends JpaRepository<Vacancy, Long> {

    @Query("SELECT v FROM Vacancy v WHERE v.status = :status")
    public abstract List<Vacancy> list_vacancies(@Param("status") boolean status);
}
