package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.models.ContractType;
import com.example.springboot_4_initial.services.interfaces.IContractTypeService;

import java.util.List;

public class ContractTypeService implements IContractTypeService {
    @Override
    public List<ContractType> findAll() {
        return List.of();
    }

    @Override
    public ContractType save() {
        return null;
    }

    @Override
    public ContractType findById(Long idContractType) {
        return null;
    }
}
