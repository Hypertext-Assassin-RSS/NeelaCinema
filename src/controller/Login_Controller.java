package controller;

import db.DbConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;

public class Login_Controller {

    @FXML
    private Label txtWarning;



    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;


    public AnchorPane context;

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

    public void open_Settings(MouseEvent mouseEvent) throws IOException, SQLException, ClassNotFoundException {
        String password = txtPassword.getText();
        ResultSet resultSet = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Employ WHERE password='" + password + "'").executeQuery();

            if (resultSet.next()) {

                String tempUser = resultSet.getString(4);
                String tempPassword = resultSet.getString(5);

                txtUser.setText(tempUser);
                txtPassword.setText(tempPassword);

                URL resource = getClass().getResource("../view/settings.fxml");
                Parent load = FXMLLoader.load(resource);
                context.getChildren().clear();
                context.getChildren().add(load);

            } else {
                txtWarning.setText("Try Again !");
                new Alert(Alert.AlertType.WARNING, "Wrong user Name Or Password").show();
            }


        }


}

