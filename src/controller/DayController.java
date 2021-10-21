package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Day;
import model.Film;
import view.TM.DayTM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DayController {

    @FXML
    private ComboBox<String> cmbYear;

    @FXML
    private ComboBox<String> cmbMonth;

    @FXML
    private ComboBox<String> cmbDay;

    @FXML
    private ComboBox<String> cmbFilm;

    @FXML
    private TableView<DayTM> tblDay;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TextField txtYear;

    @FXML
    private TextField txtMonth;

    @FXML
    private TextField txtDay;

    @FXML
    private TextField txtFilmName;

    @FXML
    private TextField txtShowTime;

    @FXML
    private TextField txtStartDate;

    @FXML
    private TextField txtEndDate;

    @FXML
    private TableColumn<?, ?> colYear;

    @FXML
    private TableColumn<?, ?> colMonth;

    @FXML
    private TableColumn<?, ?> colDay;

    @FXML
    private TableColumn<?, ?> colFilmName;

    @FXML
    private TableColumn<?, ?> colShowTime;

    @FXML
    private TableColumn<?, ?> colStartDate;

    @FXML
    private TableColumn<?, ?> colEndDate;





    public void initialize(){

        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colMonth.setCellValueFactory(new PropertyValueFactory<>("month"));
        colDay.setCellValueFactory(new PropertyValueFactory<>("day"));
        colFilmName.setCellValueFactory(new PropertyValueFactory<>("filmName"));
        colShowTime.setCellValueFactory(new PropertyValueFactory<>("showTime"));
        colStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        try {
            loadAllDays();
            loadFilmName();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        cmbYear.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtYear.setText(newValue);
        });

        ObservableList<String> observableList = FXCollections.observableArrayList();
        cmbYear.getItems().addAll("2020","2021","2022","2023","2024","2025");

        cmbMonth.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtMonth.setText(newValue);
        });

        ObservableList<String> observableList1 = FXCollections.observableArrayList();
        cmbMonth.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12");

        cmbDay.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtDay.setText(newValue);
        });

        ObservableList<String> observableList2 = FXCollections.observableArrayList();
        cmbDay.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");

        cmbFilm.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtFilmName.setText(newValue);

            try {
                setFilmData(newValue);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });


    }

    private void loadAllDays() throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();
        Statement stm = con.createStatement();
        String query = "SELECT * FROM Day";
        ResultSet rst = stm.executeQuery(query);

        ArrayList<Day> days = new ArrayList<>();
        while (rst.next()) {
            days.add(new Day(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)
            ));
        }
        setDayToTable(days);
    }

    private void setDayToTable(ArrayList<Day> days) {
        ObservableList<DayTM> observableList = FXCollections.observableArrayList();
        days.forEach(day -> {
            observableList.add(new DayTM(day.getYear(), day.getMonth(), day.getDay(), day.getFilmName(), day.getShowTime(), day.getStartDate(), day.getEndDate()));
        });
        tblDay.setItems(observableList);
    }

    private void setFilmData(String film_name) throws SQLException, ClassNotFoundException {
        Film f1 = new Film_Controller().searchFilm(film_name);
        if (f1==null){
            new Alert(Alert.AlertType.WARNING,"Empty Result Set").show();
        }else{
            txtShowTime.setText(f1.getShowTime());
            txtStartDate.setText(f1.getStartDate());
            txtEndDate.setText(f1.getEndDate());
        }
    }


    private void loadFilmName() throws SQLException, ClassNotFoundException {
            List<String> filmName = new Film_Controller().getFilmName();
            cmbFilm.getItems().addAll(filmName);
        }



    @FXML
    void close(MouseEvent event) {
        Stage e = (Stage) ((Node) event.getSource()).getScene().getWindow();
        e.close();
    }

    @FXML
    void max(MouseEvent event) {
        Stage e = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (e.isMaximized()){
            e.setMaximized(false);
        }else{
            e.setMaximized(true);
        }
    }

    @FXML
    void mini(MouseEvent event) {
        Stage e = (Stage) ((Node) event.getSource()).getScene().getWindow();
        e.setIconified(true);
    }


    @FXML
    void saveDay(MouseEvent event) throws SQLException, ClassNotFoundException {

        Day d1 = new Day(
                txtYear.getText(),
                txtMonth.getText(),
                txtDay.getText(),
                txtFilmName.getText(),
                txtShowTime.getText(),
                txtStartDate.getText(),
                txtEndDate.getText()

        );
        if (saveDayDetails(d1)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        }
    }

    private boolean saveDayDetails(Day d) throws SQLException, ClassNotFoundException {
        return new Controller().saveDay(d);
    }


}
