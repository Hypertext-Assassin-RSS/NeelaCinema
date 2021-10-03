
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Setting_Controller implements Initializable {

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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
    @FXML
    void openEmploy(MouseEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/Employ.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openInvestor(MouseEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/investor.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openStudio(MouseEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/studio.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void penOwner(MouseEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/owner.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void openAddTicket(MouseEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/Add_Ticket.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void open_manageFilm(MouseEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/manageFilm.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
