package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.dto.ShowEntityDTO;
import com.example.springboot_4_initial.dto.auth.CreateCandidateDTO;
import com.example.springboot_4_initial.exceptions.NotFoundEntity;
import com.example.springboot_4_initial.exceptions.auth.NotCofirmAccountException;
import com.example.springboot_4_initial.exceptions.vancacies.NotFoundEntityException;
import com.example.springboot_4_initial.models.Candidate;
import com.example.springboot_4_initial.models.User;
import com.example.springboot_4_initial.repositories.ICandidateRepository;
import com.example.springboot_4_initial.services.interfaces.ICandidateService;
import com.example.springboot_4_initial.services.interfaces.ICloudinaryService;
import com.example.springboot_4_initial.services.interfaces.ICryptoService;
import com.example.springboot_4_initial.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService {
    @Autowired
    private ICandidateRepository iCandidateRepository;
    @Autowired
    private ICryptoService iCryptoService;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private ICloudinaryService iCloudinaryService;


    @Override
    public List<Candidate> list_candidate(boolean status) {
        return List.of();
    }

    @Transactional
    @Override
    public Candidate save_candidate(Candidate candidate) {
        return iCandidateRepository.save(candidate);
    }

    // * Metodo para administradores y reclutadores
    @Override
    public Candidate get_candidate(Long id_candidate) {
        Optional<Candidate> candidate_to_show = iCandidateRepository.findById(id_candidate);
        if (candidate_to_show.isPresent()) {
            return candidate_to_show.get();
        }
        throw new NotFoundEntity("El candidato con id " + id_candidate + " no se encuentra registrado en la db");
    }

    // * Metodos para usuarios candidate
    @Override
    public Candidate show_candidate(ShowEntityDTO showEntityDTO) {
        Long id_user_decrypt = iCryptoService.decrypt(showEntityDTO.getId_entity_crypt());
        User user_canidadate = iUserService.get_user(id_user_decrypt);
        if (user_canidadate == null) {
            throw new NotFoundEntityException("El usuario candidato con id " + id_user_decrypt + " no existe en la base de datos");
        }
        return user_canidadate.getCandidate();
    }

    @Override
    public boolean destroy_candidate(Long id_candidate) {
        Candidate candidate_to_destroy = this.get_candidate(id_candidate);
        User user_candidate = iUserService.get_user(candidate_to_destroy.getUser().getId_user());
        iUserService.destroy_user(user_candidate.getId_user());
        return true;
    }

    @Override
    public void delete_candidate(Long id_candidate) {

    }

    @Override
    public void update_img_profile(MultipartFile img_profile, String id_candidate_crypt) throws IOException {
        Long id_candidate = iCryptoService.decrypt(id_candidate_crypt);
        ShowEntityDTO showEntityDTO = new ShowEntityDTO();
        showEntityDTO.setId_entity_crypt(id_candidate_crypt);
        Candidate candidate = this.show_candidate(showEntityDTO);

        if (candidate.getImg_profile() == null) { // * Not image candidate
            Map response_cloudinary = iCloudinaryService.upload(img_profile);
            candidate.setImg_profile(response_cloudinary.get("url").toString());
            candidate.setPublic_id_img(response_cloudinary.get("public_id").toString());
            iCandidateRepository.save(candidate);
        } else {
            // * Delete old_img
            boolean result_delete = iCloudinaryService.delete_image(candidate.getPublic_id_img());
            if (!result_delete) {
                throw new IOException("Ocurrio un error en la eliminacion de la img del candidato");
            }
            // * Save new img
            Map response_cloudinary = iCloudinaryService.upload(img_profile);
            candidate.setImg_profile(response_cloudinary.get("url").toString());
            candidate.setPublic_id_img(response_cloudinary.get("public_id").toString());
            iCandidateRepository.save(candidate);
        }
    }

    @Override
    public Candidate confirm_account(String token_confirm_account, String randome_number) {
        Candidate candidate = iCandidateRepository.get_candidate_by_token_confirm_account(token_confirm_account);
        if (candidate == null) {
            throw new NotCofirmAccountException("No existe un usuario pendiente de confirmar con el token " + token_confirm_account);
        }
        if (candidate.getRandome_number().equals(randome_number)) {
            candidate.setRandome_number(null);
            candidate.setToken_confirm_account(null);
            iCandidateRepository.save(candidate);
            return candidate;
        }
        throw new NotCofirmAccountException("No existe un usuario pendiente de confirmar con los numeros " + randome_number);
    }
}
