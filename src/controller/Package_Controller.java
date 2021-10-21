package controller;

import java.sql.SQLException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Package;

public class Package_Controller {
    @FXML
    private TextField lbl_packageName;

    @FXML
    private TextField lbl_packagePrice;

    @FXML
    private TextField lbl_packageDescription;

    @FXML
    private TextField lbl_packageNo;

    @FXML
    private ComboBox<String> cmb_packageNo;

    public void initialize(){
        try {


            loadPackageNo();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        cmb_packageNo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            try {
                setPackageData(newValue);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } );

    }

    private void setPackageData(String packageNo) throws SQLException, ClassNotFoundException {
        Package p1 = new Controller().serchPackage(packageNo);
        if (p1==null){
            new Alert(Alert.AlertType.WARNING,"No Package Data").show();
        }else{
            lbl_packageName.setText(p1.getPackageName());
            lbl_packagePrice.setText(String.valueOf(p1.getPackagePrice()));
            lbl_packageDescription.setText(p1.getPackageDetails());
        }
    }

    private void loadPackageNo() throws SQLException, ClassNotFoundException {
        List<String> packageNo = new Controller().getPackageNo();
        cmb_packageNo.getItems().addAll(packageNo);

    }

    @FXML
    void save_package(MouseEvent event) throws SQLException, ClassNotFoundException {
        
        Package p1 =new Package(
                lbl_packageNo.getText(),
                lbl_packageName.getText(),
                lbl_packageDescription.getText(),
                Double.parseDouble(lbl_packagePrice.getText())
        );



        if(savePackage(p1))
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        else
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();


    }

    public void clearData(ActionEvent actionEvent) {
    }
    boolean savePackage(Package p) throws SQLException, ClassNotFoundException {
        return new Controller().savePackage(p);

    }

}
