package controller;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
    private ComboBox<?> cmb_packageNo;
    
      @FXML
    void save_package(MouseEvent event) {
        
        Item item1 =new Item(
                txtItemCode.getText(),
                txtDescription.getText(),
                txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQTYonHand.getText())
        );



        if(saveItem(item1))
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        else
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();


    }

    public void clearData(ActionEvent actionEvent) {
    }
    boolean saveItem(Item item) throws SQLException, ClassNotFoundException {
        return new ItemController().saveItem(item);

    }

}
