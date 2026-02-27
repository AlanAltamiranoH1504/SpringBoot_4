package com.example.springboot_4_initial.repositories;

import com.example.springboot_4_initial.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICandidateRepository extends JpaRepository<Candidate, Long> {
}
