package com.example.springboot_4_initial.repositories;

import com.example.springboot_4_initial.models.ProgressStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProgressStatusRepository extends JpaRepository<ProgressStatus, Long> {
}
