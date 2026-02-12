package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.exceptions.CreatedEntityException;
import com.example.springboot_4_initial.exceptions.ListEmptyException;
import com.example.springboot_4_initial.exceptions.vancacies.NotFoundEntityException;
import com.example.springboot_4_initial.models.Profile;
import com.example.springboot_4_initial.repositories.IProfileRepository;
import com.example.springboot_4_initial.services.interfaces.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService implements IProfileService {
    @Autowired
    private IProfileRepository iProfileRepository;

    @Override
    public List<Profile> list_profiles(boolean status) {
        List<Profile> list_profiles = iProfileRepository.list_profiles(status);
        if (list_profiles.isEmpty()) {
            throw new ListEmptyException("La lista de perfiles se encuentra vacia");
        }
        return list_profiles;
    }

    @Override
    public Profile get_profile(Long id) {
        Optional<Profile> profile_to_show = iProfileRepository.findById(id);
        if (profile_to_show.isEmpty()) {
            throw new NotFoundEntityException("El perfil con id " + id + " no se encuentra registrado dentro de la db");
        }
        return profile_to_show.get();
    }

    @Override
    public Profile save_profile(Profile profile) {
        Profile profile_to_save = this.iProfileRepository.save(profile);
        if (profile_to_save.getId() == null) {
            throw new CreatedEntityException("Ocurrio un error en la creacion del perfil dentro de la db");
        }
        return profile_to_save;
    }

    @Override
    public boolean delete_profile(Long id) {
        Profile profile_to_delete = this.get_profile(id);
        profile_to_delete.setStatus(false);
        iProfileRepository.save(profile_to_delete);
        return true;
    }

    @Override
    public List<Profile> get_profiles_by_id(List<Long> ids) {
        List<Profile> profiles_list = iProfileRepository.findAllById(ids);
        if (profiles_list.isEmpty()) {
            throw new ListEmptyException("La lista de perfiles a agregar se encuentra vacia, ningun perfil es valido");
        }
        return profiles_list;
    }
}
