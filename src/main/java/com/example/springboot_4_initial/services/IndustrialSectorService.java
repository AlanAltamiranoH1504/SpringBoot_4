package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.models.ProgressStatus;
import com.example.springboot_4_initial.services.interfaces.IIndustrialSectorService;

import java.util.List;

public class IndustrialSectorService implements IIndustrialSectorService {
    @Override
    public List<ProgressStatus> findAll() {
        return List.of();
    }

    @Override
    public ProgressStatus save() {
        return null;
    }

    @Override
    public ProgressStatus findById(Long idIndustrialSector) {
        return null;
    }
}
