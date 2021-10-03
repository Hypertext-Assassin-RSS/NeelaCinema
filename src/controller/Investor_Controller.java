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
import model.Employ;
import model.Investor;
import model.Owner;
import view.TM.EmployTM;
import view.TM.InvestorTM;
import view.TM.OwnerTM;

import java.sql.SQLException;

public class Investor_Controller {
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtContact;

    @FXML
    private TableView<InvestorTM> tblinvestor;

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
            loadAllInvestor();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadAllInvestor() throws SQLException, ClassNotFoundException {
        ObservableList<InvestorTM> investorTMS = FXCollections.observableArrayList();
        for (Investor tempInvestor:new Controller().getAllInvestor()
        ){
            investorTMS.add(new InvestorTM(
                    tempInvestor.getNicNo(),
                    tempInvestor.getName(),
                    tempInvestor.getContact()
            ));

        }
        tblinvestor.setItems(investorTMS);
    }

    @FXML
    void saveInvestor(MouseEvent event) throws SQLException, ClassNotFoundException {

        Investor investor = new Investor(
                txtId.getText(),
                txtName.getText(),
                txtContact.getText()
        );
        if (save_Investor(investor))
            new Alert(Alert.AlertType.CONFIRMATION,"Saved...").show();
        else
            new Alert(Alert.AlertType.WARNING,"Try Again...").show();

    }

    private boolean save_Investor(Investor in) throws SQLException, ClassNotFoundException {
        return new Controller().save_Investor(in);
    }
}
