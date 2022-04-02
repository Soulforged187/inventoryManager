package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;
import java.io.IOException;


public class ModifyProduct {
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
}
