package view.TM;

public class ParkingTM {
    private String name;
    private String contact;
    private String vehicleNo;
    private String vehicleType;
    private int parkingNo;

    public ParkingTM() {
    }

    public ParkingTM(String name, String contact, String vehicleNo, String vehicleType, int parkingNo) {
        this.setName(name);
        this.setContact(contact);
        this.setVehicleNo(vehicleNo);
        this.setVehicleType(vehicleType);
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
        return "ParkingTM{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", parkingNo=" + parkingNo +
                '}';
    }
}
