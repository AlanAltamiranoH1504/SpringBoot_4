package com.example.springboot_4_initial.services.interfaces;

import com.example.springboot_4_initial.models.Profile;

import java.util.List;

public interface IProfileService {
    public abstract List<Profile> list_profiles(boolean status);
    public abstract Profile get_profile(Long id);
    public abstract Profile save_profile(Profile profile);
    public abstract boolean delete_profile(Long id);
    public abstract List<Profile> get_profiles_by_id(List<Long> ids);
}
