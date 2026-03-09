package com.example.springboot_4_initial.services.interfaces;

import com.example.springboot_4_initial.models.ContractType;

import java.util.List;

public interface IContractTypeService {
    public abstract List<ContractType> findAll();
    public abstract ContractType save();
    public abstract ContractType findById(Long idContractType);
}
