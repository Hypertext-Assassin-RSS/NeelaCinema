package controller;

import db.DbConnection;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
    public ArrayList<Employ> getAllEmploy() throws SQLException, ClassNotFoundException {
        ArrayList<Employ> employs = new ArrayList<>();
       ResultSet resultSet = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Employ;").executeQuery();

       while (resultSet.next()){
            employs.add(new Employ(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
                    )
            );
       }
        return employs;
    }

    public ArrayList<Investor> getAllInvestor() throws SQLException, ClassNotFoundException {
        ArrayList<Investor> investors = new ArrayList<>();
        ResultSet resultSet = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Employ;").executeQuery();

        while (resultSet.next()){
            investors.add(new Investor(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    )
            );
        }
        return investors;
    }

    public ArrayList<Owner> getAllOwner() throws SQLException, ClassNotFoundException {
        ArrayList<Owner> owners = new ArrayList<>();
        ResultSet resultSet = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Employ;").executeQuery();

        while (resultSet.next()){
            owners.add(new Owner(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    )
            );
        }
        return owners;
    }

    public ArrayList<Studio> getAllStudio() throws SQLException, ClassNotFoundException {
        ArrayList<Studio> studios = new ArrayList<>();
        ResultSet resultSet = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Employ;").executeQuery();

        while (resultSet.next()){
            studios.add(new Studio(
                            resultSet.getString(1),
                            resultSet.getString(2)
                    )
            );
        }
        return studios;
    }

    public boolean save_Employ(Employ em) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO Employ VALUES(?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setObject(1,em.getNicNo());
        stm.setObject(2,em.getName());
        stm.setObject(3,em.getContact());
        stm.setObject(4,em.getUser());
        stm.setObject(5,em.getPassword());


        return  stm.executeUpdate() > 0;
    }
    public boolean save_Investor(Investor in) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO Investor VALUES(?,?,?)";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setObject(1,in.getNicNo());
        stm.setObject(2,in.getName());
        stm.setObject(3,in.getContact());


        return  stm.executeUpdate() > 0;
    }
    public boolean save_studio_Details(Studio st) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO Studio VALUES(?,?)";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setObject(1,st.getStudioName());
        stm.setObject(2,st.getStudionNo());



        return  stm.executeUpdate() > 0;
    }
    public boolean save_Owner_Details(Owner ow) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO Owner VALUES(?,?,?)";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setObject(1,ow.getNicNo());
        stm.setObject(2,ow.getName());
        stm.setObject(3,ow.getContact());


        return  stm.executeUpdate() > 0;
    }
}
