package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Package;
import model.customer_Details;
import view.TM.Customer_Detail_TM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Customer_Detail_Controller {
    public TableView tblCustomer;
    public TableColumn colNic;
    public TableColumn colName;
    public TableColumn colContact;
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtContact;

    public void initialize(){

        try {
            colNic.setCellValueFactory(new PropertyValueFactory<>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

            loadAllCustomers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadAllCustomers() throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();
        Statement stm = con.createStatement();
        String query = "SELECT * FROM Customer_Detail";
        ResultSet rst = stm.executeQuery(query);

        ArrayList<customer_Details> customer_details = new ArrayList<>();
        while (rst.next()) {
            customer_details.add(new customer_Details(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            ));
        }
        setCustomerToTabel(customer_details);
    }

    private void setCustomerToTabel(ArrayList<customer_Details> customer_details) {
        ObservableList<Customer_Detail_TM> obList = FXCollections.observableArrayList();
        customer_details.forEach(Customer-> {
            obList.add(
                    new Customer_Detail_TM(Customer.getId(),Customer.getName(),Customer.getContact()));

        });
        tblCustomer.setItems(obList);
    }

    @FXML
    void saveCustomer_Detalis(MouseEvent event) throws SQLException, ClassNotFoundException {

        customer_Details cd = new customer_Details(
                txtId.getText(),
                txtName.getText(),
                txtContact.getText()
        );
        if (save_Customer_Detalis(cd))
            new Alert(Alert.AlertType.CONFIRMATION,"SAVED").show();
        else
            new Alert(Alert.AlertType.WARNING,"TRY AGAIN").show();

    }

    private boolean save_Customer_Detalis(customer_Details c1) throws SQLException, ClassNotFoundException {
        return new customerController().save_Customer_Details(c1);
    }

}

