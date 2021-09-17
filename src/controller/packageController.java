package controller;

import db.DbConnection;
import model.Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class packageController {
    public List<String> getPackageNo() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Package").executeQuery();
        List<String> packageNo = new ArrayList<>();
        while (rst.next()) {
            packageNo.add(rst.getString(1));
        }
        return packageNo;
    }

    public boolean savePackage(Package p) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO Package VALUES(?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setObject(1, p.getPackageId());
        stm.setObject(2, p.getPackageName());
        stm.setObject(3, p.getPackageDetails());
        stm.setObject(4, p.getPackagePrice());


        return stm.executeUpdate() > 0;
    }
    public Package serchPackage(String package_id) throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Package WHERE package_id ='" + package_id + "'").executeQuery();
        if (rst.next()){
            return new Package(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4)
            );
        }else {
            return null;
        }
    }
}
