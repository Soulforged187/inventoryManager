package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AddProduct  implements Initializable {

    Parent scene;
    Stage stage;

    @FXML
    private TableView <Part> tableViewAddProductAdd;
    @FXML
    private TableColumn<Part, Integer> tableViewAddProductAddIDColumn;
    @FXML
    private TableColumn <Part, String>tableViewAddProductAddNameColumn;
    @FXML
    private TableColumn <Part, Integer>tableViewAddProductAddInvColumn;
    @FXML
    private TableColumn <Part, Double>tableViewAddProductAddPriceColumn;
    @FXML
    private TableView <Product> tableViewAddProductDelete;
    @FXML
    private TableColumn <Product, Integer> tableViewAddProductDeleteIDColumn;
    @FXML
    private TableColumn <Product, String>tableViewAddProductDeleteNameColumn;
    @FXML
    private TableColumn <Product, Integer>tableViewAddProductDeleteInvColumn;
    @FXML
    private TableColumn <Product, Double> tableViewAddProductDeletePriceColumn;
    @FXML
    private Label textFieldAddIdn;
    @FXML
    private TextField textFieldAddName;
    @FXML
    private TextField textFieldAddInventory;
    @FXML
    private TextField textFieldAddPrice;
    @FXML
    private TextField textFieldAddMin;
    @FXML
    private TextField textFieldAddMax;
    int id;
    @FXML
    private ObservableList<Part> selectedParts = FXCollections.observableArrayList();

    @FXML
    void saveProductHandler(ActionEvent actionEvent)throws IOException{
     /*  String productName = textFieldAddName.getText();
        String productInventory = textFieldAddInventory.getText();
        String productCost = textFieldAddPrice.getText();
        String productMax = textFieldAddMax.getText();
        String productMin = textFieldAddMin.getText();


        if (productName == null || productName.length() == 0 || productInventory == null ||
                productInventory.length() == 0 || productCost == null || productCost.length() == 0 ||
                productMax.length() == 0 || productMin.length() == 0 ) {

            Inventory.warningScreen("Warning","Check Fields","Fields cannot be blank, Inputs must be correct type");
        }

        else {

            try {
                String name = textFieldAddName.getText();
                double price = Double.parseDouble(textFieldAddPrice.getText());
                int stock = Integer.parseInt(textFieldAddInventory.getText());
                int max = Integer.parseInt(textFieldAddMax.getText());
                int min = Integer.parseInt(textFieldAddMin.getText());


                if (stock < min || stock > max) {

                    Inventory.warningScreen("Warning", "Check Inv/Min/Max", "Min Cannot be Greater than Max, Inventory cannot exceed Max");
                } else {

                    if (selectedParts.size() == 0){
                        Inventory.warningScreen("Error", "No Part was Selected.", "Please choose a part from the list");}
                    else {
                        Product newProduct= (new Product(++id, name, price, stock, min, max));

                         for (Part selectedParts : selectedParts) {
                           Product.addAssociatedParts(selectedParts);
                        }
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


    public void addProductCancelHandler(ActionEvent actionEvent) throws IOException {
        Inventory.confirmationScreen("Cancel", "Are you sure you want to Cancel?");
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewAddProductAddIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableViewAddProductAddNameColumn.setCellValueFactory((new PropertyValueFactory<>("name")));
        tableViewAddProductAddInvColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tableViewAddProductAddPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableViewAddProductDelete.setItems(Inventory.getAllProducts());
        tableViewAddProductDeleteIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableViewAddProductDeleteNameColumn.setCellValueFactory((new PropertyValueFactory<>("name")));
        tableViewAddProductDeleteInvColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tableViewAddProductDeletePriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableViewAddProductAdd.setItems(Inventory.getAllParts());
    }


}