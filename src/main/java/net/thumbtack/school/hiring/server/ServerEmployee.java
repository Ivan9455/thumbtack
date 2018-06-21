package net.thumbtack.school.hiring.server;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.vacancy.dao.impl.VacancyDaoImpl;

import net.thumbtack.school.hiring.user.Employee;
import net.thumbtack.school.hiring.vacancy.Vacancy;


import java.util.*;

public class ServerEmployee {
    private VacancyDaoImpl vacancydao = new VacancyDaoImpl();
    private Gson json = new Gson();

    public String getVacancyLevel(String requestJsonSkill) {
        Employee empl = json.fromJson(requestJsonSkill, Employee.class);
        Set<Vacancy> employersVacancies = new LinkedHashSet<>();
        for (Vacancy vacancy : vacancydao.getAllVacancy()) {
            if (vacancy.isAppropriateSkillsLevelRequired(empl.getSkill())) {
                employersVacancies.add(vacancy);
            }
        }
        return json.toJson(employersVacancies);
    }


    public String getVacancyAllLevel(String requestJsonSkill) {
        Employee empl = json.fromJson(requestJsonSkill, Employee.class);
        Set<Vacancy> employersVacancies = new LinkedHashSet<>();
        for (Vacancy vacancy : vacancydao.getAllVacancy()) {
            if (vacancy.isAppropriateSkillsAllLevel(empl.getSkill())) {
                employersVacancies.add(vacancy);
            }
        }
        return json.toJson(employersVacancies);
    }

    public String getVacancySort(String requestJsonSkill) {
        double vacancyposition = 0.01;
        Employee empl = json.fromJson(requestJsonSkill, Employee.class);
        TreeMap<Double, Vacancy> employersVacancies = new TreeMap<>();
        for (Vacancy vacancy : vacancydao.getAllVacancy()) {
            vacancyposition += 0.01;
            if (vacancy.isAppropriateSkillsCount(empl.getSkill(),vacancyposition) != null) {
                employersVacancies.putAll(vacancy.isAppropriateSkillsCount(empl.getSkill(),vacancyposition));
            }
        }
        List<Vacancy> e = new LinkedList<>();
        e.addAll(employersVacancies.values());
        Collections.reverse(e);
        return json.toJson(e);
    }
}
