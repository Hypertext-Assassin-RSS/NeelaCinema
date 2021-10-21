package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.FullReservation;
import model.customer_Details;
import model.reservation;
import view.TM.Customer_Detail_TM;
import view.TM.FullReservatonTM;
import view.TM.ReservationTM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReservationCustomerController {

    @FXML
    private TableView<FullReservatonTM> tblReservation;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colReservationNo;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colTime;


    public void initialize() {
        colNic.setCellValueFactory(new PropertyValueFactory<>("nicNo"));
        colReservationNo.setCellValueFactory(new PropertyValueFactory<>("reservationNo"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));


        try {
            loadAllFullReservations();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void loadAllFullReservations() throws SQLException, ClassNotFoundException {
        ObservableList<FullReservatonTM> observableList = FXCollections.observableArrayList();
        for ( FullReservation tempReservation :new Controller().getAllFullReservations()
        ) {
            observableList.add(new FullReservatonTM(
                    tempReservation.getNicNo(),
                    tempReservation.getReservationNo(),
                    tempReservation.getName(),
                    tempReservation.getContact(),
                    tempReservation.getDate(),
                    tempReservation.getTime()

            ));

        }
        tblReservation.setItems(observableList);
    }
}

    