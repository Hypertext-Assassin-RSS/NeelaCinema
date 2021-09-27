package model;

import java.util.Objects;

public class Parking {
    private String nicNo;
    private String name;
    private String contact;
    private String vehicleNo;
    private String vehicleType;
    private int parkingNo;

    public Parking() {
    }

    public Parking(String nicNo, String name, String contact, String vehicleNo, String vehicleType, int parkingNo) {
        this.setNicNo(nicNo);
        this.setName(name);
        this.setContact(contact);
        this.setVehicleNo(vehicleNo);
        this.setVehicleType(vehicleType);
        this.setParkingNo(parkingNo);
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

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(int parkingNo) {
        this.parkingNo = parkingNo;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "nicNo='" + nicNo + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", parkingNo=" + parkingNo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return parkingNo == parking.parkingNo && Objects.equals(nicNo, parking.nicNo) && Objects.equals(name, parking.name) && Objects.equals(contact, parking.contact) && Objects.equals(vehicleNo, parking.vehicleNo) && Objects.equals(vehicleType, parking.vehicleType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nicNo, name, contact, vehicleNo, vehicleType, parkingNo);
    }
}
