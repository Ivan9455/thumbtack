package net.thumbtack.school.hiring.user.dao;

import net.thumbtack.school.hiring.user.Employer;
import net.thumbtack.school.hiring.error.ErrorException;

import java.util.Set;

public interface EmployerDao {

    void insert(Employer employer) throws ErrorException;

    Set<Employer> getManyEmployer();

    boolean check(String email) throws ErrorException;
}
