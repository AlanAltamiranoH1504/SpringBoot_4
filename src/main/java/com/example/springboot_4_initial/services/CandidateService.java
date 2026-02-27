package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.dto.auth.CreateCandidateDTO;
import com.example.springboot_4_initial.models.Candidate;
import com.example.springboot_4_initial.repositories.ICandidateRepository;
import com.example.springboot_4_initial.services.interfaces.ICandidateService;
import com.example.springboot_4_initial.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CandidateService implements ICandidateService {
    @Autowired
    private ICandidateRepository iCandidateRepository;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private MailService mailService;

    @Override
    public List<Candidate> list_candidate(boolean status) {
        return List.of();
    }

    @Transactional
    @Override
    public Candidate save_candidate(Candidate candidate) {
        return iCandidateRepository.save(candidate);
    }

    @Override
    public Candidate get_candidate() {
        return null;
    }

    @Override
    public void delete_candidate(Long id_candidate) {

    }
}
