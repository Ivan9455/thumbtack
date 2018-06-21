package net.thumbtack.school.hiring.user.dao.impl;


import net.thumbtack.school.hiring.database.DataBase;
import net.thumbtack.school.hiring.user.dao.EmployeeDao;
import net.thumbtack.school.hiring.user.dao.EmployerDao;
import net.thumbtack.school.hiring.user.Employee;
import net.thumbtack.school.hiring.user.Employer;
import net.thumbtack.school.hiring.error.ErrorCode;
import net.thumbtack.school.hiring.error.ErrorException;

import java.util.Set;

public class UserDaoImpl implements EmployeeDao, EmployerDao {
    @Override
    public void insert(Employee employee) throws ErrorException {
        if (check(employee.getEmail())) {
            DataBase.employeedb.add(employee);
        }
        DataBase.employeedb.add(employee);
    }

    @Override
    public void insert(Employer employer) throws ErrorException {
        if (check(employer.getEmail())) {
            DataBase.employerdb.add(employer);
        }
        DataBase.employerdb.add(employer);
    }

    @Override
    public Set<Employee> getManyEmployee() {
        return DataBase.employeedb;
    }

    @Override
    public Set<Employer> getManyEmployer() {
        return DataBase.employerdb;
    }

    @Override
    public boolean check(String email) throws ErrorException {
        for (Employer e : DataBase.employerdb) {
            if (email.equals(e.getEmail())) {
                throw new ErrorException(ErrorCode.WRONG_EMAIL);
            }
        }
        for (Employee e : DataBase.employeedb) {
            if (email.equals(e.getEmail())) {
                throw new ErrorException(ErrorCode.WRONG_EMAIL);
            }
        }
        return true;
    }
}
