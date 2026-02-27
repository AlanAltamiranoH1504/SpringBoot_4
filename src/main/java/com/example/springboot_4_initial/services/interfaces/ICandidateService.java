package com.example.springboot_4_initial.services.interfaces;

import com.example.springboot_4_initial.dto.auth.CreateCandidateDTO;
import com.example.springboot_4_initial.models.Candidate;

import java.util.List;

public interface ICandidateService {
    public List<Candidate> list_candidate(boolean status);
    public Candidate save_candidate(Candidate candidate);
    public Candidate get_candidate();
    public void delete_candidate(Long id_candidate);
    public Candidate confirm_account(String token_confirm_account, String randome_number);
}
