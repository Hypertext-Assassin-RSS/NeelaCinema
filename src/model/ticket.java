package model;

import java.util.Objects;

public class ticket {
    private double price;
    private String type;
    private String location;

    public ticket() {
    }

    public ticket(double price, String type, String location) {
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
        return "ticket{" +
                "price=" + price +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ticket ticket = (ticket) o;
        return Double.compare(ticket.price, price) == 0 && Objects.equals(type, ticket.type) && Objects.equals(location, ticket.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, type, location);
    }
}
