package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.InHousePart;
import model.Inventory;
import model.OutSourcedPart;
import model.Part;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ModifyPart implements Initializable {

    Parent scene;
    Stage stage;

    @FXML
    private RadioButton radioModifyPartIn;
    @FXML
    private RadioButton radioModifyPartOut;
    @FXML
    private TextField textFieldModifyPartDyn;
    @FXML
    private Label labelModifyPartName;
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
    private Label modifyPartId;
    int index;

    @FXML
    void radioModifyPartInHouse(ActionEvent actionEvent) {
        labelModifyPartName.setText("Machine ID");
        textFieldModifyPartDyn.setPromptText("Machine ID");
        radioModifyPartOut.setSelected(false);
    }

    @FXML
    void radioModifyPartOutsourced(ActionEvent actionEvent) {
        labelModifyPartName.setText("Company Name");
        textFieldModifyPartDyn.setPromptText("Company Name");
        radioModifyPartIn.setSelected(false);
    }


    @FXML
    void saveModifyPartHandler(ActionEvent actionEvent) throws IOException {
        String partName = textFieldModifyPartName.getText();
        String partInventory = textFieldModifyPartInv.getText();
        String partCost = textFieldModifyPartPrice.getText();
        String partMin = textFieldModifyPartMin.getText();
        String partMax = textFieldModifyPartMax.getText();
        String partCompanyName = textFieldModifyPartDyn.getText();

        if (partName == null || partName.length() == 0 || partInventory == null ||
                partInventory.length() == 0 || partCost == null || partCost.length() == 0 ||
                partMax.length() == 0 || partMin.length() == 0 ||
                partCompanyName == null || partCompanyName.length() == 0) {

            Inventory.warningScreen("Warning", "One or more blank Fields", "Fields cannot be blank");
        } else {

            try {
                int id = Integer.parseInt(modifyPartId.getText());
                String name = textFieldModifyPartName.getText();
                int stock = Integer.parseInt(textFieldModifyPartInv.getText());
                double price = Double.parseDouble(textFieldModifyPartPrice.getText());
                int min = Integer.parseInt(textFieldModifyPartMin.getText());
                int max = Integer.parseInt(textFieldModifyPartMax.getText());
                String companyName = textFieldModifyPartDyn.getText();

                if (stock < min || stock > max) {

                    Inventory.warningScreen("Warning", "Check Min/Max", "Min Cannot be Greater than Max");
                } else {

                    if (radioModifyPartOut.isSelected()) {
                        OutSourcedPart outSourcedPart = new OutSourcedPart(id, name, price, stock, max, min, companyName);
                        outSourcedPart.setId(id);
                        outSourcedPart.setName(name);
                        outSourcedPart.setPrice(price);
                        outSourcedPart.setStock(stock);
                        outSourcedPart.setMax(max);
                        outSourcedPart.setMin(min);
                        outSourcedPart.setCompanyName(companyName);

                        Inventory.updatePart(index, outSourcedPart);
                    } else {
                        int machineID = Integer.parseInt(textFieldModifyPartDyn.getText());
                        InHousePart inHousePart = new InHousePart(id, name, price, stock, max, min, machineID);
                        inHousePart.setId(id);
                        inHousePart.setName(name);
                        inHousePart.setPrice(price);
                        inHousePart.setStock(stock);
                        inHousePart.setMax(max);
                        inHousePart.setMin(min);
                        inHousePart.setMachineId(machineID);

                        Inventory.updatePart(index, inHousePart);
                    }
                    stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                    scene = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
                    stage.setScene(new Scene(scene));
                    stage.show();

                }

            } catch (NumberFormatException e) {
                Inventory.warningScreen("Warning", "Error", "One or More Fields are Empty");
                e.printStackTrace();
            }

        }
    }

    public void modifyPartCancelHandler(ActionEvent actionEvent) throws IOException {
        Inventory.confirmationScreen("Cancel", "Are you sure you want to Cancel?");
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void sendSelectedPart (Part selectedPart){
        modifyPartId.setText(String.valueOf(selectedPart.getId()));
        textFieldModifyPartName.setText(selectedPart.getName());
        textFieldModifyPartInv.setText(String.valueOf(selectedPart.getStock()));
        textFieldModifyPartPrice.setText(String.valueOf(selectedPart.getPrice()));
        textFieldModifyPartMin.setText(String.valueOf(selectedPart.getMin()));
        textFieldModifyPartMax.setText(String.valueOf(selectedPart.getMax()));
        if (selectedPart instanceof InHousePart) {
            labelModifyPartName.setText("Machine ID");
            textFieldModifyPartDyn.setText(Integer.toString(((InHousePart) Inventory.getAllParts().get(index)).getMachineId()));
            radioModifyPartIn.setSelected(true);
        } else {
            labelModifyPartName.setText("Company Name");
            textFieldModifyPartDyn.setText(((OutSourcedPart) Inventory.getAllParts().get(index)).getCompanyName());
            radioModifyPartOut.setSelected(true);
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}