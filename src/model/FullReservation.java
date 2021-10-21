package model;

import java.util.Objects;

public class FullReservation {
    private String nicNo;
    private String reservationNo;
    private String name;
    private String contact;
    private String date;
    private String time;

    public FullReservation() {
    }

    public FullReservation(String nicNo, String reservationNo, String name, String contact, String date, String time) {
        this.setNicNo(nicNo);
        this.setReservationNo(reservationNo);
        this.setName(name);
        this.setContact(contact);
        this.setDate(date);
        this.setTime(time);
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(String reservationNo) {
        this.reservationNo = reservationNo;
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
    public String
    toString() {
        return "FullReservation{" +
                "nicNo='" + nicNo + '\'' +
                ", reservationNo='" + reservationNo + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullReservation that = (FullReservation) o;
        return Objects.equals(nicNo, that.nicNo) && Objects.equals(reservationNo, that.reservationNo) && Objects.equals(name, that.name) && Objects.equals(contact, that.contact) && Objects.equals(date, that.date) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nicNo, reservationNo, name, contact, date, time);
    }
}
