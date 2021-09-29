package controller;

import db.DbConnection;
import model.Parking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class parkingController {
    public boolean  saveParking (Parking p1) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO Parking VALUES(?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(query);

        stm.setObject(1,p1.getNicNo());
        stm.setObject(2,p1.getName());
        stm.setObject(3,p1.getContact());
        stm.setObject(4,p1.getVehicleNo());
        stm.setObject(5,p1.getVehicleType());
        stm.setObject(6,p1.getVehicleNo());

        return  stm.executeUpdate() > 0;
    }
}
