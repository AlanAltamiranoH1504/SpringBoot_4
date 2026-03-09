package com.example.springboot_4_initial.repositories;

import com.example.springboot_4_initial.models.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractTypeRepository extends JpaRepository<ContractType, Long> {
}
