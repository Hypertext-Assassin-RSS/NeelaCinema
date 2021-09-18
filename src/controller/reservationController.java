package controller;

import db.DbConnection;

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
}
