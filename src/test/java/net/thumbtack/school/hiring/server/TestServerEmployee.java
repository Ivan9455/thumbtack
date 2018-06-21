package net.thumbtack.school.hiring.server;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.vacancy.dao.impl.VacancyDaoImpl;
import net.thumbtack.school.hiring.Skill;
import net.thumbtack.school.hiring.user.Employee;
import net.thumbtack.school.hiring.vacancy.Vacancy;
import net.thumbtack.school.hiring.error.ErrorException;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class TestServerEmployee {

    @Test
    public void testGetVacancyLevel() throws ErrorException {
        Gson json = new Gson();
        Server server = new Server();
        server.clearServer();
        VacancyDaoImpl vacancyDao = new VacancyDaoImpl();

        Set<Skill> skills1 = new LinkedHashSet<>();
        skills1.add(new Skill("java", 2, true));
        skills1.add(new Skill("git", 1, true));
        Vacancy vacancy11 = new Vacancy("junior java", "от 30000", true, skills1, "1");
        vacancyDao.insert(vacancy11);

        Set<Skill> skills1v1 = new LinkedHashSet<>();
        skills1v1.add(new Skill("php", 2, true));
        skills1v1.add(new Skill("git", 1, true));
        skills1v1.add(new Skill("mysql", 1, true));
        Vacancy vacancy12 = new Vacancy("junior php", "от 30000", true, skills1v1, "1");
        vacancyDao.insert(vacancy12);

        Set<Skill> skills2 = new LinkedHashSet<>();
        skills2.add(new Skill("java", 3, true));
        skills2.add(new Skill("git", 3, true));
        Vacancy vacancy21 = new Vacancy("middle java", "от 50000", true, skills2, "2");
        vacancyDao.insert(vacancy21);

        Set<Skill> skills2v1 = new LinkedHashSet<>();
        skills2v1.add(new Skill("php", 3, true));
        skills2v1.add(new Skill("git", 2, true));
        skills2v1.add(new Skill("mysql", 2, true));
        Vacancy vacancy22 = new Vacancy("middle php", "от 50000", true, skills2v1, "2");
        vacancyDao.insert(vacancy22);

        Set<Skill> skills3 = new LinkedHashSet<>();
        skills3.add(new Skill("java", 4, true));
        skills3.add(new Skill("git", 4, true));
        Vacancy vacancy31 = new Vacancy("senior java", "от 100000", true, skills3, "3");
        vacancyDao.insert(vacancy31);

        Set<Skill> skills3v1 = new LinkedHashSet<>();
        skills3v1.add(new Skill("php", 4, true));
        skills3v1.add(new Skill("git", 3, true));
        skills3v1.add(new Skill("mysql", 3, true));
        Vacancy vacancy32 = new Vacancy("senior php", "от 90000", true, skills3v1, "3");
        vacancyDao.insert(vacancy32);


        Employee employee1 = new Employee("Падерин", "Иван", "Андреевич", "pade@.com", true,"1");
        employee1.setSkill(new Skill("php", 2, true));
        employee1.setSkill(new Skill("git", 1, true));
        employee1.setSkill(new Skill("mysql", 1, true));

        ServerEmployee serverEmployee = new ServerEmployee();
        Set<Vacancy> vacanciese = new LinkedHashSet<>();
        vacanciese.add(vacancy12);


        assertEquals(json.toJson(vacanciese), serverEmployee.getVacancyLevel(json.toJson(employee1)));


    }


    @Test
    public void testGetVacancySort() throws ErrorException {
        Gson json = new Gson();
        Server server = new Server();
        server.clearServer();


        Set<Skill> skills1v1 = new LinkedHashSet<>();
        skills1v1.add(new Skill("java", 2, true));
        skills1v1.add(new Skill("git", 1, true));
        Vacancy vacancy11 = new Vacancy("junior java", "от 30000", true, skills1v1, "1");

        Set<Skill> skills1v2 = new LinkedHashSet<>();
        skills1v2.add(new Skill("php", 2, true));
        skills1v2.add(new Skill("git", 1, true));
        skills1v2.add(new Skill("mysql", 1, true));
        Vacancy vacancy12 = new Vacancy("junior php", "от 30000", true, skills1v2, "1");

        Set<Skill> skills1v3 = new LinkedHashSet<>();
        skills1v3.add(new Skill("html", 2, true));
        skills1v3.add(new Skill("css", 1, true));
        skills1v3.add(new Skill("mysql", 1, false));
        skills1v3.add(new Skill("react", 1, true));
        Vacancy vacancy13 = new Vacancy("junior react", "от 30000", true, skills1v3, "1");
        ///////////////////////////////////////////////
        Set<Skill> skills2v1 = new LinkedHashSet<>();
        skills2v1.add(new Skill("java", 3, true));
        skills2v1.add(new Skill("git", 3, false));
        Vacancy vacancy21 = new Vacancy("middle java", "от 50000", true, skills2v1, "2");

        Set<Skill> skills2v2 = new LinkedHashSet<>();
        skills2v2.add(new Skill("php", 3, true));
        skills2v2.add(new Skill("git", 2, true));
        skills2v2.add(new Skill("mysql", 2, false));
        Vacancy vacancy22 = new Vacancy("middle php", "от 50000", true, skills2v2, "2");

        Set<Skill> skills2v3 = new LinkedHashSet<>();
        skills2v3.add(new Skill("html", 3, true));
        skills2v3.add(new Skill("css", 2, true));
        skills2v3.add(new Skill("mysql", 2, false));
        skills2v3.add(new Skill("react", 2, true));
        Vacancy vacancy23 = new Vacancy("middle react", "от 50000", false, skills2v3, "2");
        ///////////////////////////////////////////////
        Set<Skill> skills3v1 = new LinkedHashSet<>();
        skills3v1.add(new Skill("java", 4, true));
        skills3v1.add(new Skill("git", 4, true));
        Vacancy vacancy31 = new Vacancy("senior java", "от 100000", true, skills3v1, "3");

        Set<Skill> skills3v2 = new LinkedHashSet<>();
        skills3v2.add(new Skill("php", 4, true));
        skills3v2.add(new Skill("git", 3, false));
        skills3v2.add(new Skill("mysql", 3, true));
        Vacancy vacancy32 = new Vacancy("senior php", "от 90000", false, skills3v2, "3");

        Set<Skill> skills3v3 = new LinkedHashSet<>();
        skills3v3.add(new Skill("html", 4, true));
        skills3v3.add(new Skill("css", 3, true));
        skills3v3.add(new Skill("mysql", 3, true));
        skills3v3.add(new Skill("react", 3, true));
        Vacancy vacancy33 = new Vacancy("senior react", "от 90000", true, skills3v3, "3");

        VacancyDaoImpl vacancyDao = new VacancyDaoImpl();
        vacancyDao.insert(vacancy11);
        vacancyDao.insert(vacancy12);
        vacancyDao.insert(vacancy13);
        vacancyDao.insert(vacancy21);
        vacancyDao.insert(vacancy22);
        vacancyDao.insert(vacancy23);
        vacancyDao.insert(vacancy31);
        vacancyDao.insert(vacancy32);
        vacancyDao.insert(vacancy33);
        Employee employee1test = new Employee("Падерин", "Иван", "Андреевич", "pade@.com", true,"1", skills2v1);


        Set<Vacancy> set2 = new LinkedHashSet<>();
        set2.add(vacancy11);
        set2.add(vacancy21);
        set2.add(vacancy22);
        set2.add(vacancy12);


        ServerEmployee serverEmployee = new ServerEmployee();

        assertEquals(json.toJson(set2), serverEmployee.getVacancySort(json.toJson(employee1test)));
    }

    @Test
    public void getVacancyAllLevel() throws ErrorException {
        Gson json = new Gson();
        Server server = new Server();
        server.clearServer();
        VacancyDaoImpl vacancyDao = new VacancyDaoImpl();

        Set<Skill> skills1 = new LinkedHashSet<>();
        skills1.add(new Skill("java", 2, true));
        skills1.add(new Skill("git", 1, true));
        Vacancy vacancy11 = new Vacancy("junior java", "от 30000", true, skills1, "1");
        vacancyDao.insert(vacancy11);

        Set<Skill> skills1v1 = new LinkedHashSet<>();
        skills1v1.add(new Skill("php", 2, true));
        skills1v1.add(new Skill("git", 1, true));
        skills1v1.add(new Skill("mysql", 1, true));
        Vacancy vacancy12 = new Vacancy("junior php", "от 30000", true, skills1v1, "1");
        vacancyDao.insert(vacancy12);

        Set<Skill> skills2 = new LinkedHashSet<>();
        skills2.add(new Skill("java", 3, true));
        skills2.add(new Skill("git", 3, true));
        Vacancy vacancy21 = new Vacancy("middle java", "от 50000", true, skills2, "2");
        vacancyDao.insert(vacancy21);

        Set<Skill> skills2v1 = new LinkedHashSet<>();
        skills2v1.add(new Skill("php", 3, true));
        skills2v1.add(new Skill("git", 2, true));
        skills2v1.add(new Skill("mysql", 2, true));
        Vacancy vacancy22 = new Vacancy("middle php", "от 50000", true, skills2v1, "2");
        vacancyDao.insert(vacancy22);

        Set<Skill> skills3 = new LinkedHashSet<>();
        skills3.add(new Skill("java", 4, true));
        skills3.add(new Skill("git", 4, true));
        Vacancy vacancy31 = new Vacancy("senior java", "от 100000", true, skills3, "3");
        vacancyDao.insert(vacancy31);

        Set<Skill> skills3v1 = new LinkedHashSet<>();
        skills3v1.add(new Skill("php", 4, true));
        skills3v1.add(new Skill("git", 3, true));
        skills3v1.add(new Skill("mysql", 3, true));
        Vacancy vacancy32 = new Vacancy("senior php", "от 90000", true, skills3v1, "3");
        vacancyDao.insert(vacancy32);


        Employee employee1 = new Employee("Падерин", "Иван", "Андреевич", "pade@.com", true,"1");
        employee1.setSkill(new Skill("php", 2, true));
        employee1.setSkill(new Skill("git", 1, true));
        employee1.setSkill(new Skill("mysql", 1, true));
        ServerEmployee serverEmployee = new ServerEmployee();
        Set<Vacancy> vacancies = new LinkedHashSet<>();
        vacancies.add(vacancy12);
        vacancies.add(vacancy22);
        vacancies.add(vacancy32);
        assertEquals(json.toJson(vacancies), serverEmployee.getVacancyAllLevel(json.toJson(employee1)));
    }

}
