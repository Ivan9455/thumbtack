package net.thumbtack.school.hiring.user.employee;

import net.thumbtack.school.hiring.user.Employee;
import net.thumbtack.school.hiring.Skill;
import net.thumbtack.school.hiring.error.ErrorException;
import org.junit.Test;

public class TestEmployee {
    @Test
    public void testEmployee() throws ErrorException {
        Employee employee = new Employee("Падерин", "Иван", "Андреевич",true,"1");
        employee.setSkill(new Skill("java",2,true));
    }
}
