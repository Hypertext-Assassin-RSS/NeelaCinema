package controller;

import db.DbConnection;
import model.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Film_Controller {
    public boolean saveFilm (Film f1) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO FIlm VALUES (?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setObject(1,f1.getFilmName());
        stm.setObject(2,f1.getStudioNo());
        stm.setObject(3,f1.getShowTime());
        stm.setObject(4,f1.getStartDate());
        stm.setObject(5,f1.getEndDate());

        return  stm.executeUpdate() > 0;
    }



    public List<String> getFilmName() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DbConnection.getInstance().getConnection().prepareStatement("SELECT  * FROM FIlm ").executeQuery();
        List<String> filmName = new ArrayList<>();
        while (resultSet.next()){
         filmName.add(resultSet.getString(1));
        }
        return filmName;
    }
}
