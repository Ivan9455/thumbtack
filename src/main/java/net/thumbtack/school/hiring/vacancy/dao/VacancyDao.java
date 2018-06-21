package net.thumbtack.school.hiring.vacancy.dao;


import net.thumbtack.school.hiring.error.ErrorException;
import net.thumbtack.school.hiring.vacancy.Vacancy;

import java.util.Set;

public interface VacancyDao {
    void insert(Vacancy vacancy) throws ErrorException;

    Set<Vacancy> getManyVacancy();

    Set<Vacancy> getAllVacancy();
}
