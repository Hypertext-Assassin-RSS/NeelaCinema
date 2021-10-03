package model;

import java.util.Objects;

public class Owner {
    private String nicNo;
    private String name;
    private String contact;

    public Owner() {
    }

    public Owner(String nicNo, String name, String contact) {
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

    @Override
    public String toString() {
        return "Owner{" +
                "nicNo='" + nicNo + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(nicNo, owner.nicNo) && Objects.equals(name, owner.name) && Objects.equals(contact, owner.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nicNo, name, contact);
    }
}
