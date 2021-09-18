/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Setting_Controller implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
