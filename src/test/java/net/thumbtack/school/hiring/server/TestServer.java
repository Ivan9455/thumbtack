package net.thumbtack.school.hiring.server;


import com.google.gson.Gson;
import net.thumbtack.school.hiring.session.Session;
import net.thumbtack.school.hiring.Skill;
import net.thumbtack.school.hiring.user.Employee;
import net.thumbtack.school.hiring.user.Employer;
import net.thumbtack.school.hiring.error.ErrorCode;
import net.thumbtack.school.hiring.error.ErrorException;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestServer {

    @Test
    public void TestStartServer() {
        String fileName = "in.json";
        try (FileOutputStream fin = new FileOutputStream(new File(fileName));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fin))) {
            Gson json = new Gson();
            Server server = new Server();
            server.clearServer();//если не вызвать данный метод то база данных будет уже занята данными из предыдущего теста так ка переменные хранящие данные статичны

            Employee employee1 = new Employee("Падерин", "Иван", "Андреевич",
                    "pade@mail1.com", true, "1");
            Employee employee2 = new Employee("Падерин", "Андрей", "Леонидович",
                    "pade@mail2.com", true, "1");
            employee1.setSkill(new Skill("java", 2, true));
            employee1.setSkill(new Skill("git", 2, true));
            employee2.setSkill(new Skill("php", 3, true));
            employee2.setSkill(new Skill("mysql", 1, true));
            Employer employer1 = new Employer("Падерин", "Иван", "Андреевич",
                    "pade@mail3.com", "mit", "omsk", "1");
            Employer employer2 = new Employer("Падерин", "Андрей", "Леонидович",
                    "pade@mail4.com", "mit", "omsk", "1");

            Set<Object> set = new LinkedHashSet<>();
            Set<Employee> setE = new LinkedHashSet<>();
            Set<Employer> setEr = new LinkedHashSet<>();

            setE.add(employee1);
            setE.add(employee2);

            setEr.add(employer1);
            setEr.add(employer2);

            set.add(setE);
            set.add(setEr);

            bw.write(json.toJson(set));
            bw.flush();
            bw.close();

            server.startServer(fileName);

            assertEquals(setE, server.getUserdao().getManyEmployee());
            assertEquals(setEr, server.getUserdao().getManyEmployer());


        } catch (Exception e) {
            e.printStackTrace();//доделать
        }
    }

    @Test
    public void TestStopServer() throws ErrorException {
        String fileName = "out.json";
        Gson json = new Gson();
        Server server = new Server();
        server.clearServer();
        server.startServer(null);
        Employee employee1 = new Employee("Падерин", "Иван", "Андреевич",
                "1paderin@mail.com4", true, "1");
        Employee employee2 = new Employee("Падерин", "Андрей ", "Леонидович",
                "1paderin@mail1.com44", true, "1");
        Employer employer1 = new Employer("Падерин", "Иван", "Андреевич",
                "1paderin@mail1.com", "mit", "omsk", "1");
        Employer employer2 = new Employer("Падерин", "Андрей ", "Леонидович",
                "2paderin@mail2.com", "mit", "omsk", "1");
        Employer employer3 = new Employer("Падерин", "Виктор ", "Леонидович",
                "3paderin@mail3.com", "mit", "omsk", "1");


        server.getUserdao().insert(employee1);
        server.getUserdao().insert(employee2);

        server.getUserdao().insert(employer1);
        server.getUserdao().insert(employer2);
        server.getUserdao().insert(employer3);

        Set<Object> objects = new LinkedHashSet<>();
        objects.add(server.getUserdao().getManyEmployee());
        objects.add(server.getUserdao().getManyEmployer());

        server.stopServer(fileName);
        assertTrue(objects.contains(server.getUserdao().getManyEmployee()));
        assertTrue(objects.contains(server.getUserdao().getManyEmployer()));
    }


    @Test
    public void TestRegisterEmployer() throws ErrorException {
        Server server = new Server();
        server.clearServer();
        server.startServer(null);
        Employer employer = new Employer("Падерин", "Иван", "Андреевич",
                "1paderin@mai11l.com", "mit", "omsk","1");
        server.getUserdao().insert(employer);
        Employer employer1 = new Employer("Падерин", "Иван", "Андреевич",
                "2paderin@mail.com4", "mit", "omsk","1");
        server.clearServer();
    }

    @Test
    public void TestRegisterEmployer2() throws ErrorException {
        Server server = new Server();
        server.clearServer();
        server.startServer(null);
        Employer employer1 = new Employer("Падерин", "Иван", "Андреевич", "mit", "omsk","1");
    }

    @Test
    public void TestsServerParser1() {
        try {
            Server server = new Server("", "in1.json", "out1.json", "-s");
        } catch (ErrorException e) {
            assertEquals(e.getErrorCode(), ErrorCode.SERVER_WRONG_COMMAND_LOAD);
        }
        try {
            Server server = new Server("-l", "in1.json", "out1.json", "");
        } catch (ErrorException e) {
            assertEquals(e.getErrorCode(), ErrorCode.SERVER_WRONG_COMMAND_SAVE);
        }
    }

    @Test
    public void TestsServerParser2() throws ErrorException {
        Server server = new Server("-l", "", "out1.json", "-s");
        server.startServer();
        server.clearServer();
        Employee employee1 = new Employee("Падерин", "Андрей", "Леонидович",
                "1paderin@mail1.com44", true,"1.0");
        Employer employer1 = new Employer("Падерин", "Иван", "Андреевич",
                "1paderin@mail1.com",  "mit", "omsk","2.0");

        server.getUserdao().insert(employee1);
        server.getUserdao().insert(employer1);
        Set<Employer> employerSet = new LinkedHashSet<>();
        Set<Employee> employeeSet = new LinkedHashSet<>();
        employeeSet.addAll(server.getUserdao().getManyEmployee());
        employerSet.addAll(server.getUserdao().getManyEmployer());

        server.stopServer();
        server.clearServer();
        Server server2 = new Server();
        server2.startServer("out1.json");
        Gson json = new Gson();
        assertEquals(json.toJson(employerSet), json.toJson(server2.getUserdao().getManyEmployer()));
        assertEquals(json.toJson(employeeSet), json.toJson(server2.getUserdao().getManyEmployee()));
    }

    @Test
    public void TestRegisterEmployer3() throws ErrorException {
        Gson json = new Gson();
        Server server = new Server();
        server.startServer(null);
        server.clearServer();
        Employer employer1 = new Employer("Падерин", "Иван", "Андреевич",
                "1paderin@mail1.com", "mit", "omsk","1");
        server.registrationEmployer(json.toJson(employer1));
        try {
            server.registrationEmployer(json.toJson(employer1));
        } catch (ErrorException e) {
            assertEquals(e.getErrorCode(), ErrorCode.WRONG_LOGIN);
        }
    }

    @Test
    public void TestRegisterEmployee3() throws ErrorException {
        Gson json = new Gson();
        Server server = new Server();
        server.startServer(null);
        server.clearServer();
        Employer employer1 = new Employer("Падерин", "Иван", "Андреевич",
                "1paderin@mail1.com",  "mit", "omsk","1");
        server.registrationEmployer(json.toJson(employer1));
        try {
            server.registrationEmployer(json.toJson(employer1));
        } catch (ErrorException e) {
            assertEquals(e.getErrorCode(), ErrorCode.WRONG_LOGIN);
        }
    }

    @Test
    public void TestSkill() throws ErrorException {
        Server server = new Server();
        server.clearServer();
        server.startServer(null);
        Employee employee1 = new Employee("Падерин", "Иван", "Андреевич",
                "1paderin@mail.com4", true,"1");
        server.getUserdao().insert(employee1);
        employee1.setSkill(new Skill("java", 2, true));

    }

    @Test
    public void TestLoginEmployee() throws ErrorException {
        Gson json = new Gson();
        Server server = new Server();
        server.clearServer();
        server.startServer(null);
        Employee employee1 = new Employee("Падерин", "Иван", "Андреевич",
                "1paderin@mail.com4", true,"1");
        server.getUserdao().insert(employee1);
        server.login(json.toJson(new Session("IVAN1", "wwwwwww")));
    }

    @Test
    public void TestLoginEmployer() throws ErrorException {
        Gson json = new Gson();
        Server server = new Server();
        server.clearServer();
        server.startServer(null);
        Employer employer1 = new Employer("Падерин", "Иван", "Андреевич",
                "1paderin@mail1.com",  "mit", "omsk","1");
        server.getUserdao().insert(employer1);
        server.login(json.toJson(new Session("risss", "wwwwwwwww")));
    }

}
