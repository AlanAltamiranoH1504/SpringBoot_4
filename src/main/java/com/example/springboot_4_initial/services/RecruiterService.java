package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.exceptions.CreatedEntityException;
import com.example.springboot_4_initial.models.Recruiter;
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
}
