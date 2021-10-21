package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.customer_Details;
import model.ticket;
import view.TM.Customer_Detail_TM;
import view.TM.TicketTM;

import java.sql.*;
import java.util.ArrayList;

public class Tickets_Controller {


    @FXML
    private TableView<TicketTM> tblTicket;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colFull;

    @FXML
    private TableColumn<?, ?> colHalf;

    public void initialize(){
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colFull.setCellValueFactory(new PropertyValueFactory<>("type"));
        colHalf.setCellValueFactory(new PropertyValueFactory<>("location"));
    }


    public boolean saveTicket(ticket t1) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO Tickets VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setObject(1,t1.getPrice());
        statement.setObject(2,t1.getType());
        statement.setObject(3,t1.getLocation());

        return  statement.executeUpdate() > 0;
    }
    private void loadAllTickets() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM tickets");
        ArrayList<ticket> tickets = new ArrayList<>();
        while (resultSet.next()){
            tickets.add(new ticket(
                    resultSet.getDouble(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            ));
            setTicketToTable(tickets);

        }
    }

    private void setTicketToTable(ArrayList<ticket> tickets) {
        ObservableList<TicketTM> obList = FXCollections.observableArrayList();
        tickets.forEach(ticket-> {
            obList.add(
                    new TicketTM(ticket.getPrice(), ticket.getType(), ticket.getLocation()));

        });
        tblTicket.setItems(obList);
    }
}
