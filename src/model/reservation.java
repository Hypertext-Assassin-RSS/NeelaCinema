package model;

public class reservation {
    private String cusNicNo;
    private String cusName;
    private String cusContact;
    private String filmNo;
    private String filmName;
    private String ticketQTY;
    private String packageNo;
    private String packageName;
    private String packageDescription;
    private double packagePrice;

    public reservation() {
    }

    public reservation(String cusNicNo, String cusName, String cusContact, String filmNo, String filmName, String ticketQTY, String packageNo, String packageName, String packageDescription, double packagePrice) {
        this.setCusNicNo(cusNicNo);
        this.setCusName(cusName);
        this.setCusContact(cusContact);
        this.setFilmNo(filmNo);
        this.setFilmName(filmName);
        this.setTicketQTY(ticketQTY);
        this.setPackageNo(packageNo);
        this.setPackageName(packageName);
        this.setPackageDescription(packageDescription);
        this.setPackagePrice(packagePrice);
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

    public String getFilmNo() {
        return filmNo;
    }

    public void setFilmNo(String filmNo) {
        this.filmNo = filmNo;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getTicketQTY() {
        return ticketQTY;
    }

    public void setTicketQTY(String ticketQTY) {
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

    @Override
    public String toString() {
        return "reservation{" +
                "cusNicNo='" + cusNicNo + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusContact='" + cusContact + '\'' +
                ", filmNo='" + filmNo + '\'' +
                ", filmName='" + filmName + '\'' +
                ", ticketQTY='" + ticketQTY + '\'' +
                ", packageNo='" + packageNo + '\'' +
                ", packageName='" + packageName + '\'' +
                ", packageDescription='" + packageDescription + '\'' +
                ", packagePrice=" + packagePrice +
                '}';
    }
}
