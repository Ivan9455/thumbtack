package net.thumbtack.school.hiring.user;


import net.thumbtack.school.hiring.error.ErrorCode;
import net.thumbtack.school.hiring.error.ErrorException;

import java.util.Objects;

public abstract class User {
    private String lastName;
    private String firstName;
    private String patronymicname;
    private String email;
    private String id;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws ErrorException {
        if (lastName == null || lastName.equals("")) {
            throw new ErrorException(ErrorCode.USER_WRONG_LASTNAME);
        } else {
            this.lastName = lastName;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws ErrorException {
        if (firstName == null || firstName.equals("")) {
            throw new ErrorException(ErrorCode.USER_WRONG_FIRSTNAME);
        } else {
            this.firstName = firstName;
        }
    }

    public String getPatronymicname() {
        return patronymicname;
    }

    public void setPatronymicname(String patronymicname) {
        this.patronymicname = patronymicname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ErrorException {
        if (email == null || email.equals("")) {
            throw new ErrorException(ErrorCode.USER_WRONG_EMAIL);
        } else {
            this.email = email;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String lastName, String firstName, String email, String id) throws ErrorException {
        setLastName(lastName);
        setFirstName(firstName);
        setEmail(email);
        this.id = id;
    }

    public User(String lastName, String firstName, String patronymicname, String email,String id) throws ErrorException {
        this(lastName, firstName, email,id);
        this.patronymicname = patronymicname;
    }

    public User(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(lastName, user.lastName) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(patronymicname, user.patronymicname) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymicname, email);
    }
}
