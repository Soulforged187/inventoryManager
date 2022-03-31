package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPart  {

    Parent scene;
    Stage stage;

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


    public void addPartCancelHandler(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert");
        alert.setContentText("Are you sure you want to cancel?");
        alert.showAndWait();
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
}
