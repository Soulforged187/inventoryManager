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


public class ModifyProduct implements Initializable {
    Parent scene;
    Stage stage;

    @FXML
    private TableView<Part> tableViewModifyProductAdd;
    @FXML
    private TableColumn<Part, Integer>tableViewModifyProductAddIDColumn;
    @FXML
    private TableColumn<Part, String> tableViewModifyProductAddNameColumn;
    @FXML
    private TableColumn <Part, Integer> tableViewModifyProductAddInvColumn;

    @FXML
    private TableView <Part>tableViewModifyProductDelete;
    @FXML
    private TableColumn <Part, Double>tableViewModifyProductAddPriceColumn;
    @FXML
    private TableColumn <Part,String>tableViewModifyProductDeleteNameColumn;
    @FXML
    private TableColumn <Part, Integer>tableViewModifyProductDeleteInvColumn;
    @FXML
    private TableColumn<Part, Double> tableViewModifyProductDeletePriceColumn;
    @FXML
    private TableColumn  <Part, Integer> tableViewModifyProductDeleteIDColumn;





    public void modifyProductCancelHandler(ActionEvent actionEvent) throws IOException {
        Inventory.confirmationScreen("Cancel", "Are you sure you want to Cancel?");
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

    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewModifyProductAddIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableViewModifyProductAddNameColumn.setCellValueFactory((new PropertyValueFactory<>("name")));
        tableViewModifyProductAddInvColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tableViewModifyProductAddPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableViewModifyProductAdd.setItems(Inventory.getAllParts());
        tableViewModifyProductDeleteIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableViewModifyProductDeleteNameColumn.setCellValueFactory((new PropertyValueFactory<>("name")));
        tableViewModifyProductDeleteInvColumn .setCellValueFactory(new PropertyValueFactory<>("stock"));
        tableViewModifyProductDeletePriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableViewModifyProductDelete.setItems(Inventory.getAllParts());
    }
}
