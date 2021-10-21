package model;

import java.util.Objects;

public class reservation {
    private String cusNicNo;
    private String cusName;
    private String cusContact;
    private String filmName;
    private Integer ticketQTY;
    private String packageNo;
    private String packageName;
    private String packageDescription;
    private double packagePrice;
    private String reservationNo;

    public reservation() {
    }

    public reservation(String cusNicNo, String filmName, String packageNo, int ticketQTY) {
        this.setCusNicNo(cusNicNo);
        this.setFilmName(filmName);
        this.setPackageNo(packageNo);
        this.setTicketQTY(ticketQTY);
    }

    public reservation(String cusNicNo, String cusName, String cusContact, String filmName, Integer ticketQTY, String packageNo, String packageName, String packageDescription, double packagePrice, String reservationNo) {
        this.setCusNicNo(cusNicNo);
        this.setCusName(cusName);
        this.setCusContact(cusContact);
        this.setFilmName(filmName);
        this.setTicketQTY(ticketQTY);
        this.setPackageNo(packageNo);
        this.setPackageName(packageName);
        this.setPackageDescription(packageDescription);
        this.setPackagePrice(packagePrice);
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

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getTicketQTY() {
        return ticketQTY;
    }

    public void setTicketQTY(Integer ticketQTY) {
        this.ticketQTY = ticketQTY;
    }

    public String getPackageNo() {
        return packageNo;
    }

    public void setPackageNo(String packageNo) {
        this.packageNo = packageNo;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(double packagePrice) {
        this.packagePrice = packagePrice;
    }

    public String getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(String reservationNo) {
        this.reservationNo = reservationNo;
    }

    @Override
    public String toString() {
        return "reservation{" +
                "cusNicNo='" + cusNicNo + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusContact='" + cusContact + '\'' +
                ", filmName='" + filmName + '\'' +
                ", ticketQTY=" + ticketQTY +
                ", packageNo='" + packageNo + '\'' +
                ", packageName='" + packageName + '\'' +
                ", packageDescription='" + packageDescription + '\'' +
                ", packagePrice=" + packagePrice +
                ", reservationNo='" + reservationNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        reservation that = (reservation) o;
        return Double.compare(that.packagePrice, packagePrice) == 0 && Objects.equals(cusNicNo, that.cusNicNo) && Objects.equals(cusName, that.cusName) && Objects.equals(cusContact, that.cusContact) && Objects.equals(filmName, that.filmName) && Objects.equals(ticketQTY, that.ticketQTY) && Objects.equals(packageNo, that.packageNo) && Objects.equals(packageName, that.packageName) && Objects.equals(packageDescription, that.packageDescription) && Objects.equals(reservationNo, that.reservationNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cusNicNo, cusName, cusContact, filmName, ticketQTY, packageNo, packageName, packageDescription, packagePrice, reservationNo);
    }


}