package net.thumbtack.school.hiring;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.server.TestServer;
import net.thumbtack.school.hiring.server.TestServerEmployee;
import net.thumbtack.school.hiring.server.TestServerEmployer;
import net.thumbtack.school.hiring.user.Employee;
import net.thumbtack.school.hiring.user.Employer;
import net.thumbtack.school.hiring.user.TestSkill;
import net.thumbtack.school.hiring.user.User;
import net.thumbtack.school.hiring.user.employee.TestEmployee;
import net.thumbtack.school.hiring.user.employer.TestEmployer;
import net.thumbtack.school.hiring.error.ErrorException;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

public class TestAllClass {
    @Test
    public void testClass() throws ErrorException {
        TestSession testSession = new TestSession();
        testSession.testSession();
        TestSkill testSkill = new TestSkill();
        testSkill.testSkill();
        TestVacancy testVacancy = new TestVacancy();
        testVacancy.testVacancy();
        try {
            testVacancy.testVacancy2();
            TestEmployee testEmployee = new TestEmployee();
            testEmployee.testEmployee();
            TestServerEmployer testServerEmployer = new TestServerEmployer();
            testServerEmployer.testGetVacancyLevel();
            TestServerEmployee testServerEmployee = new TestServerEmployee();
            testServerEmployee.testGetVacancyLevel();
            testServerEmployee.getVacancyAllLevel();
            TestServer testServer = new TestServer();
            testServer.TestStartServer();
            testServer.TestStopServer();
            testServer.TestRegisterEmployee3();
            testServer.TestRegisterEmployer();
            testServer.TestRegisterEmployer2();
            testServer.TestRegisterEmployer3();
            testServer.TestSkill();
            testServer.TestsServerParser1();
            testServer.TestsServerParser2();
            testServer.TestStartServer();
            testServer.TestStopServer();
        } catch (ErrorException e) {
            e.printStackTrace();
        }
        TestEmployer testEmployer = new TestEmployer();
        testEmployer.TestEmployer();
        User employer = new Employer("w","w","qweq","1","12","1","1");
        User employee = new Employee("w","w","qweq","1","12");
        System.out.println(new Gson().toJson(employer));
        Set<User> set = new LinkedHashSet<>();
        set.add(employer);
        set.add(employee);
        System.out.println(new Gson().toJson(set));
    }
}
