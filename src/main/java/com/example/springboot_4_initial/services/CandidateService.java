package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.dto.candidate.CreateCandidateDTO;
import com.example.springboot_4_initial.exceptions.CreatedEntityException;
import com.example.springboot_4_initial.exceptions.vancacies.NotFoundEntityException;
import com.example.springboot_4_initial.models.Candidate;
import com.example.springboot_4_initial.models.Profile;
import com.example.springboot_4_initial.repositories.ICandidateRepository;
import com.example.springboot_4_initial.repositories.IProfileRepository;
import com.example.springboot_4_initial.services.interfaces.ICandidateService;
import com.example.springboot_4_initial.services.interfaces.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CandidateService implements ICandidateService {
    @Autowired
    private MailService mailService;
    @Autowired
    private ICandidateRepository iCandidateRepository;
    @Autowired
    private IImageService iImageService;
    @Autowired
    private IProfileRepository iProfileRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Candidate> list_candidates(boolean status) {
        return List.of();
    }

    @Override
    public Candidate get_candidate(Long id_candidate) {
        return null;
    }

    @Override
    public Candidate get_candidate_by_email(String email) {
        Candidate candidate = iCandidateRepository.get_candidate_by_email(email);
        if (candidate == null) {
            throw new NotFoundEntityException("El candidato con email " + email + " no existe");
        }
        return candidate;
    }

    @Override
    public Candidate save_candidate(CreateCandidateDTO candidate) {
        Profile profile_candidate = iProfileRepository.get_profile_by_name("ROLE_CANDIDATO");
        String uuid = UUID.randomUUID().toString();
        int randome_number = (int) (Math.random() * 90000) + 10000;

        Candidate candiate_to_save = new Candidate(
                candidate.getName_candidate(),
                candidate.getLastname_candidate(),
                candidate.getEmail(),
                passwordEncoder.encode(candidate.getPassword()),
                null,
                candidate.getCellphone(),
                candidate.getAddress(),
                uuid,
                null,
                String.valueOf(randome_number),
                1,
                profile_candidate
        );
        iCandidateRepository.save(candiate_to_save);
        if (candiate_to_save.getId_candidate() != null) {
            mailService.send_mail_confirm_account_candidate(
                    candidate.getEmail(),
                    "Confirma tu cuenta y comienza a postularte",
                    candidate.getName_candidate(),
                    uuid,
                    randome_number);
            return candiate_to_save;
        }
        throw new CreatedEntityException("Ocurrio un error en la creación del candidato");
    }

    @Override
    public Candidate update_candidate(Candidate candidate) {
        iCandidateRepository.save(candidate);
        return candidate;
    }

    @Override
    public boolean delete_candidate(Long id_candidate) {
        return false;
    }

    @Override
    public boolean destroy_candidate(Long id_candidate) {
        return false;
    }
}
