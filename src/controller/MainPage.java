package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Part;
import model.Product;

import java.net.URL;
import java.util.ResourceBundle;


public class MainPage implements Initializable {
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
    private Button buttonAddParts;
    @FXML
    private Button buttonModifyParts;
    @FXML
    private Button buttonDeleteParts;
    @FXML
    private Button buttonAddProducts;
    @FXML
    private Button buttonModifyProducts;
    @FXML
    private Button buttonDeleteProducts;
    @FXML
    private Button buttonClearSearchParts;
    @FXML
    private Button buttonClearSearchProducts;
    @FXML
    public void exitHandler(ActionEvent event){
        System.out.println("Exiting Program");
        System.exit(0);
    }
    @FXML
    private Button buttonSearchParts;
    @FXML
    private Button buttonSearchProducts;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Controller Initialized");

    }


    public void addPartHandler(ActionEvent actionEvent) {
    }

    public void modifyPartHandler(ActionEvent actionEvent) {
    }

    public void deletePart(ActionEvent actionEvent) {
    }

    public void addProductsHandler(ActionEvent actionEvent) {
    }

    public void modfiyPartsHandler(ActionEvent actionEvent) {
    }

    public void deleteProductHandler(ActionEvent actionEvent) {
    }

    public void runClearPartsHandler(ActionEvent actionEvent) {
    }

    public void clearProductsHandler(ActionEvent actionEvent) {
    }

    public void runProductsSearchHandler(ActionEvent actionEvent) {
    }

    public void runPartsSearchHandler(ActionEvent actionEvent) {
    }
}

