package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Employ;
import model.Studio;
import view.TM.StudioTM;

import java.sql.SQLException;

public class Studio_Controller {
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TableView<StudioTM> tblCustomer;

    @FXML
    private TableColumn<?, ?> colStudioName;

    @FXML
    private Label studioName;

    @FXML
    private TableColumn<?, ?> colStudioNo;

    @FXML
    private Label studioNo;

    public void initialize(){
        colStudioName.setCellValueFactory(new PropertyValueFactory<>("studioName"));
        colStudioNo.setCellValueFactory(new PropertyValueFactory<>("studioNo"));


        try {
            loadAllStudio();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadAllStudio() throws SQLException, ClassNotFoundException {
        ObservableList<StudioTM> studioTMS = FXCollections.observableArrayList();
            for (Studio tempStudio:new Controller().getAllStudio()
            ){
                studioTMS.add(new StudioTM(
                       tempStudio.getStudioName(),
                       tempStudio.getStudionNo()
                ));

            }
            tblCustomer.setItems(studioTMS);


    }


    @FXML
    void saveStudio(MouseEvent event) throws SQLException, ClassNotFoundException {
        Studio studio = new Studio(
                txtId.getText(),
                txtName.getText()

        );
        if (save_studio_Details(studio))
            new Alert(Alert.AlertType.CONFIRMATION,"Saved...").show();
        else
            new Alert(Alert.AlertType.WARNING,"Try Again...").show();

    }

    private boolean save_studio_Details(Studio st) throws SQLException, ClassNotFoundException {
        return new Controller().save_studio_Details(st);
    }
}
