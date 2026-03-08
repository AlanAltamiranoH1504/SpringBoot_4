package com.example.springboot_4_initial.services.interfaces;

import com.example.springboot_4_initial.dto.ShowEntityDTO;
import com.example.springboot_4_initial.dto.auth.CreateCandidateDTO;
import com.example.springboot_4_initial.dto.candidate.UpdateCandidateDTO;
import com.example.springboot_4_initial.models.Candidate;
import com.example.springboot_4_initial.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ICandidateService {
    public List<Candidate> list_candidate(boolean status);
    public Candidate save_candidate(Candidate candidate);
    public Candidate update_candidate(UpdateCandidateDTO updateCandidateDTO);
    public Candidate get_candidate(Long id_candidate);
    public Candidate show_candidate(ShowEntityDTO showEntityDTO);
    public boolean destroy_candidate(Long id_candidate);
    public void delete_candidate(Long id_candidate);
    public void update_img_profile(MultipartFile img_profile, String id_candidate_crypt) throws IOException;
    public Candidate confirm_account(String token_confirm_account, String randome_number);
}
