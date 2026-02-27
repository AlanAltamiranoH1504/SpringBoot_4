package com.example.springboot_4_initial.services.interfaces;

import com.example.springboot_4_initial.dto.auth.CreateRecluiterDTO;
import com.example.springboot_4_initial.models.Profile;
import com.example.springboot_4_initial.models.Recruiter;

import java.util.List;

public interface IAuthService {
    public abstract Recruiter save_recruiter(CreateRecluiterDTO createRecluiterDTO);
    public abstract List<Profile> get_profiles(List<Long> id_profiles);
    public abstract String login_user(String email, String password);
}
