package com.example.springboot_4_initial.services.interfaces;

import com.example.springboot_4_initial.dto.candidate.CreateCandidateDTO;
import com.example.springboot_4_initial.models.Candidate;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ICandidateService {
    public abstract List<Candidate> list_candidates(boolean status);

    public abstract Candidate get_candidate(Long id_candidate);

    public abstract Candidate save_candidate(CreateCandidateDTO candidate);

    public abstract Candidate update_candidate(Candidate candidate);

    public abstract boolean delete_candidate(Long id_candidate);

    public abstract boolean destroy_candidate(Long id_candidate);
}
