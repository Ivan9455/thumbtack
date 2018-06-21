package net.thumbtack.school.hiring.user.employer;

import net.thumbtack.school.hiring.user.Employer;
import net.thumbtack.school.hiring.error.ErrorCode;
import net.thumbtack.school.hiring.error.ErrorException;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class TestEmployer {
    @Test
    public void TestEmployer(){
        try{
            Employer employer = new Employer("Падерин","Иван","paderin@mail.ru","","omsk","1");
            fail();
        }
        catch (ErrorException e){
            assertEquals(ErrorCode.USER_WRONG_TITLECOMPANI,e.getErrorCode());
        }
        try{
            Employer employer = new Employer("Падерин","Иван","paderin@mail.ru","app",null,"1");
            fail();
        }
        catch (ErrorException e){
            assertEquals(ErrorCode.USER_WRONG_ADRESS,e.getErrorCode());
        }
    }
}
