package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import model.InHousePart;
import model.Inventory;
import model.OutSourcedPart;




public class AddPart  implements Initializable {

    Parent scene;
    Stage stage;
    static int id;

    @FXML
    private RadioButton outsourcedRad;
    @FXML
    private RadioButton inHouseRad;
    @FXML
    private Label labelInOrOutPart;
    @FXML
    private TextField textFieldParIds;
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


    // Had to redo these buttons several times as the first two methods didn't work, as clicking the buttons do not cause an event,
    // ended up implementing them as action events and corrected the error.
    @FXML
    void inHouseRadio(ActionEvent actionEvent){
        labelInOrOutPart.setText("Machine ID");
        textFieldParIds.setPromptText("Machine ID");
        outsourcedRad.setSelected(false);
    }
    @FXML
    void outsourcedRadio (ActionEvent actionEvent){
        labelInOrOutPart.setText("Company Name");
        textFieldParIds.setPromptText("Company Name");
        inHouseRad.setSelected(false);
    }

    public void addPartCancelHandler(ActionEvent actionEvent) throws IOException {
        Inventory.confirmationScreen("Cancel", "Are you sure you want to Cancel?");
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    // This was the hardest section of the project, the solution that corrected the issue
    @FXML
    void buttonSaveHandler(ActionEvent actionEvent)throws IOException{
        String partName = textFieldAddPartName.getText();
        String partInventory = textFieldAddPartInv.getText();
        String partCost = textFieldAddPartPrice.getText();
        String partMax = textFieldAddPartMax.getText();
        String partMin = textFieldAddPartMin.getText();
        String partCompanyName = textFieldParIds.getText();

        if (partName == null || partName.length() == 0 || partInventory == null ||
                partInventory.length() == 0 || partCost == null || partCost.length() == 0 ||
                partMax.length() == 0 || partMin.length() == 0 ||
                partCompanyName == null || partCompanyName.length() == 0) {

            Inventory.warningScreen("Warning","One or more blank Fields","Fields cannot be blank");
            }

        else {

            try {
                String name = textFieldAddPartName.getText();
                double price = Double.parseDouble(textFieldAddPartPrice.getText());
                int stock = Integer.parseInt(textFieldAddPartInv.getText());
                int max = Integer.parseInt(textFieldAddPartMax.getText());
                int min = Integer.parseInt(textFieldAddPartMin.getText());
                String companyName = textFieldParIds.getText();

                if (stock < min || stock > max) {

                    Inventory.warningScreen("Warning", "Check Min/Max", "Min Cannot be Greater than Max");
                } else {


                    if (inHouseRad.isSelected()) {
                        int machineId = Integer.parseInt(textFieldParIds.getText());
                        Inventory.addPart(new InHousePart(++id,name, price, stock, min, max,machineId));
                    } else {
                        Inventory.addPart(new OutSourcedPart(++id, name, price, stock, min, max, companyName));
                    }
                    stage = (Stage)((Button) actionEvent.getSource()).getScene().getWindow();
                    scene = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
                    stage.setScene(new Scene(scene));
                    stage.show();
                }

            } catch (NumberFormatException e) {

                Inventory.warningScreen("Warning", "Error", "One or More Fields are Empty");
            }

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
