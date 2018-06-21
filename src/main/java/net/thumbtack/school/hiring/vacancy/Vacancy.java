package net.thumbtack.school.hiring.vacancy;


import net.thumbtack.school.hiring.Skill;
import net.thumbtack.school.hiring.error.ErrorCode;
import net.thumbtack.school.hiring.error.ErrorException;

import java.util.*;

public class Vacancy {
    private String post;
    private String salary;
    private Set<Skill> skill = new LinkedHashSet<>();
    private boolean active;
    private String emploierid;

    public String getPost() {
        return post;
    }

    public void setPost(String post) throws ErrorException {
        if (post == null || post.equals("")) {
            throw new ErrorException(ErrorCode.USER_WRONG_VACANCY_POST);
        } else {
            this.post = post;
        }
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) throws ErrorException {
        if (salary == null || salary.equals("")) {
            throw new ErrorException(ErrorCode.USER_WRONG_VACANCY_SALARY);
        } else {
            this.salary = salary;
        }
    }

    public Set<Skill> getSkill() {
        return skill;
    }

    public void setSkill(Set<Skill> skill) throws ErrorException {
        if (skill.isEmpty() || skill == null) {
            throw new ErrorException(ErrorCode.USER_WRONG_VACANCY_SKILL);
        } else {
            this.skill.addAll(skill);
        }
    }

    public void setSkill(Skill skill) throws ErrorException {
        if (skill == null || skill.equals("")) {
            throw new ErrorException(ErrorCode.USER_WRONG_VACANCY_SKILL);
        } else {
            this.skill.add(skill);
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setStatus(boolean status) {
        this.active = status;
    }

    public String getEmploierid() {
        return emploierid;
    }

    public void setEmploierid(String emploierid) {
        this.emploierid = emploierid;
    }

    public Vacancy(String post, String salary, boolean status, String emploierid) throws ErrorException {
        setPost(post);
        setSalary(salary);
        this.active = status;
        this.emploierid = emploierid;
    }

    public Vacancy(String post, String salary, boolean status, Set<Skill> skill, String emploierid) throws ErrorException {
        this(post, salary, status, emploierid);
        setSkill(skill);
    }

    public Vacancy(String post, String salary, boolean status, Skill skill, String emploierid) throws ErrorException {
        this(post, salary, status, emploierid);
        setSkill(skill);
    }

    public Vacancy() {

    }

    public boolean isAppropriateSkillsAllLevel(Set<Skill> skills) {
        int trueskillemployer = 0;
        int trueskillemployee = 0;
        for (Skill skillemployee : skill) {
            if (skillemployee.isRequest()) {
                trueskillemployer++;
                for (Skill skillemployer : skills) {
                    if (skillemployee.getName().equals(skillemployer.getName())) {
                        trueskillemployee++;
                    }
                }
            }
        }
        if (trueskillemployer == trueskillemployee) {
            return true;
        }
        return false;
    }

    public boolean isAppropriateSkillsLevelRequired(Set<Skill> skills) {
        int trueskillemployer = 0;
        int trueskillemployee = 0;
        for (Skill skillemployer : skill) {
            if (skillemployer.isRequest()) {
                trueskillemployer++;
                for (Skill skillemployee : skills) {
                    if (skillemployee.getName().equals(skillemployer.getName()) &&
                            skillemployee.getLevel() >= skillemployer.getLevel()) {
                        trueskillemployee++;
                    }
                }
            }
        }
        if (trueskillemployer == trueskillemployee) {
            return true;
        }
        return false;
    }

    public TreeMap<Double, Vacancy> isAppropriateSkillsCount(Set<Skill> skills, double vacancyposition) {
        int trueskill = 0;
        double trueskillsize = 0;
        TreeMap<Double, Vacancy> vacancies = new TreeMap<>();
        for (Skill skill : getSkill()) {
            if (skill.isRequest()) {
                trueskill++;
                for (Skill skillemp : skills) {
                    if (skill.getName().equals(skillemp.getName()) &&
                            skill.getLevel() <= skillemp.getLevel() && skill.isRequest()) {
                        trueskillsize++;
                    }
                }
            }
        }
        if (trueskillsize == trueskill) {
            trueskillsize += 1;
            vacancies.put(trueskillsize, this);
            trueskillsize = 0;
        }
        if (trueskillsize > 0) {
            vacancies.put(trueskillsize + vacancyposition, this);
            vacancyposition += 0.01;
        }
        return vacancies;
    }

    public boolean isAppropriateOneSkillsLevel(Set<Skill> skills) {
        for (Skill skillemployer : skill) {
            if (skillemployer.isRequest()) {
                for (Skill skillemployee : skills) {
                    if (skillemployee.getName().equals(skillemployer.getName()) &&
                            skillemployee.getLevel() >= skillemployer.getLevel()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
