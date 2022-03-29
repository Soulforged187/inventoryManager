package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProduct implements Initializable {
    Stage stage;
    Parent scene;

    @FXML
    private TableView<Product> tableViewModifyProductAdd;
    @FXML
    private TableColumn<Product, Integer>tableViewModifyProductAddIDColumn;
    @FXML
    private TableColumn<Product, String> tableViewModifyProductAddNameColumn;
    @FXML
    private TableColumn <Product, Integer> tableViewModifyProductAddInvColumn;

    @FXML
    private TableView <Product>tableViewModifyProductDelete;
    @FXML
    private TableColumn <Product, Double>tableViewModifyProductAddPriceColumn;
    @FXML
    private TableColumn tableViewModifyProductDeleteNameColumn;
    @FXML
    private TableColumn tableViewModifyProductDeleteInvColumn;
    @FXML
    private TableColumn<Product, Double> tableViewModifyProductDeletePriceColumn;
    @FXML
    private TableColumn tableViewModifyProductDeleteIDColumn;


    @FXML
    private Button buttonAddProductClear;
    @FXML
    private Button buttonModifyProductAdd;
    @FXML
    private Button buttonModifyProductCancel;
    @FXML
    private Button buttonModifyProductSave;
    @FXML
    private Button buttonModifyProductSearch;
    @FXML
    private Button buttonModifyProductDelete;

    @FXML
    private TextField textModifyProductSearch;
    @FXML
    private TextField textFieldModifyProductName;
    @FXML
    private TextField textFieldModifyProductInv;
    @FXML
    private TextField textFieldModifyProductPrice;
    @FXML
    private TextField textFieldModifyProductMin;
    @FXML
    private TextField textFieldModifyProductMax;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
