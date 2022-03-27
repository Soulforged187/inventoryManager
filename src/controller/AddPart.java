package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPart implements Initializable {

    public RadioButton radioAddPartInHouse;
    public RadioButton radioAddPartOutsourced;
    public TextField textFieldAddPartName;
    public TextField textFieldAddPartInv;
    public TextField textFieldAddPartPrice;
    public TextField textFieldAddPartMin;
    public TextField textFieldAddPartMax;
    public TextField textFieldAddPartDyn;
    public Button buttonAddPartSave;
    public Button btnAddPartCancel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
