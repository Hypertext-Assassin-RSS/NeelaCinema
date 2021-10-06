package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Film;
import view.TM.FilmTM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageFilmController {
    @FXML
    private TextField textFilmName;

    @FXML
    private ComboBox<Integer> cmbStudioNo;

    @FXML
    private TextField textShowTime;

    @FXML
    private TextField textStartDate;

    @FXML
    private TextField textEndDate;

    @FXML
    private TableView<FilmTM> tblFilm;

    @FXML
    private TableColumn<String, ?> colFilmName;

    @FXML
    private TableColumn<?, ?> colStudioNo;


    @FXML
    private TableColumn<?, ?> colShowTime;

    @FXML
    private TableColumn<?, ?> colStartDate;

    @FXML
    private TableColumn<?, ?> colEndDate;

    public void initialize(){

        try {
            colFilmName.setCellValueFactory(new PropertyValueFactory<>("filmName"));
            colStudioNo.setCellValueFactory(new PropertyValueFactory<>("studioNo"));
            colShowTime.setCellValueFactory(new PropertyValueFactory<>("showTime"));
            colStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
            colEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));

            loadAllFim();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ObservableList<String> observableList = FXCollections.observableArrayList();
        cmbStudioNo.getItems().addAll(001,002,003);


    }
    public  void loadAllFim() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT  * FROM FIlm";
        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<Film> films = new ArrayList<>();
        while (resultSet.next()){
            films.add(new Film(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }

        setFilmToTable(films);
    }

    private void setFilmToTable(ArrayList<Film> films) {
        ObservableList<FilmTM> observableList = FXCollections.observableArrayList();
        films.forEach(film -> {
            observableList.add(
                    new FilmTM(
                            film.getFilmName(),
                            film.getStudioNo(),
                            film.getShowTime(),
                            film.getStartDate(),
                            film.getEndDate()



                    ));
        });
        tblFilm.setItems(observableList);
    }

    @FXML
    void saveMovie(MouseEvent event) throws SQLException, ClassNotFoundException {
        Film film = new Film(
                textFilmName.getText(),
                cmbStudioNo.getValue(),
                textShowTime.getText(),
                textStartDate.getText(),
                textEndDate.getText()
        );
        if (saveMovie(film)){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved...").show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again...").show();
        }
    }
    private  boolean saveMovie (Film f1) throws SQLException, ClassNotFoundException {
        return new Film_Controller().saveFilm(f1);
    }
}
