package view.TM;

import java.util.Objects;

public class OwnerTM {
    private String nicNo;
    private String name;
    private String contact;

    public OwnerTM() {
    }

    public OwnerTM(String nicNo, String name, String contact) {
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
        return "OwnerTM{" +
                "nicNo='" + nicNo + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerTM ownerTM = (OwnerTM) o;
        return Objects.equals(nicNo, ownerTM.nicNo) && Objects.equals(name, ownerTM.name) && Objects.equals(contact, ownerTM.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nicNo, name, contact);
    }
}
