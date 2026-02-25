package com.example.springboot_4_initial.repositories;

import com.example.springboot_4_initial.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICandidateRepository extends JpaRepository<Candidate, Long> {
    @Query("SELECT c FROM Candidate c WHERE c.token_confirm_account = :token")
    public abstract Candidate get_candidate_to_confirm(@Param("token") String token);

    @Query("SELECT c FROM Candidate c WHERE c.email = :email")
    public abstract Candidate get_candidate_by_email(@Param("email") String email);
}
