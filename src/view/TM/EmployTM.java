package view.TM;

import java.util.Objects;

public class EmployTM {
    private String nicNo;
    private String name;
    private String contact;

    public EmployTM() {
    }

    public EmployTM(String nicNo, String name, String contact) {
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
        return "EmployTM{" +
                "nicNo='" + nicNo + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployTM employTM = (EmployTM) o;
        return Objects.equals(nicNo, employTM.nicNo) && Objects.equals(name, employTM.name) && Objects.equals(contact, employTM.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nicNo, name, contact);
    }
}
