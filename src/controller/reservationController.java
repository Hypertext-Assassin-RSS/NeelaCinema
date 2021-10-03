package controller;

import db.DbConnection;
import model.customer_Details;
import model.reservation;
import model.reservstion_detail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class reservationController {


    public List<String> getPackageNo() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Package").executeQuery();
        List<String> packageNo = new ArrayList<>();
        while (rst.next()) {
            packageNo.add(rst.getString(1));
        }
        return packageNo;
    }
    public List<String> getNicNo() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Customer_Detail").executeQuery();
        List<String> nicNo = new ArrayList<>();
        while (rst.next()) {
            nicNo.add(rst.getString(1));
        }
        return nicNo;
    }

    public boolean saveReservation(reservation r) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO ReservationDetails VALUES  (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setObject(1,r.getCusNicNo());
        statement.setObject(2,r.getCusName());
        statement.setObject(3,r.getCusContact());
        statement.setObject(4,r.getFilmName());
        statement.setObject(5,r.getTicketQTY());
        statement.setObject(6,r.getPackageNo());
        statement.setObject(7,r.getPackageName());
        statement.setObject(8,r.getPackageDescription());
        statement.setObject(9,r.getPackagePrice());
        statement.setObject(10,r.getReservationNo());

        return  statement.executeUpdate() > 0;

    }
    public boolean saveRes(reservstion_detail res) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO reservation VALUES  (?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setObject(1,res.getReservationNo());
        statement.setObject(2,res.getCusNicNo());
        statement.setObject(3,res.getCusName());
        statement.setObject(4,res.getCusContact());
        statement.setObject(5,res.getDate());
        statement.setObject(6,res.getTime());

        return statement.executeUpdate() > 0;

    }

}
