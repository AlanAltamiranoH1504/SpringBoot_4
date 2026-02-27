package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.exceptions.CreatedEntityException;
import com.example.springboot_4_initial.exceptions.vancacies.NotFoundEntityException;
import com.example.springboot_4_initial.models.Recruiter;
import com.example.springboot_4_initial.models.User;
import com.example.springboot_4_initial.repositories.IRecruiterRepository;
import com.example.springboot_4_initial.services.interfaces.IRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterService implements IRecruiterService {
    @Autowired
    private IRecruiterRepository iRecruiterRepository;

    @Override
    public List<Recruiter> list_recruiters() {
        return List.of();
    }

    @Override
    public Recruiter save_recruiter(Recruiter recruiter) {
        boolean result_username_in_use = this.username_in_use(recruiter.getUsername(), null, false);
        if (result_username_in_use) {
            throw new CreatedEntityException("El username del reclutador ya se encuentra en uso actualmente");
        }
        iRecruiterRepository.save(recruiter);
        return recruiter;
    }

    @Override
    public Recruiter get_recruiter(Long id_recruiter) {
        return null;
    }

    @Override
    public void delete_recruiter(Long id_recruiter) {

    }

    @Override
    public boolean username_in_use(String username, Long id_recruiter, boolean is_update) {
        if (!is_update) {
            Recruiter result_in_use = iRecruiterRepository.username_in_use(username);
            if (result_in_use != null) {
                return true;
            } else {
                return false;
            }
        } else {
            Recruiter result_with_id = iRecruiterRepository.username_in_use(username);
            if (result_with_id != null && result_with_id.getId_recruiter() != id_recruiter) {
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean confirm_account(String token_confirm_account, String randome_number) {
        Recruiter recruiter_by_token_confirm_account = iRecruiterRepository.get_recruiter_by_token_account(token_confirm_account);
        if (recruiter_by_token_confirm_account == null) {
            throw new NotFoundEntityException("No se encontro algun usuario con el token " + token_confirm_account);
        }
        if (!recruiter_by_token_confirm_account.getRandome_number().equals(randome_number)) {
            throw new NotFoundEntityException("Cadena de numeros no valida o corrupta para el reclutador");
        }

        recruiter_by_token_confirm_account.setRandome_number(null);
        recruiter_by_token_confirm_account.setToken_confirm_account(null);
        iRecruiterRepository.save(recruiter_by_token_confirm_account);
        return true;
    }
}
