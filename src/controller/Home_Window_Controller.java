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
    public AnchorPane ApaneOne;
    public AnchorPane STpaneOne;
    public JFXButton btnReservation;
    @FXML
    public AnchorPane newPane;


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


    public void openSchedule(MouseEvent mouseEvent) throws IOException {
        loadUi("calander");

    }
    @FXML
    void open_Customer_Details(MouseEvent event) throws IOException {
        loadUi("Customer_Details");
    }
     
    @FXML
    void open_Film(MouseEvent event) throws IOException {
        loadUi("Film");
    }

    @FXML
    void open_Login(MouseEvent event) throws IOException {
        //loadUi("Login");
        URL resource = getClass().getResource("../view/Login.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void open_Package(MouseEvent event) throws IOException {
        loadUi("Package");
    }
      @FXML
    void Open_Reservation_Details(MouseEvent event) throws IOException {
        loadUi("reservation");
    }

    @FXML
    void Open_Ticket(MouseEvent event) throws IOException {
        loadUi("Tickets");
    }




    void loadUi(String fileName) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/" + fileName + ".fxml"));
        Scene scene = btnReservation.getScene();
        load.translateXProperty().set(scene.getWidth());

        ApaneOne.getChildren().add(load);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(load.translateXProperty(),0,Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1),keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(event -> {
            ApaneOne.getChildren().remove(STpaneOne);
        });
        timeline.play();
    }

    public void openReservation(MouseEvent mouseEvent) throws IOException {
        loadUi("Reservation_Details");
    }
     @FXML
    void open_Parking(MouseEvent event) throws IOException {
        //loadUi("parking");
        URL resource = getClass().getResource("../view/parking.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    void open_settings(MouseEvent event) throws IOException {
       // loadUi("settings");
        
    }


}

