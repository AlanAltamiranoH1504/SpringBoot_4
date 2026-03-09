package com.example.springboot_4_initial.repositories;

import com.example.springboot_4_initial.models.IndustrialSector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIndustrialSectorRepository extends JpaRepository<IndustrialSector, Long> {
}
