package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Owner;
import view.TM.OwnerTM;

import java.sql.SQLException;

public class Owner_Controller {
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtContact;

    @FXML
    private TableView<OwnerTM> tblOwner;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colContact;

    public void initialize(){
        colNic.setCellValueFactory(new PropertyValueFactory<>("nicNo"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

        try {
            loadAllOwner();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadAllOwner() throws SQLException, ClassNotFoundException {
        ObservableList<OwnerTM> ownerTMS = FXCollections.observableArrayList();
            for (Owner tempOwner:new Controller().getAllOwner()
            ){
                ownerTMS.add(new OwnerTM(
                        tempOwner.getNicNo(),
                        tempOwner.getName(),
                        tempOwner.getContact()
                ));

            }
            tblOwner.setItems(ownerTMS);
        }


    @FXML
    void saveOwner(MouseEvent event) throws SQLException, ClassNotFoundException {

        Owner owner = new Owner(
                txtId.getText(),
                txtName.getText(),
                txtContact.getText()
        );
        if (save_Owner_Details(owner))
            new Alert(Alert.AlertType.CONFIRMATION,"Saved...").show();
        else
            new Alert(Alert.AlertType.WARNING,"Try Again...").show();

    }

    private boolean save_Owner_Details(Owner ow) throws SQLException, ClassNotFoundException {
        return new Controller().save_Owner_Details(ow);
    }


}
