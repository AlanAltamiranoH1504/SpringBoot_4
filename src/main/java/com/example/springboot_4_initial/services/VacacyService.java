package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.exceptions.NotFoundVacancy;
import com.example.springboot_4_initial.models.Vacancy;
import com.example.springboot_4_initial.services.interfaces.IVacacyService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VacacyService implements IVacacyService {
    @Override
    public List<Vacancy> list_vacancys() {
        List<Vacancy> list_vacancy = new ArrayList<>();
        Vacancy vacancy1 = new Vacancy(1L, "Desarrollador Laravel", new Date(), "Desarrollador backend Laravel", 17000, true);
        Vacancy vacancy2 = new Vacancy(2L, "Desarrollador SpringBoot", new Date(), "Desarrollador backend SpringBoot", 20000, true);
        Vacancy vacancy3 = new Vacancy(3L, "Desarrollador NestJs", new Date(), "Desarrollador backend NetsJs", 18500, true);
        list_vacancy.add(vacancy1);
        list_vacancy.add(vacancy2);
        list_vacancy.add(vacancy3);
        return list_vacancy;
    }

    @Override
    public Vacancy get_vacancy(Long id) {
        for (var vacancy: this.list_vacancys()) {
            if (vacancy.getId() == id) {
                return vacancy;
            }
        }
        throw new NotFoundVacancy("La vacante con id: " + id + " no se encuetra dentro del listado");
    }
}
