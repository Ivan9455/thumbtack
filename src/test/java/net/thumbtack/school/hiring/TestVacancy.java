package net.thumbtack.school.hiring;

import net.thumbtack.school.hiring.vacancy.Vacancy;
import net.thumbtack.school.hiring.error.ErrorCode;
import net.thumbtack.school.hiring.error.ErrorException;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static junit.framework.TestCase.*;


public class TestVacancy {
    @Test
    public void testVacancy() {
        try {
            Vacancy vacancy = new Vacancy("", "50000", true, "1");
            fail();
        } catch (ErrorException e) {
            assertEquals(ErrorCode.USER_WRONG_VACANCY_POST, e.getErrorCode());
        }
        try {
            Vacancy vacancy = new Vacancy(null, "50000", true, "1");//
            fail();
        } catch (ErrorException e) {
            assertEquals(ErrorCode.USER_WRONG_VACANCY_POST, e.getErrorCode());
        }
        try {
            Vacancy vacancy = new Vacancy("Java middle", "", true, "1");
            fail();
        } catch (ErrorException e) {
            assertEquals(ErrorCode.USER_WRONG_VACANCY_SALARY, e.getErrorCode());
        }
        try {
            Vacancy vacancy = new Vacancy("Java middle", null, true, "1");
            fail();
        } catch (ErrorException e) {
            assertEquals(ErrorCode.USER_WRONG_VACANCY_SALARY, e.getErrorCode());
        }

    }

    @Test
    public void testVacancy2() throws ErrorException {
        Set<Skill> skills1 = new LinkedHashSet<>();
        skills1.add(new Skill("java", 2, true));
        skills1.add(new Skill("git", 1, true));
        Vacancy test = new Vacancy("TEST", "1000$", true, skills1, "1");
    }

    @Test
    public void TestIsAppropriateSkillsLevelRequired() throws ErrorException {
        Set<Skill> skills1v1 = new LinkedHashSet<>();
        skills1v1.add(new Skill("php", 2, true));
        skills1v1.add(new Skill("git", 1, true));
        skills1v1.add(new Skill("mysql", 1, true));
        Vacancy vacancy1 = new Vacancy("junior php", "от 30000",
                true, skills1v1, "1");

//        Set<Skill> skills1v2 = new LinkedHashSet<>();
//        skills1v1.add(new Skill("php", 3, true));
//        skills1v1.add(new Skill("git", 2, true));
//        skills1v1.add(new Skill("mysql", 2, true));
//        Vacancy vacancy2 = new Vacancy("middle php", "от 40000",
//                true, skills1v2,"2");
//
//        Set<Skill> skills1v3 = new LinkedHashSet<>();
//        skills1v1.add(new Skill("php", 4, true));
//        skills1v1.add(new Skill("git", 2, true));
//        skills1v1.add(new Skill("mysql", 1, true));
//        Vacancy vacancy3 = new Vacancy("senior php", "от 50000",
//                true, skills1v3,"3");

        Set<Skill> list1 = new LinkedHashSet<>();
        list1.add(new Skill("php", 3, true));
        list1.add(new Skill("git", 3, true));
        list1.add(new Skill("mysql", 1, true));

        Set<Skill> list2 = new LinkedHashSet<>();
        list2.add(new Skill("php", 2, true));
        list2.add(new Skill("mysql", 1, true));
        assertTrue(vacancy1.isAppropriateSkillsLevelRequired(list1));
        assertFalse(vacancy1.isAppropriateSkillsLevelRequired(list2));
    }

    @Test
    public void TestIsAppropriateSkillsAllLevel() throws ErrorException {
        Set<Skill> skills1v2 = new LinkedHashSet<>();
        skills1v2.add(new Skill("php", 3, true));
        skills1v2.add(new Skill("git", 2, true));
        skills1v2.add(new Skill("mysql", 2, true));
        Vacancy vacancy2 = new Vacancy("middle php", "от 40000",
                true, skills1v2, "2");

        Set<Skill> list1 = new LinkedHashSet<>();
        list1.add(new Skill("php", 4, true));
        list1.add(new Skill("git", 4, true));
        list1.add(new Skill("mysql", 4, true));

        Set<Skill> list2 = new LinkedHashSet<>();
        list2.add(new Skill("php", 1, true));
        list2.add(new Skill("git", 1, true));
        list2.add(new Skill("mysql", 1, true));

        assertTrue(vacancy2.isAppropriateSkillsAllLevel(list1));
        assertTrue(vacancy2.isAppropriateSkillsAllLevel(list2));
    }
}




