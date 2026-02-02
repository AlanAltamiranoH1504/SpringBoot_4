package com.example.springboot_4_initial.services.interfaces;

import com.example.springboot_4_initial.models.Vacancy;

import java.util.List;
import java.util.Optional;

public interface IVacacyService {
    public abstract List<Vacancy> list_vacancys();
    public abstract Vacancy get_vacancy(Long id);
}
