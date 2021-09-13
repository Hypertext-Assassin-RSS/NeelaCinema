package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_Connection {

    private static db_Connection dbConnection=null;
    private Connection connection;


    private db_Connection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/Neela",
                "root",
                "1234");
    }


    public static db_Connection getInstance() throws ClassNotFoundException, SQLException {
        if (dbConnection==null){
            dbConnection= new db_Connection();
        }
        return dbConnection;


    }

    public Connection getConnection(){
        return connection;
    }
}

