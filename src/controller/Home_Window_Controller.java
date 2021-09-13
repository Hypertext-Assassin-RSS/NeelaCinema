package controller;


import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home_Window_Controller {
    public FontAwesomeIconView icon;
    public AnchorPane context;
    @FXML
    private static JFXButton btnSchedule;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void close(MouseEvent event) {
        Stage e = (Stage) ((Node) event.getSource()).getScene().getWindow();
        e.close();
    }

    @FXML
    void max(MouseEvent event) {
        Stage e = (Stage) ((Node) event.getSource()).getScene().getWindow();
        e.setFullScreen(true);
    }

    @FXML
    void mini(MouseEvent event) {
        Stage e = (Stage) ((Node) event.getSource()).getScene().getWindow();
        e.setIconified(true);
    }


    public void openSchedule(MouseEvent mouseEvent) throws IOException {
        loadUi("sample");

    }


    void loadUi(String fileName) throws IOException {
        URL resource = getClass().getResource("../view/" + fileName + ".fxml");
        Parent load = FXMLLoader.load(resource);
        context.getChildren().clear();
        context.getChildren().add(load);
    }
}

