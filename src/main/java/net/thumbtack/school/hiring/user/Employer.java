package net.thumbtack.school.hiring.user;

import net.thumbtack.school.hiring.error.ErrorCode;
import net.thumbtack.school.hiring.error.ErrorException;

import java.util.Objects;


public class Employer extends User {
    private String companytitle;
    private String address;

    public String getCompanytitle() {
        return companytitle;
    }

    public void setCompanytitle(String titleCompani) throws ErrorException {
        if (titleCompani == null || titleCompani.equals("")) {
            throw new ErrorException(ErrorCode.USER_WRONG_TITLECOMPANI);
        } else {
            this.companytitle = titleCompani;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) throws ErrorException {
        if (adress == null || adress.equals("")) {
            throw new ErrorException(ErrorCode.USER_WRONG_ADRESS);
        } else {
            this.address = adress;
        }
    }

    public Employer(){

    }

    public Employer(String lastName, String firstName, String patronymicName,
                    String email, String companytitle, String address,String id) throws ErrorException {
        super(lastName, firstName, patronymicName, email,id);
        setCompanytitle(companytitle);
        setAddress(address);
    }

    public Employer(String lastName, String firstName,
                    String email, String companytitle, String address,String id) throws ErrorException {
        super(lastName, firstName, email,id);
        setCompanytitle(companytitle);
        setAddress(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        if (!super.equals(o)) return false;
        Employer employer = (Employer) o;
        return Objects.equals(companytitle, employer.companytitle) &&
                Objects.equals(address, employer.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), companytitle, address);
    }
}
