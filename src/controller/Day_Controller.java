package controller;

import db.DbConnection;
import model.Day;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Day_Controller {

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

}
