package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPart implements Initializable {

    @FXML
    private RadioButton radioAddPartInHouse;
    @FXML
    private RadioButton radioAddPartOutsourced;
    @FXML
    private TextField textFieldAddPartName;
    @FXML
    private TextField textFieldAddPartInv;
    @FXML
    private TextField textFieldAddPartPrice;
    @FXML
    private TextField textFieldAddPartMin;
    @FXML
    private TextField textFieldAddPartMax;
    @FXML
    private TextField textFieldAddPartDyn;
    @FXML
    private Button buttonAddPartSave;
    @FXML
    private Button buttonAddPartCancel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
