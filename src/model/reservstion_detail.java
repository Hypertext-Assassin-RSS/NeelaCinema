package model;

import java.util.Objects;

public class reservstion_detail {
    private String reservationNo;
    private String cusNicNo;
    private String cusName;
    private String cusContact;
    private String date;
    private String time;

    public reservstion_detail() {
    }

    public reservstion_detail(String reservationNo, String cusNicNo, String cusName, String cusContact, String date, String time) {
        this.setReservationNo(reservationNo);
        this.setCusNicNo(cusNicNo);
        this.setCusName(cusName);
        this.setCusContact(cusContact);
        this.setDate(date);
        this.setTime(time);
    }

    public String getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(String reservationNo) {
        this.reservationNo = reservationNo;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "reservstion_detail{" +
                "reservationNo='" + reservationNo + '\'' +
                ", cusNicNo='" + cusNicNo + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusContact='" + cusContact + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        reservstion_detail that = (reservstion_detail) o;
        return Objects.equals(reservationNo, that.reservationNo) && Objects.equals(cusNicNo, that.cusNicNo) && Objects.equals(cusName, that.cusName) && Objects.equals(cusContact, that.cusContact) && Objects.equals(date, that.date) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationNo, cusNicNo, cusName, cusContact, date, time);
    }
}