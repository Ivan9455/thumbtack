package net.thumbtack.school.hiring.session;

import net.thumbtack.school.hiring.error.ErrorCode;
import net.thumbtack.school.hiring.error.ErrorException;

import java.util.Objects;
import java.util.UUID;

public class Session {
    private String login;
    private String password;
    private String token;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws ErrorException {
        if (login == null || login.equals("") || login.length() <= 4 || login.length() >= 12) {
            throw new ErrorException(ErrorCode.USER_WRONG_LOGIN);
        } else {
            this.login = login;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws ErrorException {
        if (password == null || password.equals("") || password.length() <= 6 || password.length() >= 20) {
            throw new ErrorException(ErrorCode.USER_WRONG_PASSWORD);
        } else {
            this.password = password;
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Session(String login, String password) throws ErrorException {//регистрация и авторизация
        setLogin(login);
        setPassword(password);
        this.token = String.valueOf(new UUID(0, 64).randomUUID());
    }

    public Session(String login, String password, String token) {//заргузка из json
        this.login = login;
        this.password = password;
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Session)) return false;
        Session session = (Session) o;
        return Objects.equals(login, session.login) &&
                Objects.equals(password, session.password) &&
                Objects.equals(token, session.token);
    }

    @Override
    public int hashCode() {

        return Objects.hash(login, password, token);
    }
}
