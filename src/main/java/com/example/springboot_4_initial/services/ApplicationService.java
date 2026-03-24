package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.dto.application.CreateApplicationDTO;
import com.example.springboot_4_initial.exceptions.CreatedEntityException;
import com.example.springboot_4_initial.exceptions.ListEmptyException;
import com.example.springboot_4_initial.exceptions.NotFoundEntity;
import com.example.springboot_4_initial.exceptions.application.ApplicationExistsException;
import com.example.springboot_4_initial.exceptions.vancacies.NotFoundEntityException;
import com.example.springboot_4_initial.models.Application;
import com.example.springboot_4_initial.models.Candidate;
import com.example.springboot_4_initial.models.User;
import com.example.springboot_4_initial.models.Vacancy;
import com.example.springboot_4_initial.models.enums.ApplicationStatus;
import com.example.springboot_4_initial.repositories.IApplicationRepository;
import com.example.springboot_4_initial.repositories.ICandidateRepository;
import com.example.springboot_4_initial.repositories.IUserRepository;
import com.example.springboot_4_initial.repositories.IVacancyRepository;
import com.example.springboot_4_initial.services.interfaces.IApplicationService;
import com.example.springboot_4_initial.services.interfaces.ICryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService implements IApplicationService {
    @Autowired
    private IApplicationRepository iApplicationRepository;
    @Autowired
    private IVacancyRepository iVacancyRepository;
    @Autowired
    private ICandidateRepository iCandidateRepository;
    @Autowired
    private ICryptoService iCryptoService;
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<Application> findAllByRecruiter(Long idRecruiter) {
        return List.of();
    }

    @Override
    public List<Application> listByIdCandidate(String idCandidateCrypt) {
        Optional<User> user = iUserRepository.findById(iCryptoService.decrypt(idCandidateCrypt));
        if (!user.isPresent()) {
            throw new NotFoundEntity("El usuario con el id no se encuentra registrado en la db");
        }

        List<Application> applicationList = iApplicationRepository.applicationByIdCandidate(user.get().getCandidate().getId_candidate());
        if (applicationList.isEmpty()) {
            throw new ListEmptyException("El candidato no se ha postulado a ninguna vacante");
        }
        return applicationList;
    }

    @Override
    public List<Application> listByIdRecruiter(Long idRecruiter) {
        return List.of();
    }

    @Override
    public Application findById(Long idApplication) {
        return null;
    }

    @Override
    public Application saveApplication(CreateApplicationDTO createApplicationDTO) {
        this.existsVacancy(createApplicationDTO.getIdVacancy());

        Optional<Application> isExistsApplication = iApplicationRepository.isExistsApplication(createApplicationDTO.getIdCandidate(), createApplicationDTO.getIdVacancy());
        if (isExistsApplication.isPresent()) {
            throw new ApplicationExistsException("El usuario ya se encontraba postulado a la vacante. Puede revisar el estado de la misma");
        }
        Application applicationToSave = new Application(
                LocalDateTime.now(),
                LocalDateTime.now(),
                "",
                createApplicationDTO.getComments_candidate(),
                null,
                ApplicationStatus.RECEIVED,
                iVacancyRepository.getReferenceById(createApplicationDTO.getIdVacancy()),
                iCandidateRepository.getReferenceById(createApplicationDTO.getIdCandidate())
        );
        iApplicationRepository.save(applicationToSave);
        if (applicationToSave.getId_application() == null) {
            throw new CreatedEntityException("Ocurrio un error en la aplicación de la vacante");
        }
        return applicationToSave;
    }

    @Override
    public Application updateApplication() {
        return null;
    }

    @Override
    public void deleteApplication(Long idApplication) {

    }

    @Override
    public void destroyApplication(Long idApplication) {

    }

    @Override
    public void existsVacancy(Long idVacancy) {
        Optional<Vacancy> vacancy = iVacancyRepository.findById(idVacancy);
        if (!vacancy.isPresent()) {
            throw new NotFoundEntityException("La vacante no esta registrada o fue deshabilitada");
        }
    }
}
