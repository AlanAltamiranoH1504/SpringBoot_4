package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.dto.auth.CreateRecluiterDTO;
import com.example.springboot_4_initial.exceptions.CreatedEntityException;
import com.example.springboot_4_initial.exceptions.auth.NotCofirmAccountException;
import com.example.springboot_4_initial.exceptions.auth.PasswordIncorrectException;
import com.example.springboot_4_initial.exceptions.vancacies.NotFoundEntityException;
import com.example.springboot_4_initial.models.Profile;
import com.example.springboot_4_initial.models.Recruiter;
import com.example.springboot_4_initial.models.User;
import com.example.springboot_4_initial.security.JwtService;
import com.example.springboot_4_initial.services.interfaces.IAuthService;
import com.example.springboot_4_initial.services.interfaces.IProfileService;
import com.example.springboot_4_initial.services.interfaces.IRecruiterService;
import com.example.springboot_4_initial.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MailService mailService;
    @Autowired
    private IProfileService iProfileService;
    @Autowired
    private IRecruiterService iRecruiterService;


    @Transactional
    @Override
    public Recruiter save_recruiter(CreateRecluiterDTO createRecluiterDTO) {
        // * Save tbl_user
        List<Profile> profiles_recluiter = this.get_profiles(createRecluiterDTO.getRoles());
        String uuid = UUID.randomUUID().toString();
        int randome_number = (int) (Math.random() * 10000);
        User user = new User(
                createRecluiterDTO.getEmail(),
                passwordEncoder.encode(createRecluiterDTO.getPassword()),
                true,
                profiles_recluiter);
        iUserService.save_user(user);
        if (user.getId_user() == null) {
            throw new CreatedEntityException("Ocurrio un error en la creacion del perfil de reclutador");
        }
        Recruiter recruiter = new Recruiter(
                createRecluiterDTO.getName(),
                createRecluiterDTO.getSurnames(),
                createRecluiterDTO.getUsername(),
                null,
                uuid,
                null,
                String.valueOf(randome_number),
                true,
                user
        );
        iRecruiterService.save_recruiter(recruiter);
        mailService.send_mail_confirm_account_reclutador(user.getEmail(), "Confirma tu cuenta", recruiter.getName(), uuid, randome_number);
        return recruiter;
    }

    @Override
    public List<Profile> get_profiles(List<Long> id_profiles) {
        List<Profile> valid_profiles = new ArrayList<>();
        for (var p : id_profiles) {
            Profile profile_to_get = iProfileService.get_profile(p);
            if (profile_to_get.getProfile().equals("ROLE_RECLUTADOR")) {
                valid_profiles.add(profile_to_get);
            }
        }
        return valid_profiles;
    }

    @Override
    public String login_user(String email, String password) {
        // * Search tbl_user
        Optional<User> user_by_email = iUserService.get_user_by_email(email);
        if (user_by_email.isEmpty()) {
            throw new NotFoundEntityException("El usuario a buscar no esta registrado");
        }

        System.out.println(user_by_email.get().getRecruiter().getId_recruiter());
        // * Search table_
//        if (user_by_email.get().getRandome_number() != null && user_by_email.get().getToken_confirm_account() != null) {
//            User user = user_by_email.get();
//            iUserService.save_user(user);
//            throw new NotCofirmAccountException("El usuario no ha confirmado su cuenta de manera correcta. Verifica tu correo para confirmación");
//        }
        if (passwordEncoder.matches(password, user_by_email.get().getPassword())) {
            return jwtService.generateTokenJWT(user_by_email.get());
        }
        throw new PasswordIncorrectException("El password es incorrecto");
    }
}
