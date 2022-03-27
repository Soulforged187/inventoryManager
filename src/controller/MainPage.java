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
    // Labels, actions not required
    @FXML
    private Label labelParts;
    @FXML
    private Label labelProducts;
    @FXML
    private Label inventoryManagementSystemMain;
    // anchor
    @FXML
    private AnchorPane root;

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
    private Button buttonExitProgram;
    @FXML
    private Button buttonSearchParts;
    @FXML
    private Button buttonSearchProducts;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Controller Initialized");

    }


}

