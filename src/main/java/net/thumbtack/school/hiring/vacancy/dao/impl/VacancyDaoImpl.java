package net.thumbtack.school.hiring.vacancy.dao.impl;

import net.thumbtack.school.hiring.database.DataBase;
import net.thumbtack.school.hiring.error.ErrorCode;
import net.thumbtack.school.hiring.error.ErrorException;
import net.thumbtack.school.hiring.vacancy.Vacancy;
import net.thumbtack.school.hiring.vacancy.dao.VacancyDao;

import java.util.LinkedHashSet;
import java.util.Set;

public class VacancyDaoImpl implements VacancyDao {
    @Override
    public void insert(Vacancy vacancy) throws ErrorException {
        if (DataBase.vacancidb.contains(vacancy)) {
            throw new ErrorException(ErrorCode.WRONG_VACANCY);
        } else {
            DataBase.vacancidb.add(vacancy);
        }
    }

    @Override
    public Set<Vacancy> getManyVacancy() {
        return DataBase.vacancidb;
    }

    @Override
    public Set<Vacancy> getAllVacancy() {
        Set<Vacancy> vacancies = new LinkedHashSet<>();
        for (Vacancy vacancy : DataBase.vacancidb) {
            if (vacancy.isActive()) {
                vacancies.add(vacancy);
            }
        }
        return vacancies;
    }
}
