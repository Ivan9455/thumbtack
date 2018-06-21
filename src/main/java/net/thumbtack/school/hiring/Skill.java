package net.thumbtack.school.hiring;

import net.thumbtack.school.hiring.error.ErrorCode;
import net.thumbtack.school.hiring.error.ErrorException;

public class Skill {
    private String name;
    private int level;
    private boolean request;

    public String getName() {
        return name;
    }

    public void setName(String name) throws ErrorException {
        if (name == null || name.equals("")) {
            throw new ErrorException(ErrorCode.USER_WRONG_SKILL_NAME);
        } else {
            this.name = name;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) throws ErrorException {
        if (level >= 1 && level <= 5) {
            this.level = level;
        } else {
            throw new ErrorException(ErrorCode.USER_WRONG_SKILL_LEVEL);
        }
    }

    public boolean isRequest() {
        return request;
    }

    public void setRequest(boolean request) {
        this.request = request;
    }

    public Skill(String name, int level, boolean request) throws ErrorException {
        setName(name);
        setLevel(level);
        this.request = request;
    }


}
