package controller;

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
import model.Inventory;
import model.Part;
import model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// largest errors were caused by simple things such as forgetting @FXML  before a tab causing all views to fail and stop the program from compiling, other common errors included missing \ for views
//  logic errors:

public class MainPage implements Initializable {
    Stage stage;
    Parent scene;

    // table view Part
    @FXML
    private TableView<Part> tableViewParts;
    @FXML
    private TableColumn<Part, Integer> tableViewPartsIDColumn;
    @FXML
    private TableColumn<Part, String> tableViewPartsNameColumn;
    @FXML
    private TableColumn<Part, Integer> tableViewPartsInvColumn;
    @FXML
    private TableColumn<Part, Double> tableViewPartsPriceColumn;

    // table view Product
    @FXML
    private TableView<Product> tableViewProducts;
    @FXML
    private TableColumn<Product, Integer> tableViewProductsIDColumn;
    @FXML
    private TableColumn<Product, String> tableViewProductsNameColumn;
    @FXML
    private TableColumn<Product, Integer> tableViewProductsInvColumn;
    @FXML
    private TableColumn<Product, Double> tableViewProductsPriceColumn;
    // search fields
    @FXML
    private TextField textFieldSearchParts;
    @FXML
    private TextField textFieldSearchProducts;



    //Buttons
    @FXML
    private void addPartHandler(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    //checks to see if a part is selected, if none is found then the Warning screen function is called, if however one is selected then the stage is set to Modify Parts screen.
    @FXML
    private void modifyPartHandler(ActionEvent actionEvent) throws IOException {
        Part selectedPart = tableViewParts.getSelectionModel().getSelectedItem();
        if (selectedPart == null) {
            Inventory.warningScreen("Error", "No Part was Selected.", "Please choose a part from the list");
        } else {
            stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/ModifyParts.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }
    // exits the program
    @FXML
    private void exitHandler(ActionEvent event) {
        System.out.println("Exiting Program");
        System.exit(0);
    }
    // opens the Add Product View
    @FXML
    private void addProductsHandler(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    //checks to see if a part is selected, if none is found then the Warning screen function is called, if however one is selected then the stage is set to Modify Products screen.
    @FXML
    private void modifyProductsHandler(ActionEvent actionEvent) throws IOException {
            Product selectedProduct = tableViewProducts.getSelectionModel().getSelectedItem();
            if (selectedProduct == null) {
                Inventory.warningScreen("Error", "No Product was Selected.", "Please choose a product from the list");
            }
            else {
                stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/view/ModifyProducts.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
            }


    }
    //Deletes the selected part.
    public void deletePartHandler(ActionEvent actionEvent) throws IOException {
        if(tableViewParts.getSelectionModel().isEmpty()) {
            Inventory.warningScreen("Error", "No Part was Selected", "Please choose a part from the list");
        }
        if(Inventory.confirmationScreen("Delete selected", "Are you sure you want to delete this part?")){
            Part selectedPart = tableViewParts.getSelectionModel().getSelectedItem();
            Inventory.deletePart(selectedPart);

        }
    }
    //Deletes the selected product.
    public void deleteProductHandler(ActionEvent actionEvent) {
        if (tableViewProducts.getSelectionModel().isEmpty()) {
            Inventory.warningScreen("Error", "No Part was Selected", "Please choose a part from the list");
        }
        if (Inventory.confirmationScreen("Delete selected", "Are you sure you want to delete this part?")) {
            Product selectedProduct = tableViewProducts.getSelectionModel().getSelectedItem();
            Inventory.deleteProduct(selectedProduct);

        }
    }

    //search is functioning correctly, it searches through the product list by first reading the string  in the text-field,  then if any part of the string is found it will remake the table and add the found products to the table,
    // If a number is instead entered it will display products with the same ID but
    // only if the ID is an exact match.
    public void runProductsSearchHandler(ActionEvent actionEvent) {
        String query = textFieldSearchProducts.getText();
        ObservableList<Product> products = Inventory.lookUpProduct(query);
        if(products.size() == 0){
            try {
                int productId = Integer.parseInt(query);
                Product product = Inventory.lookUpProduct(productId);
                if(product != null){

                    tableViewProducts.getSelectionModel().select(product);
                    return;
                }
                Inventory.warningScreen("ID was not found","Valid ID not entered","Entered Product Name or ID" );
                return;
            }
            catch (NumberFormatException ignored){
                tableViewProducts.getSelectionModel().clearSelection();
                tableViewProducts.setItems(products);
            }
        }
        tableViewProducts.setItems(products);
        tableViewProducts.getSelectionModel().clearSelection();
    }
    //search is functioning correctly, it searches through the product list by first reading the string  in the text-field,  then if any part of the string is found it will remake the table and add the found products to the table,
    // If a number is instead entered it will display products with the same ID but
    // only if the ID is an exact match.
    public void runPartsSearchHandler(ActionEvent actionEvent) {
            String query = textFieldSearchParts.getText();
            ObservableList<Part> parts = Inventory.lookUpPart(query);
            if(parts.size() == 0){
                try {
                    int partID = Integer.parseInt(query);
                    Part part = Inventory.lookUpPart(partID);
                    if(part != null){

                        tableViewParts.getSelectionModel().select(part);
                        return;
                    }
                    Inventory.warningScreen("ID was not found","Valid ID not entered","Entered Product Name or ID" );
                    return;
                }
                catch (NumberFormatException ignored){
                    tableViewParts.getSelectionModel().clearSelection();
                    tableViewParts.setItems(parts);
                }
            }
            tableViewParts.setItems(parts);
            tableViewParts.getSelectionModel().clearSelection();
        }



    //initialize

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Controller Initialized");
        tableViewPartsIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableViewPartsNameColumn.setCellValueFactory((new PropertyValueFactory<>("name")));
        tableViewPartsInvColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tableViewPartsPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableViewParts.setItems(Inventory.getAllParts());

        tableViewProductsIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableViewProductsNameColumn.setCellValueFactory((new PropertyValueFactory<>("name")));
        tableViewProductsInvColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tableViewProductsPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableViewProducts.setItems(Inventory.getAllProducts());
    }



}

