package net.thumbtack.school.hiring.user.dao;

import net.thumbtack.school.hiring.user.Employee;
import net.thumbtack.school.hiring.error.ErrorException;

import java.util.Set;

public interface EmployeeDao {

    void insert(Employee employee) throws ErrorException;

    Set<Employee> getManyEmployee();

    boolean check(String email) throws ErrorException;
}
