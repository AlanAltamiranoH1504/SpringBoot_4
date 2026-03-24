package com.example.springboot_4_initial.repositories;

import com.example.springboot_4_initial.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IApplicationRepository extends JpaRepository<Application, Long> {
    @Query("SELECT a FROM Application a WHERE a.candidate.id_candidate = :idCandidate AND a.vacancy.id_vacancy = :idVacancy")
    Optional<Application> isExistsApplication(@Param("idCandidate") Long idCandidate, @Param("idVacancy") Long idVacancy);

    @Query("SELECT a FROM Application a WHERE a.candidate.id_candidate = :idCandidate")
    List<Application> applicationByIdCandidate(@Param("idCandidate") Long idCandidate);
}
