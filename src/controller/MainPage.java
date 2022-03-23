package controller;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPage implements Initializable{
    public Label TheLabel;
    public AnchorPane root;
    public TableView tableViewParts;
    public TableColumn tableViewPartsIDColumn;
    public TableColumn tableViewPartsNameColumn;
    public TableColumn tableViewPartsInvColumn;
    public TableColumn tableViewPartsPriceColumn;
    public TableView tableViewProducts;
    public TableColumn tableViewProductsIDColumn;
    public TableColumn tableViewProductsNameColumn;
    public TableColumn tableViewProductsInvColumn;
    public TableColumn tableViewProductsPriceColumn;
    public Label labelParts;
    public Label labelProducts;
    public Label inventoryManagementSystemMain;
    public Button buttonSearchParts;
    public Button buttonSearchProducts;
    public TextField textFieldSearchParts;
    public TextField textFieldSearchProducts;
    public Button buttonAddParts;
    public Button buttonModifyParts;
    public Button buttonDeleteParts;
    public Button buttonAddProducts;
    public Button buttonModifyProducts;
    public Button buttonDeleteProducts;
    public Button buttonClearSearchParts;
    public Button buttonClearSearchProducts;
    public Button buttonExitProgram;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Controller Initialized");
        TheLabel.setText("Initialized");
    }

    public void onButtonAction(ActionEvent actionEvent) {
        System.out.println("I was clicked");

        TheLabel.setText("I have been clicked");
    }
}
