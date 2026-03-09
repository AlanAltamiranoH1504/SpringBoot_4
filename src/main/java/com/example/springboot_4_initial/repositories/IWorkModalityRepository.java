package com.example.springboot_4_initial.repositories;

import com.example.springboot_4_initial.models.WorkModality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWorkModalityRepository extends JpaRepository<WorkModality, Long> {
}
