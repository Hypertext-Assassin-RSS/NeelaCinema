package controller;

import db.DbConnection;
import model.ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tickets_Controller {

    public boolean saveTicket(ticket t1) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO Tickets VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setObject(1,t1.getPrice());
        statement.setObject(2,t1.getType());
        statement.setObject(3,t1.getLocation());

        return  statement.executeUpdate() > 0;
    }
}
