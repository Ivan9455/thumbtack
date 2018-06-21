package net.thumbtack.school.hiring.session;

import net.thumbtack.school.hiring.error.ErrorException;

import java.util.Set;

public interface SessionDao {
    void insert(Session session) throws ErrorException;

    Set<Session> getSessions();
}
