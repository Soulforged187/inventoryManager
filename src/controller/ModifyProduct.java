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
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProduct {
    Parent scene;
    Stage stage;

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


    public void modifyProductCancelHandler(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert");
        alert.setContentText("Are you sure you want to cancel?");
        alert.showAndWait();
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void addProductsModifyHandler(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
}
