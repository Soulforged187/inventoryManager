package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPart implements Initializable {
    public Label labelAddPartScreen;
    public RadioButton radioAddPartInHouse;
    public RadioButton radioAddPartOutsourced;
    public Label labelAddPartID;
    public Label labelAddPartIDNumber;
    public Label labelAddPartName;
    public TextField textFieldAddPartName;
    public Label labelAddPartInv;
    public TextField textFieldAddPartInv;
    public Label labelAddPartPrice;
    public TextField textFieldAddPartPrice;
    public Label labelAddPartMin;
    public TextField textFieldAddPartMin;
    public Label lblAddPartMax;
    public TextField textFieldAddPartMax;
    public Label labelAddPartDyn;
    public TextField textFieldAddPartDyn;
    public Button buttonAddPartSave;
    public Button btnAddPartCancel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
