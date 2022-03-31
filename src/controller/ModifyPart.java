package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;


public class ModifyPart  {

        Parent scene;
        Stage stage;

        @FXML
        private RadioButton radioModifyPartInHouse;
        @FXML
        private RadioButton radioModifyPartOutsourced;
        @FXML
        private TextField textFieldModifyPartName;
        @FXML
        private TextField textFieldModifyPartInv;
        @FXML
        private TextField textFieldModifyPartPrice;
        @FXML
        private TextField textFieldModifyPartMin;
        @FXML
        private TextField textFieldModifyPartMax;
        @FXML
        private TextField textFieldModifyPartDyn;


        public void modifyPartCancelHandler(ActionEvent actionEvent)throws IOException{
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
