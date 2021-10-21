package view.TM;

import java.util.Objects;

public class ReservationTM {
    private String cusNicNo;
    private String filmName;
    private String packageNo;
    private Integer ticketQTY;

    public ReservationTM() {
    }

    public ReservationTM(String cusNicNo, String filmName, String packageNo, Integer ticketQTY) {
        this.setCusNicNo(cusNicNo);
        this.setFilmName(filmName);
        this.setPackageNo(packageNo);
        this.setTicketQTY(ticketQTY);
    }


    public String getCusNicNo() {
        return cusNicNo;
    }

    public void setCusNicNo(String cusNicNo) {
        this.cusNicNo = cusNicNo;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getPackageNo() {
        return packageNo;
    }

    public void setPackageNo(String packageNo) {
        this.packageNo = packageNo;
    }

    public Integer getTicketQTY() {
        return ticketQTY;
    }

    public void setTicketQTY(Integer ticketQTY) {
        this.ticketQTY = ticketQTY;
    }

    @Override
    public String toString() {
        return "ReservationTM{" +
                "cusNicNo='" + cusNicNo + '\'' +
                ", filmName='" + filmName + '\'' +
                ", packageNo='" + packageNo + '\'' +
                ", ticketQTY=" + ticketQTY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationTM that = (ReservationTM) o;
        return Objects.equals(cusNicNo, that.cusNicNo) && Objects.equals(filmName, that.filmName) && Objects.equals(packageNo, that.packageNo) && Objects.equals(ticketQTY, that.ticketQTY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cusNicNo, filmName, packageNo, ticketQTY);
    }
}

