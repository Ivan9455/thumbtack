package net.thumbtack.school.hiring.user;

import net.thumbtack.school.hiring.Skill;
import net.thumbtack.school.hiring.error.ErrorException;

import java.util.LinkedHashSet;
import java.util.Set;

public class Employee extends User {
    private boolean status;
    private Set<Skill> skill = new LinkedHashSet<>();

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Skill> getSkill() {
        return skill;
    }

    public void setSkill(Set<Skill> skill) {
        this.skill.addAll(skill);
    }

    public void setSkill(Skill skill) {
        this.skill.add(skill);
    }

    public Employee() {

    }

    public Employee(String lastName, String firstName, String email,
                    boolean status, String id) throws ErrorException {
        super(lastName, firstName, email, id);
        this.status = status;
    }

    public Employee(String lastName, String firstName, String patronymicName, String email,
                    boolean status, String id) throws ErrorException {
        super(lastName, firstName, patronymicName, email,id);
        this.status = status;
    }

    public Employee(String lastName, String firstName, String email,
                    boolean status, String id, Set<Skill> skill) throws ErrorException {
        this(lastName, firstName, email, status, id);
        setSkill(skill);
    }

    public Employee(String lastName, String firstName, String patronymicName, String email,
                    boolean status, String id, Set<Skill> skill) throws ErrorException {
        this(lastName, firstName, patronymicName, email, status, id);
        setSkill(skill);
    }

    public Employee(String lastName, String firstName, String email,
                    boolean status, String id, Skill skill) throws ErrorException {
        this(lastName, firstName, email, status, id);
        setSkill(skill);
    }

    public Employee(String lastName, String firstName, String patronymicName, String email,
                    boolean status, String id, Skill skill) throws ErrorException {
        this(lastName, firstName, patronymicName, email, status,id);
        setSkill(skill);
    }
    //
    public Employee(String lastName, String firstName, String email, String id) throws ErrorException {
        super(lastName, firstName, email, id);
    }

    public Employee(String lastName, String firstName, String patronymicname, String email, String id) throws ErrorException {
        super(lastName, firstName, patronymicname, email, id);
    }
}
