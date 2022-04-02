package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.InHousePart;
import model.Inventory;
import model.OutSourcedPart;

import java.io.IOException;


public class ModifyPart  {

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
      private Label modifyId;

      @FXML
      void radioModifyPartInHouse(ActionEvent actionEvent){
          labelModifyPartName.setText("Machine ID");
        textFieldModifyPartDyn.setPromptText("Machine ID");
        radioModifyPartOut.setSelected(false);
    }
    @FXML
    void radioModifyPartOutsourced (ActionEvent actionEvent){
        labelModifyPartName.setText("Company Name");
        textFieldModifyPartDyn.setPromptText("Company Name");
        radioModifyPartIn.setSelected(false);
    }


    void buttonSaveHandler(ActionEvent actionEvent)throws IOException{
   /*     String partName = textFieldModifyPartName.getText();
        String partInventory = textFieldModifyPartInv.getText();
        String partCost = textFieldModifyPartPrice.getText();
        String partMax = textFieldModifyPartMin.getText();
        String partMin = textFieldModifyPartMax.getText();
        String partCompanyName = textFieldModifyPartDyn.getText();

        if (partName == null || partName.length() == 0 || partInventory == null ||
                partInventory.length() == 0 || partCost == null || partCost.length() == 0 ||
                partMax.length() == 0 || partMin.length() == 0 ||
                partCompanyName == null || partCompanyName.length() == 0) {

            Inventory.warningScreen("Warning","One or more blank Fields","Fields cannot be blank");
        }

        else {

            try {
               int id = Integer.parseInt(modifyId.getText());
                String name = textFieldModifyPartName.getText();
                double price = Double.parseDouble(textFieldModifyPartInv.getText());
                int stock = Integer.parseInt(textFieldModifyPartPrice.getText());
                int max = Integer.parseInt(textFieldModifyPartMin.getText());
                int min = Integer.parseInt(textFieldModifyPartMax.getText());
                String companyName = textFieldModifyPartDyn.getText();

                if (stock < min || stock > max) {

                    Inventory.warningScreen("Warning", "Check Min/Max", "Min Cannot be Greater than Max");
                } else {

                    if (radioModifyPartIn.isSelected()) {
                        int machineId = Integer.parseInt(textFieldModifyPartDyn.getText());
                        Inventory.addPart(new InHousePart(++id,name, price, stock, min, max,machineId ));
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

        }*/
    }


        public void modifyPartCancelHandler(ActionEvent actionEvent)throws IOException{
            Inventory.confirmationScreen("Cancel","Are you sure you want to Cancel?");
               stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
               scene = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
               stage.setScene(new Scene(scene));
               stage.show();
        }



}
