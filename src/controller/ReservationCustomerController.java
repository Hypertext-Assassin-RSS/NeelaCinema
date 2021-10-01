package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.customer_Details;
import view.TM.Customer_Detail_TM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReservationCustomerController {
    @FXML
    private TableView<Customer_Detail_TM> tblCustomer;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colContact;

    public void initialize() {
       
            loadAllCustomers();


        }

    private void loadAllCustomers() {
    }
}

    