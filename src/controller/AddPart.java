package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import model.Inventory;

public class AddPart  {

    Parent scene;
    Stage stage;

    @FXML
    private Label labelInOrOutPart;
    @FXML
    private TextField textFieldParIds;


    @FXML
    void buttonAddPartSave(ActionEvent actionEvent)throws IOException{

    }
// Had to redo these buttons several times as the first two methods didn't work, as clicking the buttons do not cause an event,
// ended up implementing them as action events and corrected the error.
    @FXML
    void inHouseRadio(ActionEvent actionEvent){
       labelInOrOutPart.setText("Machine ID");
       textFieldParIds.setPromptText("Machine ID");
   }
    @FXML
    void outsourcedRadio (ActionEvent actionEvent){
        labelInOrOutPart.setText("Company Name");
        textFieldParIds.setPromptText("Company Name");
    }

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
