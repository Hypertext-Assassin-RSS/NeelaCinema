package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import view.TM.ParkingTM;

public class Parking_Controller {

    @FXML
    private ComboBox<String> cmbVehicleType;

    @FXML
    private ComboBox<String> cmbNicNo;

    @FXML
    private TextField txtNicNo;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtVehicleNo;

    @FXML
    private TextField txtVehicleType;

    @FXML
    private TextField txtParkingNo;

    @FXML
    private TableView<ParkingTM> tblParking;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colVehicleNo;

    @FXML
    private TableColumn<?, ?> colParkingNo;

    private void initialize(){

        /*cmbVehicleType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtVehicleType.setText(newValue);
        });*/

        //ObservableList<String> observableList = FXCollections.observableArrayList();
        cmbVehicleType.getItems().addAll("1","2","3","4","5","6","7","8","9","10");

        ObservableList<String> observableList = FXCollections.observableArrayList();
        cmbNicNo.getItems().addAll("1","2","3","4","5","6","7","8","9","10");

    }

    @FXML
    void saveParkingDetails(MouseEvent event) {

    }
    
}
