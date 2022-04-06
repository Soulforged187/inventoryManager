package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

    //RUNTIME ERROR
    // Had to redo these buttons several times as the first  methods didn't work, first was using a radio button function,
    // however toggling the buttons failed to execute properly, changed to  ActionEvent instead.
    // ended up implementing them as action events and corrected the error.
    // these buttons toggle the fields and buttons to ensure the user can enter either specify the parts were internal or outsourced.
    @FXML
    void inHouseRadio(ActionEvent actionEvent){
        labelInOrOutPart.setText("Machine ID");
        textFieldParIds.setPromptText("Machine ID");
        outsourcedRad.setSelected(false);
    }
    // these buttons toggle the fields and buttons to ensure the user can enter either specify the parts were internal or outsourced.
    @FXML
    void outsourcedRadio (ActionEvent actionEvent){
        labelInOrOutPart.setText("Company Name");
        textFieldParIds.setPromptText("Company Name");
        inHouseRad.setSelected(false);
    }
// allows the user to leave the page without saving returning to the main screen.
    public void addPartCancelHandler(ActionEvent actionEvent) throws IOException {
        Inventory.confirmationScreen("Cancel", "Are you sure you want to Cancel?");
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    // This was the hardest section of the project, attempting to ensure that both the data was accurately captured and that the logical restrictions to ensure both data integrity and data effectiveness.
    // However, was the basis for the rest of the save function handlers.
    // Save handler, was designed this way to ensure an easy logical flow, first it will check if the fields have been filled with a warning screen to prompt the user in the instance of empty data.
    //  Next it will check the fields to fill temporary variables, then check to ensure Min and Max are logically filled and that current stock is following set conventions.
    //  Radio buttons will be checked to have proper fields for parts built in house vs parts outsourced.
    // IDs are auto generated to ensure strong primary keys.
    //  A catch statement is added to ensure the program won't crash in instance that are not anticipated.
    @FXML
    void buttonSaveHandler(ActionEvent actionEvent)throws IOException {
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

            Inventory.warningScreen("Warning", "Check Fields", "Fields cannot be blank, Inputs must be correct type");
        } else {

            try {
                String name = textFieldAddPartName.getText();
                double price = Double.parseDouble(textFieldAddPartPrice.getText());
                int stock = Integer.parseInt(textFieldAddPartInv.getText());
                int max = Integer.parseInt(textFieldAddPartMax.getText());
                int min = Integer.parseInt(textFieldAddPartMin.getText());
                String companyName = textFieldParIds.getText();

                if (stock < min || stock > max) {
                    Inventory.warningScreen("Warning", "Check Inv/Min/Max", "Min Cannot be Greater than Max, Inventory cannot exceed Max");
                } else {

                    if (inHouseRad.isSelected()) {
                        int machineId = Integer.parseInt(textFieldParIds.getText());
                        Inventory.addPart(new InHousePart(++id, name, price, stock, min, max, machineId));
                    } else {
                        Inventory.addPart(new OutSourcedPart(++id, name, price, stock, min, max, companyName));
                    }
                    stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                    scene = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
                    stage.setScene(new Scene(scene));
                    stage.show();
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
                Inventory.warningScreen("Warning", "Error", "One or More Fields are Empty");
            }

        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
