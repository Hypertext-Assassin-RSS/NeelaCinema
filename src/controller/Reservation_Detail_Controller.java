package controller;

import db.DbConnection;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Package;
import model.customer_Details;
import model.reservation;
import model.reservstion_detail;
import view.TM.ReservationTM;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation_Detail_Controller {

    @FXML
    private TextField txtCusName;

    @FXML
    private TextField txtFilmName;

    @FXML
    private TextField txtCusContact;

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
    private ComboBox<String> cmbFilmName;

    @FXML
    private ComboBox<String> cmbPackageNo;

    @FXML
    private TextField txtPackageNo;

    @FXML
    private TextField txtNicNo;

    @FXML
    private TextField txtTicketQTY;

    @FXML
    private TextField txtReservationNo;

    @FXML
    private TableView<ReservationTM> tblReservation;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colFilmName;

    @FXML
    private TableColumn<?, ?> colPackageNo;

    @FXML
    private TableColumn<?, ?> colTicketQTY;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;




    private void loadDateAndTime() {

        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        String date = f.format(new Date());
        lblDate.setText(date);


        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }


    private static ArrayList<String> QTY = new ArrayList<>();

    public void initialize() throws SQLException, ClassNotFoundException {

        try {
            colNic.setCellValueFactory(new PropertyValueFactory<>("cusNicNo"));
            colFilmName.setCellValueFactory(new PropertyValueFactory<>("filmName"));
            colPackageNo.setCellValueFactory(new PropertyValueFactory<>("packageNo"));
            colTicketQTY.setCellValueFactory(new PropertyValueFactory<>("ticketQTY"));

            loadPackageNo();
            loadnicNo();
            loadFilmNAme();
            loadAllReservations();
            loadDateAndTime();
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
        cmbFilmName.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtFilmName.setText(newValue);


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
        cmbTicketQTY.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtTicketQTY.setText(newValue);
        });


        ObservableList<String> observableList = FXCollections.observableArrayList();
        cmbTicketQTY.getItems().addAll("1","2","3","4","5","6","7","8","9","10");


        }

    private void loadAllReservations() throws SQLException, ClassNotFoundException {
        ObservableList<ReservationTM> observableList = FXCollections.observableArrayList();
        for (reservation tempReservation :new Controller().getAllReservations()
             ) {
            observableList.add(new ReservationTM(
                    tempReservation.getCusNicNo(),
                    tempReservation.getFilmName(),
                    tempReservation.getPackageNo(),
                    tempReservation.getTicketQTY()

            ));

        }
        tblReservation.setItems(observableList);
    }

    private void setReservationToTable(ArrayList<reservation> reservations) {
        ObservableList<ReservationTM> observableList = FXCollections.observableArrayList();
        reservations.forEach(reservation -> {
            observableList.add(new ReservationTM(reservation.getCusNicNo(),
                    reservation.getFilmName(),
                    reservation.getPackageNo(),
                    reservation.getTicketQTY()));
        });
        tblReservation.setItems(observableList);
    }

    @FXML
    void saveRes(MouseEvent event) throws SQLException, ClassNotFoundException {
        reservstion_detail d1 = new reservstion_detail(
                txtReservationNo.getText(),
                txtNicNo.getText(),
                txtCusName.getText(),
                txtCusContact.getText(),
                lblDate.getText(),
                lblTime.getText()

        );

        if (saveRes(d1)){
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        }else{
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        }

    }


    @FXML
    void saveReservation(MouseEvent event) throws SQLException, ClassNotFoundException {

    reservation r1 = new reservation(
            txtNicNo.getText(),
            txtCusName.getText(),
            txtCusContact.getText(),
            txtFilmName.getText(),
            Integer.parseInt(txtTicketQTY.getText()),
            txtPackageNo.getText(),
            txtPackageName.getText(),
            txtPackageDescription.getText(),
            Double.parseDouble(txtPackagePrice.getText()),
            txtReservationNo.getText()
    );
    if (saveReservationDetails(r1)) {

        new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
    }else {
        new Alert(Alert.AlertType.WARNING, "Try Again..").show();
    }
    }

    private boolean saveRes(reservstion_detail res) throws SQLException, ClassNotFoundException {
        return new Controller().saveRes(res);
    }

    private boolean saveReservationDetails(reservation r) throws SQLException, ClassNotFoundException {
        return new Controller().saveReservation(r);
    }

    private void loadFilmNAme() throws SQLException, ClassNotFoundException {
        List<String> filmName = new Film_Controller().getFilmName();
        cmbFilmName.getItems().addAll(filmName);
    }

    private void setCustomerData(String nicNo) throws SQLException, ClassNotFoundException {
        customer_Details c1 = new Controller().searchCustomer(nicNo);
        if (c1==null){
            new Alert(Alert.AlertType.WARNING,"Empty Result Set").show();
        }else{
            txtNicNo.setText(c1.getId());
            txtCusName.setText(c1.getName());
            txtCusContact.setText(c1.getContact());
        }
    }


    private void loadnicNo() throws SQLException, ClassNotFoundException {
        List<String> nicNo = new Controller().getNicNo();
        cmbNicNo.getItems().addAll(nicNo);
    }


    private void setPackageData(String packageNo) throws SQLException, ClassNotFoundException {
        Package p1 = new Controller().serchPackage(packageNo);
        if (p1==null){
            new Alert(Alert.AlertType.WARNING,"No Package Data").show();
        }else{
            txtPackageName.setText(p1.getPackageName());
            txtPackagePrice.setText(String.valueOf(p1.getPackagePrice()));
            txtPackageDescription.setText(p1.getPackageDetails());
        }
    }

    private void loadPackageNo() throws SQLException, ClassNotFoundException {
        List<String> packageNo = new Controller().getPackageNo();
        cmbPackageNo.getItems().addAll(packageNo);

    }


    public void openReservationWindow(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/reservation_customer.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}




