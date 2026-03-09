package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.models.ProgressStatus;
import com.example.springboot_4_initial.services.interfaces.IProgressStatusService;

import java.util.List;

public class ProgressStatusService implements IProgressStatusService {
    @Override
    public List<ProgressStatus> findAll() {
        return List.of();
    }

    @Override
    public ProgressStatus save() {
        return null;
    }

    @Override
    public ProgressStatus findById(Long idProgressStatus) {
        return null;
    }
}
