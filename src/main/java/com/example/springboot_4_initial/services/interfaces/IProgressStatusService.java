package com.example.springboot_4_initial.services.interfaces;

import com.example.springboot_4_initial.dto.ListEntityDTO;
import com.example.springboot_4_initial.dto.progressStatus.CreateProgressStatusDTO;
import com.example.springboot_4_initial.dto.progressStatus.UpdateProgressStatusDTO;
import com.example.springboot_4_initial.models.ProgressStatus;

import java.util.List;

public interface IProgressStatusService {
    public abstract List<ProgressStatus> findAll(ListEntityDTO listEntityDTO);
    public abstract ProgressStatus save(CreateProgressStatusDTO createProgressStatusDTO);
    public abstract ProgressStatus update(UpdateProgressStatusDTO updateProgressStatusDTO, Long idProgressStatus);
    public abstract ProgressStatus findById(Long idProgressStatus);
    public abstract void delete(Long idProgressStatus);
    public abstract void destroy(Long idProgressStatus);
}
