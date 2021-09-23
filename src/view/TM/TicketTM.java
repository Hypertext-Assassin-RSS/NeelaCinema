package view.TM;

import java.util.Objects;

public class TicketTM {
    private double price;
    private String type;
    private String location;

    public TicketTM() {
    }

    public TicketTM(double price, String type, String location) {
        this.setPrice(price);
        this.setType(type);
        this.setLocation(location);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "TicketTM{" +
                "price=" + price +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketTM ticketTM = (TicketTM) o;
        return Double.compare(ticketTM.price, price) == 0 && Objects.equals(type, ticketTM.type) && Objects.equals(location, ticketTM.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, type, location);
    }
}
