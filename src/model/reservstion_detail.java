package model;

import java.util.Objects;

public class reservstion_detail {
    private String cusNicNo;
    private String cusName;
    private String cusContact;
    private String reservationNo;

    public reservstion_detail() {
    }

    public reservstion_detail(String cusNicNo, String cusName, String cusContact, String reservationNo) {
        this.setCusNicNo(cusNicNo);
        this.setCusName(cusName);
        this.setCusContact(cusContact);
        this.setReservationNo(reservationNo);
    }

    public String getCusNicNo() {
        return cusNicNo;
    }

    public void setCusNicNo(String cusNicNo) {
        this.cusNicNo = cusNicNo;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusContact() {
        return cusContact;
    }

    public void setCusContact(String cusContact) {
        this.cusContact = cusContact;
    }

    public String getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(String reservationNo) {
        this.reservationNo = reservationNo;
    }

    @Override
    public String toString() {
        return "reservstion_detail{" +
                "cusNicNo='" + cusNicNo + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusContact='" + cusContact + '\'' +
                ", reservationNo='" + reservationNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        reservstion_detail that = (reservstion_detail) o;
        return Objects.equals(cusNicNo, that.cusNicNo) && Objects.equals(cusName, that.cusName) && Objects.equals(cusContact, that.cusContact) && Objects.equals(reservationNo, that.reservationNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cusNicNo, cusName, cusContact, reservationNo);
    }
}
