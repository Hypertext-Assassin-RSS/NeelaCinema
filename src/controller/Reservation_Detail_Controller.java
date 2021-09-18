package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Package;
import model.customer_Details;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Reservation_Detail_Controller {

    @FXML
    private TextField txtCusName;

    @FXML
    private TextField txtFilmName;

    @FXML
    private TextField txttCusContact;

    @FXML
    private ComboBox<String> cmbTicketQTY;

    @FXML
    private TextField txtPackageName;

    @FXML
    private TextField txtPackageDescription;

    @FXML
    private TextField txtPackagePrice;

    @FXML
    private ComboBox<String> cmbNicNo;

    @FXML
    private ComboBox<String> cmbFilmNo;

    @FXML
    private ComboBox<String> cmbPackageNo;

    @FXML
    private TextField txtPackageNo;

    @FXML
    private TextField txtFilmNo;

    @FXML
    private TextField txtNicNo;




    private static ArrayList<String> QTY = new ArrayList<>();

    public void initialize(){

        try {
            loadPackageNo();
            loadnicNo();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        cmbNicNo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtNicNo.setText(newValue);

            try {
                setCustomerData(newValue);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        cmbPackageNo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtPackageNo.setText(newValue);
            try {
                setPackageData(newValue);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });


        ObservableList<String> observableList = FXCollections.observableArrayList();
        cmbTicketQTY.getItems().addAll("1","2","3","4","5","6","7","8","9","10");

        }

    private void setCustomerData(String nicNo) throws SQLException, ClassNotFoundException {
        customer_Details c1 = new customerController().searchCustomer(nicNo);
        if (c1==null){
            new Alert(Alert.AlertType.WARNING,"Empty Result Set").show();
        }else{
            txtNicNo.setText(c1.getId());
            txtCusName.setText(c1.getName());
            txttCusContact.setText(c1.getContact());
        }
    }


    private void loadnicNo() throws SQLException, ClassNotFoundException {
        List<String> nicNo = new customerController().getNicNo();
        cmbNicNo.getItems().addAll(nicNo);
    }


    private void setPackageData(String packageNo) throws SQLException, ClassNotFoundException {
        Package p1 = new packageController().serchPackage(packageNo);
        if (p1==null){
            new Alert(Alert.AlertType.WARNING,"No Package Data").show();
        }else{
            txtPackageName.setText(p1.getPackageName());
            txtPackagePrice.setText(String.valueOf(p1.getPackagePrice()));
            txtPackageDescription.setText(p1.getPackageDetails());
        }
    }

    private void loadPackageNo() throws SQLException, ClassNotFoundException {
        List<String> packageNo = new packageController().getPackageNo();
        cmbPackageNo.getItems().addAll(packageNo);

    }


}




