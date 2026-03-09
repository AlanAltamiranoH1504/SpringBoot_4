package com.example.springboot_4_initial.services.interfaces;

import com.example.springboot_4_initial.models.ProgressStatus;

import java.util.List;

public interface IProgressStatusService {
    public abstract List<ProgressStatus> findAll();
    public abstract ProgressStatus save();
    public abstract ProgressStatus findById(Long idProgressStatus);
}
