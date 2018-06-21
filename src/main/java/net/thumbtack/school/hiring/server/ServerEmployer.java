package net.thumbtack.school.hiring.server;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.vacancy.Vacancy;
import net.thumbtack.school.hiring.user.User;
import net.thumbtack.school.hiring.user.dao.impl.UserDaoImpl;
import net.thumbtack.school.hiring.user.Employee;
import net.thumbtack.school.hiring.error.ErrorException;

import java.util.LinkedHashSet;
import java.util.Set;

public class ServerEmployer {
    private UserDaoImpl userdao = new UserDaoImpl();
    private Gson json = new Gson();

    public String getVacancyLevel(String requestJsonSkill) throws ErrorException {
        Vacancy vacancyemploey = json.fromJson(requestJsonSkill, Vacancy.class);
        Set<User> user = new LinkedHashSet<>();
        for (Employee employee : userdao.getManyEmployee()) {
            if (vacancyemploey.isAppropriateSkillsLevelRequired(employee.getSkill())) {
                user.add(new Employee(
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getPatronymicname(),
                        employee.getEmail()));
            }
        }
        return json.toJson(user);
    }

    public String getVacancyNotLevel(String requestJsonSkill) throws ErrorException {
        Vacancy vacancyemploey = json.fromJson(requestJsonSkill, Vacancy.class);
        Set<User> user = new LinkedHashSet<>();
        for (Employee employee : userdao.getManyEmployee()) {
            if (vacancyemploey.isAppropriateSkillsAllLevel(employee.getSkill())) {
                user.add(new Employee(
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getPatronymicname(),
                        employee.getEmail()));
            }
        }
        return json.toJson(user);
    }

    public String getVacancyOneSkillLevel(String requestJsonSkill) throws ErrorException {
        Vacancy vacancyemploey = json.fromJson(requestJsonSkill, Vacancy.class);
        Set<User> user = new LinkedHashSet<>();
        for (Employee employee : userdao.getManyEmployee()) {
            if (vacancyemploey.isAppropriateOneSkillsLevel(employee.getSkill())) {
                user.add(new Employee(
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getPatronymicname(),
                        employee.getEmail()));
            }
        }
        return json.toJson(user);
    }
}
