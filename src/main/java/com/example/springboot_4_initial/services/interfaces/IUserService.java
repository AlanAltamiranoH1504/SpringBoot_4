package com.example.springboot_4_initial.services.interfaces;

import com.example.springboot_4_initial.dto.user.UpdateUserDTO;
import com.example.springboot_4_initial.models.User;

import java.util.List;

public interface IUserService {
    public abstract List<User> list_users(boolean status);
    public abstract User get_user(Long id);
    public abstract User save_user(User user);
    public abstract User update_user(Long id, List<Long> ids_profiles, UpdateUserDTO updateUserDTO);
    public abstract boolean delete_user(Long id);
    public abstract boolean add_profile(Long id_user, List<Long> id_profiles);
    public abstract boolean remove_profiles(Long id_user, List<Long> ids_profile);
    public abstract boolean update_img_profile(Long id_user, String url_img);
}
