package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.ticket;
import view.TM.TicketTM;

import java.sql.SQLException;

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
