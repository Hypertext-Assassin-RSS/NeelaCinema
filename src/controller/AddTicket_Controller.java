package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.ticket;
import view.TM.TicketTM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddTicket_Controller {
    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtType;

    @FXML
    private TextField txtLocation;

    @FXML
    private TableView<TicketTM> tblTicket;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableColumn<?, ?> colLocation;

    public void initialize(){

        try {
            colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            colType.setCellValueFactory(new PropertyValueFactory<>("type"));
            colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));


            loadAllTickets();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void loadAllTickets() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();

        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Tickets";
        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<ticket>tickets = new ArrayList<>();
        while (resultSet.next()){
            tickets.add(new ticket(
                    resultSet.getDouble(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            ));
        }
        setTicketToTable(tickets);

    }

    private void setTicketToTable(ArrayList<ticket> tickets) {
        ObservableList<TicketTM> observableList = FXCollections.observableArrayList();
        tickets.forEach(ticket -> {
            observableList.add(new TicketTM(
                    ticket.getPrice(),
                    ticket.getType(),
                    ticket.getLocation()
            ));
        });
        tblTicket.setItems(observableList);
    }

    @FXML
    void saveTicket(MouseEvent event) throws SQLException, ClassNotFoundException {
    ticket t1 = new ticket(
            Double.parseDouble(txtPrice.getText()),
            txtType.getText(),
            txtLocation.getText()
    );
    if (saveTicketData(t1)){
        new Alert(Alert.AlertType.CONFIRMATION,"Saved...").show();
    }else{
        new Alert(Alert.AlertType.WARNING,"Try Again...").show();
    }
    }

    private boolean saveTicketData(ticket t1) throws SQLException, ClassNotFoundException {
        return  new Tickets_Controller().saveTicket(t1);
    }
}
