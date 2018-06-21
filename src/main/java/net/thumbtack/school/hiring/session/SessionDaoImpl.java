package net.thumbtack.school.hiring.session;

import net.thumbtack.school.hiring.database.DataBase;
import net.thumbtack.school.hiring.error.ErrorCode;
import net.thumbtack.school.hiring.error.ErrorException;

import java.util.Set;

public class SessionDaoImpl implements SessionDao {

    @Override
    public void insert(Session session) throws ErrorException {
        for (Session sessions : DataBase.sessiondb) {
            if (sessions.getLogin().equals(session.getLogin())) {
                throw new ErrorException(ErrorCode.WRONG_LOGIN);
            }
        }
        DataBase.sessiondb.add(session);
    }

    @Override
    public Set<Session> getSessions() {
        return DataBase.sessiondb;
    }
}
