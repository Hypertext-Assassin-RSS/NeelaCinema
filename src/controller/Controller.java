package controller;

import db.DbConnection;
import model.*;
import model.Package;
import view.TM.FullReservatonTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
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

    public boolean saveDay(Day d) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();

        String query ="INSERT INTO Day VALUES(?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setObject(1,d.getYear());
        statement.setObject(2,d.getMonth());
        statement.setObject(3,d.getDay());
        statement.setObject(4,d.getFilmName());
        statement.setObject(5,d.getShowTime());
        statement.setObject(6,d.getStartDate());
        statement.setObject(7,d.getEndDate());

        return statement.executeUpdate() > 0;
    }





    public boolean save_Customer_Details(customer_Details c1) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO Customer_Detail VALUES(?,?,?)";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setObject(1, c1.getId());
        stm.setObject(2, c1.getName());
        stm.setObject(3, c1.getContact());


        return stm.executeUpdate() > 0;
    }

    public customer_Details searchCustomer(String nicNo) throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT  * FROM Customer_Detail WHERE cusNicNo ='" + nicNo + "'").executeQuery();
        if (rst.next()) {
            return new customer_Details(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
        } else {
            return null;
        }
    }


        public ArrayList<Employ> getAllEmploy () throws SQLException, ClassNotFoundException {
            ArrayList<Employ> employs = new ArrayList<>();
            ResultSet resultSet = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Employ;").executeQuery();

            while (resultSet.next()) {
                employs.add(new Employ(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3)
                        )
                );
            }
            return employs;
        }

        public ArrayList<Investor> getAllInvestor () throws SQLException, ClassNotFoundException {
            ArrayList<Investor> investors = new ArrayList<>();
            ResultSet resultSet = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Employ;").executeQuery();

            while (resultSet.next()) {
                investors.add(new Investor(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3)
                        )
                );
            }
            return investors;
        }

        public ArrayList<Owner> getAllOwner () throws SQLException, ClassNotFoundException {
            ArrayList<Owner> owners = new ArrayList<>();
            ResultSet resultSet = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Employ;").executeQuery();

            while (resultSet.next()) {
                owners.add(new Owner(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3)
                        )
                );
            }
            return owners;
        }

        public ArrayList<Studio> getAllStudio () throws SQLException, ClassNotFoundException {
            ArrayList<Studio> studios = new ArrayList<>();
            ResultSet resultSet = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Employ;").executeQuery();

            while (resultSet.next()) {
                studios.add(new Studio(
                                resultSet.getString(1),
                                resultSet.getString(2)
                        )
                );
            }
            return studios;
        }
    public ArrayList<reservation> getAllReservations() throws SQLException, ClassNotFoundException {
        ArrayList<reservation> reservations = new ArrayList<>();
        ResultSet resultSet = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM reservationdetails").executeQuery();

        while(resultSet.next()) {
            reservations.add(new reservation(
                    resultSet.getString(1),
                    resultSet.getString(4),
                    resultSet.getString(6),
                    resultSet.getInt(5)
            ));
        }
        return reservations;
    }
    public ArrayList<customer_Details> getAllCustomerDetails() throws SQLException, ClassNotFoundException {
        ArrayList<customer_Details> customer_details = new ArrayList<>();
        ResultSet resultSet = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM customer_detail").executeQuery();

        while (resultSet.next()) {
            customer_details.add(new customer_Details(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            ));
        }
        return customer_details;

    }
    public ArrayList<FullReservation> getAllFullReservations() throws SQLException, ClassNotFoundException {
        ArrayList<FullReservation> reservations = new ArrayList<>();
        ResultSet resultSet = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM reservation r,customer_detail c where r.customer_id=c.cusNicNo").executeQuery();

        while(resultSet.next()){
            reservations.add(new FullReservation(
               resultSet.getString(1),
               resultSet.getString(2),
               resultSet.getString(3),
               resultSet.getString(4),
               resultSet.getString(5),
               resultSet.getString(6)
            ));
        }
        return  reservations;


    }

        public boolean save_Employ (Employ em) throws SQLException, ClassNotFoundException {
            Connection con = DbConnection.getInstance().getConnection();

            String query = "INSERT INTO Employ VALUES(?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setObject(1, em.getNicNo());
            stm.setObject(2, em.getName());
            stm.setObject(3, em.getContact());
            stm.setObject(4, em.getUser());
            stm.setObject(5, em.getPassword());


            return stm.executeUpdate() > 0;
        }
        public boolean save_Investor (Investor in) throws SQLException, ClassNotFoundException {
            Connection con = DbConnection.getInstance().getConnection();

            String query = "INSERT INTO Investor VALUES(?,?,?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setObject(1, in.getNicNo());
            stm.setObject(2, in.getName());
            stm.setObject(3, in.getContact());


            return stm.executeUpdate() > 0;
        }
        public boolean save_studio_Details (Studio st) throws SQLException, ClassNotFoundException {
            Connection con = DbConnection.getInstance().getConnection();

            String query = "INSERT INTO Studio VALUES(?,?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setObject(1, st.getStudioName());
            stm.setObject(2, st.getStudionNo());


            return stm.executeUpdate() > 0;
        }
        public boolean save_Owner_Details (Owner ow) throws SQLException, ClassNotFoundException {
            Connection con = DbConnection.getInstance().getConnection();

            String query = "INSERT INTO Owner VALUES(?,?,?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setObject(1, ow.getNicNo());
            stm.setObject(2, ow.getName());
            stm.setObject(3, ow.getContact());


            return stm.executeUpdate() > 0;
        }


}

