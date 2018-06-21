package net.thumbtack.school.hiring.user;

import net.thumbtack.school.hiring.Skill;
import net.thumbtack.school.hiring.error.ErrorCode;
import net.thumbtack.school.hiring.error.ErrorException;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class TestSkill {
    @Test
    public void testSkill() {
        try {
            Skill skill = new Skill(null,3,true);
            fail();
        } catch (ErrorException e) {
            assertEquals(ErrorCode.USER_WRONG_SKILL_NAME,e.getErrorCode());
        }
        try {
            Skill skill = new Skill("",3,true);
            fail();
        } catch (ErrorException e) {
            assertEquals(ErrorCode.USER_WRONG_SKILL_NAME,e.getErrorCode());
        }
        try {
            Skill skill = new Skill("Java",6,true);
        } catch (ErrorException e) {
            assertEquals(ErrorCode.USER_WRONG_SKILL_LEVEL,e.getErrorCode());
        }
        try {
            Skill skill = new Skill("Java",0,true);
        } catch (ErrorException e) {
            assertEquals(ErrorCode.USER_WRONG_SKILL_LEVEL,e.getErrorCode());
        }
    }
}

