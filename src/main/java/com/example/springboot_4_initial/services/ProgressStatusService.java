package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.dto.ListEntityDTO;
import com.example.springboot_4_initial.dto.progressStatus.CreateProgressStatusDTO;
import com.example.springboot_4_initial.dto.progressStatus.UpdateProgressStatusDTO;
import com.example.springboot_4_initial.exceptions.CreatedEntityException;
import com.example.springboot_4_initial.exceptions.ListEmptyException;
import com.example.springboot_4_initial.exceptions.vancacies.NotFoundEntityException;
import com.example.springboot_4_initial.models.ProgressStatus;
import com.example.springboot_4_initial.repositories.IProgressStatusRepository;
import com.example.springboot_4_initial.services.interfaces.IProgressStatusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgressStatusService implements IProgressStatusService {
    @Autowired
    private IProgressStatusRepository iProgressStatusRepository;

    @Override
    public List<ProgressStatus> findAll(ListEntityDTO listEntityDTO) {
        List<ProgressStatus> progressStatusList = iProgressStatusRepository.listProgressStatus(listEntityDTO.getStatus());
        if (progressStatusList.isEmpty()) {
            throw new ListEmptyException("No existen registro de estados de progreso en la base de datos");
        }
        return progressStatusList;
    }

    @Override
    public ProgressStatus save(CreateProgressStatusDTO createProgressStatusDTO) {
        Optional<ProgressStatus> nameInUse = iProgressStatusRepository.findByName(createProgressStatusDTO.getName_progress_status());
        if (nameInUse.isPresent()) {
            throw new CreatedEntityException("El nombre del estado de progreso ya se encuentra registrado");
        }
        ProgressStatus progressStatusToSave = new ProgressStatus(createProgressStatusDTO.getName_progress_status(), createProgressStatusDTO.getDescription_progress_status(), true);
        iProgressStatusRepository.save(progressStatusToSave);
        return progressStatusToSave;
    }

    @Override
    public ProgressStatus update(UpdateProgressStatusDTO updateProgressStatusDTO, Long idProgressStatus) {
        ProgressStatus progressStatusToUpdate = this.findById(idProgressStatus);
        Optional<ProgressStatus> nameInUse = iProgressStatusRepository.findByName(updateProgressStatusDTO.getName_progress_status());
        if (nameInUse.isPresent() && nameInUse.get().getId_progress_status() != idProgressStatus) {
            throw new CreatedEntityException("El nombre del estado de progreso ya se encuentra registrado en la base de datos");
        }
        BeanUtils.copyProperties(updateProgressStatusDTO, progressStatusToUpdate);
        iProgressStatusRepository.save(progressStatusToUpdate);
        return progressStatusToUpdate;
    }

    @Override
    public ProgressStatus findById(Long idProgressStatus) {
        Optional<ProgressStatus> progressStatusToShow = iProgressStatusRepository.findById(idProgressStatus);
        if (progressStatusToShow.isPresent()) {
            return progressStatusToShow.get();
        }
        throw new NotFoundEntityException("No se encontro un estado de progreso con el id " + idProgressStatus);
    }

    @Override
    public void delete(Long idProgressStatus) {
        ProgressStatus progressStatusToDelete = this.findById(idProgressStatus);
        progressStatusToDelete.setStatus(false);
        iProgressStatusRepository.save(progressStatusToDelete);
    }

    @Override
    public void destroy(Long idProgressStatus) {
        ProgressStatus progressStatusToDelete = this.findById(idProgressStatus);
        iProgressStatusRepository.delete(progressStatusToDelete);
    }
}
