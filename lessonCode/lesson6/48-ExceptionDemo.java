// nested exception
package net.thumbtack.lessons;

enum ErrorCode {

    WRONG_FIRSTNAME("Wrong first name %s"),
    WRONG_LASTNAME("Wrong last name %s"),
    WRONG_LOGIN("Wrong login %s"),
    WRONG_PASSWORD("Wrong password");

    private String message;

    private ErrorCode(String message) {
        this.message = message;
    }

    public String getErrorString() {
        return message;
    }
}

class PersonException extends Exception {

    public PersonException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getErrorString(), cause);
    }

    public PersonException(ErrorCode errorCode) {
        super(errorCode.getErrorString());
    }

    public PersonException(ErrorCode errorCode, String param) {
        super(String.format(errorCode.getErrorString(), param));
    }

}

class Person {

    private static final int MIN_PASSWORD_LEN = 8;
    private static final int MIN_LOGIN_LEN = 6;

    private String firstName;
    private String lastName;
    private String login;
    private String password;

    public Person(String firstName, String lastName, String login, String password) throws PersonException {
        super();
        setFirstName(firstName);
        setLastName(lastName);
        setLogin(login);
        setPassword(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws PersonException {
        checkFirstName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws PersonException {
        checkLastName(lastName);
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws PersonException {
        checkLogin(login);
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws PersonException {
        checkPassword(password);
        this.password = password;
    }

    private static void checkFirstName(String firstName) throws PersonException {
        if(firstName == null || firstName.length() == 0)
            throw new PersonException(ErrorCode.WRONG_FIRSTNAME, firstName);
    }

    private static void checkLastName(String lastName) throws PersonException {
        if(lastName == null || lastName.length() == 0 )
            throw new PersonException(ErrorCode.WRONG_LASTNAME, lastName);
    }

    private static void checkLogin(String login) throws PersonException {
        if(login == null || login.length() < MIN_LOGIN_LEN)
            throw new PersonException(ErrorCode.WRONG_LOGIN, login);
    }

    private static void checkPassword(String password) throws PersonException {
        if(password == null || password.length() < MIN_PASSWORD_LEN)
            throw new PersonException(ErrorCode.WRONG_PASSWORD);
    }
}



public class ExceptionDemo {

    public static void main(String[] args) {

        try {
            Person misha = new Person(null, "Иванов", "misha_belkin", "123456");
        }
        catch (PersonException e) {
            System.out.println(e.getMessage());
        }

        try {
            Person misha = new Person("Иван", "", "misha_belkin", "123456");
        }
        catch (PersonException e) {
            System.out.println(e.getMessage());
        }

        try {
            Person misha = new Person("Миша", "Белкин", "misha_belkin", "12345678");
        }
        catch (PersonException e) {
            System.out.println(e.getMessage());
        }

        try {
            Person vasya = new Person("Вася", "Пупкин", "vasya_pupkin", "123");
        }
        catch (PersonException e) {
            System.out.println(e.getMessage());
        }

        try {
            Person petya = new Person("Петя", "Губкин", "petya", "123456");
        }
        catch (PersonException e) {
            System.out.println(e.getMessage());
        }
    }
}
