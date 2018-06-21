package net.thumbtack.school.hiring.error;

public enum ErrorCode {
    USER_WRONG_FIRSTNAME("wrong fio firstname "),
    USER_WRONG_LASTNAME("wrong fio lastname "),
    USER_WRONG_EMAIL("wrong fio email "),
    USER_WRONG_TITLECOMPANI("wrong titleCompani"),
    USER_WRONG_ADRESS("wrong adress"),
    USER_WRONG_VACANCY_POST("wrong vacancy post"),
    USER_WRONG_VACANCY_SALARY("wrong vacancy salary"),
    USER_WRONG_VACANCY_SKILL("wrong vacancy skill"),
    USER_WRONG_SKILL_NAME("wrong skill name"),
    USER_WRONG_SKILL_LEVEL("wrong skill level number >=1 and number<=5"),
    USER_WRONG_LOGIN("wrong login"),
    USER_WRONG_PASSWORD("wrong password"),
    WRONG_LOGIN("wrong the user with such login already exists"),
    WRONG_EMAIL("wrong the user with such mail already exists"),
    SERVER_WRONG_COMMAND_LOAD("wrong command load"),
    SERVER_WRONG_COMMAND_SAVE("wrong command save"),
    WRONG_VACANCY("wrong wacancy");
    private String errorString;

    public String getErrorString() {
        return errorString;
    }

    ErrorCode(String errorString) {
        this.errorString = errorString;
    }
}
