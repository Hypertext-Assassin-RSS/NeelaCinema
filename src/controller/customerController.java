package controller;

import db.DbConnection;
import model.customer_Details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class customerController {
    public List<String> getNicNo() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Customer_Detail").executeQuery();
        List<String> nicNo = new ArrayList<>();
        while (rst.next()) {
            nicNo.add(rst.getString(1));
        }
        return nicNo;
    }


    public boolean save_Customer_Details(customer_Details c1) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO Customer_Detail VALUES(?,?,?)";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setObject(1,c1.getId());
        stm.setObject(2,c1.getName());
        stm.setObject(3,c1.getContact());


        return  stm.executeUpdate() > 0;
    }
}
