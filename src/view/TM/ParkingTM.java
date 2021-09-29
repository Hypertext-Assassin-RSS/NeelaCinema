package view.TM;

import java.util.Objects;

public class ParkingTM {
    private String name;
    private String contact;
    private String vehicleNo;
    private int parkingNo;

    public ParkingTM() {
    }

    public ParkingTM(String name, String contact, String vehicleNo, int parkingNo) {
        this.setName(name);
        this.setContact(contact);
        this.setVehicleNo(vehicleNo);
        this.setParkingNo(parkingNo);
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

    public int getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(int parkingNo) {
        this.parkingNo = parkingNo;
    }

    @Override
    public String toString() {
        return "ParkingTM{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", parkingNo=" + parkingNo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingTM parkingTM = (ParkingTM) o;
        return parkingNo == parkingTM.parkingNo && Objects.equals(name, parkingTM.name) && Objects.equals(contact, parkingTM.contact) && Objects.equals(vehicleNo, parkingTM.vehicleNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, contact, vehicleNo, parkingNo);
    }
}

