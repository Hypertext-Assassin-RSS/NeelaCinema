package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
import java.util.List;

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

    @FXML
    private ComboBox<String> cmbNicNo;


    public void initialize(){

        try {
            colNic.setCellValueFactory(new PropertyValueFactory<>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

            loadAllCustomers();
            loadnicNo();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        cmbNicNo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setCustomerData(newValue);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    private void setCustomerData(String nicNo) throws SQLException, ClassNotFoundException {
        customer_Details c1 = new customerController().searchCustomer(nicNo);
        if (c1==null){
            new Alert(Alert.AlertType.WARNING,"Empty Result Set").show();
        }else{
            txtId.setText(c1.getId());
            txtName.setText(c1.getName());
            txtContact.setText(c1.getContact());
        }
    }

    private void loadnicNo() throws SQLException, ClassNotFoundException {
        List<String> nicNo = new customerController().getNicNo();
        cmbNicNo.getItems().addAll(nicNo);
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
            new Alert(Alert.AlertType.CONFIRMATION,"Saved...").show();
        else
            new Alert(Alert.AlertType.WARNING,"Try Again...").show();

    }

    private boolean save_Customer_Detalis(customer_Details c1) throws SQLException, ClassNotFoundException {
        return new customerController().save_Customer_Details(c1);
    }

}

