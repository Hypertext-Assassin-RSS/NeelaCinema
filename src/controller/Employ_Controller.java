package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Employ;
import model.customer_Details;
import view.TM.EmployTM;

import java.sql.SQLException;

public class Employ_Controller {
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtContact;

    @FXML
    private ComboBox<String> cmbNicNo;

    @FXML
    private TableView<EmployTM> tblEmploy;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtPassword;

    public void initialize(){
        colNic.setCellValueFactory(new PropertyValueFactory<>("nicNo"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

        try {
            loadAllEmploy();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadAllEmploy() throws SQLException, ClassNotFoundException {
        ObservableList<EmployTM> employTMS = FXCollections.observableArrayList();
        for (Employ tempEmploy:new Controller().getAllEmploy()
            ){
        employTMS.add(new EmployTM(
                tempEmploy.getNicNo(),
                tempEmploy.getName(),
                tempEmploy.getContact()
        ));

        }
    tblEmploy.setItems(employTMS);
    }

    @FXML
    void saveEmploy(MouseEvent event) throws SQLException, ClassNotFoundException {
        Employ employ = new Employ(
                txtId.getText(),
                txtName.getText(),
                txtContact.getText(),
                txtUser.getText(),
                txtPassword.getText()
        );
        if (save_Employ(employ))
            new Alert(Alert.AlertType.CONFIRMATION,"Saved...").show();
        else
            new Alert(Alert.AlertType.WARNING,"Try Again...").show();

    }

    private boolean save_Employ(Employ em) throws SQLException, ClassNotFoundException {
        return new Controller().save_Employ(em);
    }

}
