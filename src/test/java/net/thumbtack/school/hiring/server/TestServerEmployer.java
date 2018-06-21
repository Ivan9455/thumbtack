package net.thumbtack.school.hiring.server;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.vacancy.Vacancy;

import net.thumbtack.school.hiring.Skill;
import net.thumbtack.school.hiring.user.User;
import net.thumbtack.school.hiring.user.dao.impl.UserDaoImpl;
import net.thumbtack.school.hiring.user.Employee;

import net.thumbtack.school.hiring.error.ErrorException;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;


public class TestServerEmployer {
    @Test
    public void testGetVacancyLevel() throws ErrorException {//проверяються все методы класса ServerEmployer
        Gson json = new Gson();
        Server server = new Server();
        server.clearServer();
        server.startServer(null);
        UserDaoImpl userDao = new UserDaoImpl();
        Employee employee1 = new Employee("Падерин", "Иван1", "Андреевич", "paderin@mail21.ru", true,"1");
        Employee employee2 = new Employee("Падерин", "Иван2", "Андреевич", "paderin@mail22.ru", true,"1");
        Employee employee3 = new Employee("Падерин", "Иван3", "Андреевич", "paderin@mail23.ru", true,"1");
        Employee employee4 = new Employee("Падерин", "Иван3", "Андреевич", "paderin@mail234.ru", true,"1");
        employee1.setSkill(new Skill("git", 3, true));
        employee1.setSkill(new Skill("maven", 1, true));
        employee1.setSkill(new Skill("java", 2, true));
        employee1.setSkill(new Skill("mysql", 2, true));

        employee2.setSkill(new Skill("git", 4, true));
        employee2.setSkill(new Skill("php", 4, true));
        employee2.setSkill(new Skill("mysql", 4, true));
        employee2.setSkill(new Skill("css", 4, true));

        employee3.setSkill(new Skill("js", 2, true));
        employee3.setSkill(new Skill("git", 2, true));
        employee3.setSkill(new Skill("reactjs", 1, true));
        employee3.setSkill(new Skill("css", 3, true));

        employee4.setSkill(new Skill("html", 2, true));
        employee4.setSkill(new Skill("css", 2, true));
        employee4.setSkill(new Skill("git", 1, true));
        employee4.setSkill(new Skill("mysql", 1, true));

        userDao.insert(employee1);
        userDao.insert(employee2);
        userDao.insert(employee3);
        userDao.insert(employee4);

        ServerEmployer se = new ServerEmployer();
        Set<Skill> s1 = new LinkedHashSet<>();

        s1.add(new Skill("git", 3, true));
        s1.add(new Skill("mysql", 2, true));
        Vacancy vacancy1 = new Vacancy("разрботчик баз данных", "40000", true, "1");
        vacancy1.setSkill(s1);

        Set<User> e1 = new LinkedHashSet<>();
        Set<User> e2 = new LinkedHashSet<>();
        Set<User> e3 = new LinkedHashSet<>();
        Set<User> e4 = new LinkedHashSet<>();

        User user1 = new Employee(employee1.getLastName(), employee1.getFirstName(), employee1.getPatronymicname(), employee1.getEmail());
        User user2 = new Employee(employee2.getLastName(), employee2.getFirstName(), employee2.getPatronymicname(), employee2.getEmail());
        User user3 = new Employee(employee3.getLastName(), employee3.getFirstName(), employee3.getPatronymicname(), employee3.getEmail());
        User user4 = new Employee(employee4.getLastName(), employee4.getFirstName(), employee4.getPatronymicname(), employee4.getEmail());

        e1.add(user1);
        e1.add(user2);
        e3.add(user1);
        e3.add(user2);
        e3.add(user4);
        e4.add(user1);
        e4.add(user2);

        assertEquals(se.getVacancyLevel(json.toJson(vacancy1)), json.toJson(e1));
        assertEquals(se.getVacancyNotLevel(json.toJson(vacancy1)), json.toJson(e3));
        assertEquals(se.getVacancyOneSkillLevel(json.toJson(vacancy1)), json.toJson(e4));
    }
}
