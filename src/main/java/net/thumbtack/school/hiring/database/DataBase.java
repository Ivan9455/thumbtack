package net.thumbtack.school.hiring.database;

import net.thumbtack.school.hiring.session.Session;
import net.thumbtack.school.hiring.vacancy.Vacancy;
import net.thumbtack.school.hiring.user.Employee;
import net.thumbtack.school.hiring.user.Employer;

import java.util.LinkedHashSet;
import java.util.Set;

public class DataBase {
    public static Set<Employee> employeedb = new LinkedHashSet<>();
    public static Set<Employer> employerdb = new LinkedHashSet<>();
    public static Set<Vacancy> vacancidb = new LinkedHashSet<>();
    public static Set<Session> sessiondb = new LinkedHashSet<>();
}
