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

    @FXML
    private void modifyPartHandler(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/ModifyParts.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    private void exitHandler(ActionEvent event) {
        System.out.println("Exiting Program");
        System.exit(0);
    }

    @FXML
    private void addProductsHandler(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    private void modifyProductsHandler(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/ModifyProducts.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void deletePartHandler(ActionEvent actionEvent) throws IOException {
      /*  Part selectedPart = tableViewParts.getSelectionModel().getSelectedItem();

       if (selectedPart == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("A part must be selected to delete");
        }

        else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Part Deletion");
            alert.setHeaderText("Confirm Deletion?");
            alert.setContentText("Are you sure you want to delete?");
            alert.showAndWait();
        }
        */

    }

    public void deleteProductHandler(ActionEvent actionEvent) {
    }

    public void runClearPartsHandler(ActionEvent actionEvent) {
    }

    public void clearProductsHandler(ActionEvent actionEvent) {
    }
//untested
    public void runProductsSearchHandler(ActionEvent actionEvent) {
        String q = textFieldSearchProducts.getText();
        ObservableList<Product> products=Inventory.lookUpProduct(q);
        tableViewProducts.setItems(products);
        textFieldSearchProducts.setText("");
    }

    public void runPartsSearchHandler(ActionEvent actionEvent) {

        String q = textFieldSearchParts.getText();
        ObservableList<Part> parts=Inventory.lookUpPart(q);
        tableViewParts.setItems(parts);
        textFieldSearchParts.setText("");
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

