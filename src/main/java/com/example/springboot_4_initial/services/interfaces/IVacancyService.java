package com.example.springboot_4_initial.services.interfaces;

import com.example.springboot_4_initial.models.Vacancy;

import java.util.List;

public interface IVacancyService {
    public abstract List<Vacancy> list_vacancies(boolean status);
    public abstract Vacancy save_vacancy(Vacancy vacancy);
    public abstract Vacancy get_vacancy(Long id);
    public abstract boolean delete_vacancy(Long id);
}
