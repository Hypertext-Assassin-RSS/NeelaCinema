package model;

import java.util.Objects;

public class Employ {
    private String nicNo;
    private String name;
    private String contact;
    private String user;
    private String password;

    public Employ() {
    }

    public Employ(String nicNo, String name, String contact, String user, String password) {
        this.setNicNo(nicNo);
        this.setName(name);
        this.setContact(contact);
        this.setUser(user);
        this.setPassword(password);
    }

    public Employ(String nicNo, String name, String contact) {
        this.setNicNo(nicNo);
        this.setName(name);
        this.setContact(contact);
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "nicNo='" + nicNo + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employ employ = (Employ) o;
        return Objects.equals(nicNo, employ.nicNo) && Objects.equals(name, employ.name) && Objects.equals(contact, employ.contact) && Objects.equals(user, employ.user) && Objects.equals(password, employ.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nicNo, name, contact, user, password);
    }
}