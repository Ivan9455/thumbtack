package net.thumbtack.school.hiring;

import net.thumbtack.school.hiring.session.Session;
import net.thumbtack.school.hiring.error.ErrorCode;
import net.thumbtack.school.hiring.error.ErrorException;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class TestSession {

    @Test
    public void testSession(){
        try{
            Session log = new Session("","12345678");
            fail();
        }
        catch (ErrorException e){
            assertEquals(ErrorCode.USER_WRONG_LOGIN,e.getErrorCode());
        }
        try{
            Session log = new Session(null,"12345678");
            fail();
        }
        catch (ErrorException e){
            assertEquals(ErrorCode.USER_WRONG_LOGIN,e.getErrorCode());
        }
        try{
            Session log = new Session("www","12345678");
            fail();
        }
        catch (ErrorException e){
            assertEquals(ErrorCode.USER_WRONG_LOGIN,e.getErrorCode());
        }
        try{
            Session log = new Session("wwwwwwwwwwwwwwwwwwwwwwwwwwwwww","12345678");
            fail();
        }
        catch (ErrorException e){
            assertEquals(ErrorCode.USER_WRONG_LOGIN,e.getErrorCode());
        }
        try{
            Session log = new Session("login","");
            fail();
        }
        catch (ErrorException e){
            assertEquals(ErrorCode.USER_WRONG_PASSWORD,e.getErrorCode());
        }
        try{
            Session log = new Session("login",null);
            fail();
        }
        catch (ErrorException e){
            assertEquals(ErrorCode.USER_WRONG_PASSWORD,e.getErrorCode());
        }
        try{
            Session log = new Session("login","1234");
            fail();
        }
        catch (ErrorException e){
            assertEquals(ErrorCode.USER_WRONG_PASSWORD,e.getErrorCode());
        }
        try{
            Session log = new Session("login","11111111111111111111111111111111111111");
            fail();
        }
        catch (ErrorException e){
            assertEquals(ErrorCode.USER_WRONG_PASSWORD,e.getErrorCode());
        }

    }
}
