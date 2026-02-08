package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.exceptions.vancacies.NotFoundVacancy;
import com.example.springboot_4_initial.exceptions.vancacies.NotFoundVacancys;
import com.example.springboot_4_initial.models.Vacancy;
import com.example.springboot_4_initial.repositories.IVacancyRepository;
import com.example.springboot_4_initial.services.interfaces.IVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyService implements IVacancyService {
    @Autowired
    private IVacancyRepository iVacancyRepository;

    @Override
    public List<Vacancy> list_vacancies(boolean status) {
        List<Vacancy> list_vacancies = iVacancyRepository.list_vacancies(status);
        if (list_vacancies.isEmpty()) {
            throw new NotFoundVacancys("No existen registros de vacantes");
        }
        return list_vacancies;
    }

    @Override
    public Vacancy save_vacancy(Vacancy vacancy) {
        Vacancy vacancy_to_save = iVacancyRepository.save(vacancy);
        if (vacancy_to_save.getId() == null) {
            throw new NotFoundVacancy("Ocurrio un error en la creación de la vacante");
        }
        return vacancy_to_save;
    }

    @Override
    public Vacancy get_vacancy(Long id) {
        Optional<Vacancy> vacancy_to_show = iVacancyRepository.findById(id);
        if (!vacancy_to_show.isPresent()) {
            throw new NotFoundVacancy("El registro de la vacante no fue encontrado");
        }
        return vacancy_to_show.get();
    }

    @Override
    public boolean delete_vacancy(Long id) {
        Vacancy vacancy_to_delete = this.get_vacancy(id);
        vacancy_to_delete.setStatus(false);
        this.save_vacancy(vacancy_to_delete);
        return true;
    }
}
