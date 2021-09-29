package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Parking;
import model.customer_Details;
import view.TM.ParkingTM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Parking_Controller {
    @FXML
    private ComboBox<String> cmbType;

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

    public void initialize(){

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colParkingNo.setCellValueFactory(new PropertyValueFactory<>("parkingNo"));

        try {
            loadnicNo();
            loadAllParking();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        cmbType.getItems().addAll("Car","Van","Bus","Lorry","Bike");

        cmbType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtVehicleType.setText(newValue);
        });

        cmbNicNo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setCustomerData(newValue);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

    }

    private void loadAllParking() throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();
        Statement stm = con.createStatement();
        String query = "SELECT * FROM Parking";
        ResultSet rst = stm.executeQuery(query);

        ArrayList<Parking> parkings = new ArrayList<>();
        while (rst.next()){
            parkings.add(new Parking(
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    Integer.parseInt(rst.getString(6))
            ));
        }
        setParkingToTable(parkings);

    }

    private void setParkingToTable(ArrayList<Parking> parkings) {
        ObservableList<ParkingTM> observableList = FXCollections.observableArrayList();
        parkings.forEach(parking -> {
            observableList.add(new ParkingTM(
                    parking.getName(),
                    parking.getContact(),
                    parking.getVehicleNo(),
                    parking.getParkingNo()
            ));
        });
        tblParking.setItems(observableList);
    }

    private void setCustomerData(String nicNo) throws SQLException, ClassNotFoundException {
        customer_Details c1 = new customerController().searchCustomer(nicNo);
        if (c1==null){
            new Alert(Alert.AlertType.WARNING,"Empty Result Set").show();
        }else{
            txtNicNo.setText(c1.getId());
            txtName.setText(c1.getName());
            txtContact.setText(c1.getContact());
        }
    }

    private void loadnicNo() throws SQLException, ClassNotFoundException {
        List<String> nicNo = new customerController().getNicNo();
        cmbNicNo.getItems().addAll(nicNo);
    }

    @FXML
    void saveParkingDetails(MouseEvent event) throws SQLException, ClassNotFoundException {
        Parking parking = new Parking(
                txtNicNo.getText(),
                txtName.getText(),
                txtContact.getText(),
                txtVehicleNo.getText(),
                txtVehicleType.getText(),
                Integer.parseInt(txtParkingNo.getText())
        );
        if (save_ParkingDetails(parking)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved...").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again...").show();
        }
    }


    private boolean save_ParkingDetails(Parking p1) throws SQLException, ClassNotFoundException {
        return new parkingController().saveParking(p1);
    }

}
