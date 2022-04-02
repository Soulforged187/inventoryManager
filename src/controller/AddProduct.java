package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AddProduct  implements Initializable {
    Parent scene;
    Stage stage;

    @FXML
    private TableView <Product> tableViewAddProductAdd;
    @FXML
    private TableColumn<Product, Integer> tableViewAddProductAddIDColumn;
    @FXML
    private TableColumn <Product, String>tableViewAddProductAddNameColumn;
    @FXML
    private TableColumn <Product, Integer>tableViewAddProductAddInvColumn;
    @FXML
    private TableColumn <Product, Double>tableViewAddProductAddPriceColumn;
    @FXML
    private TableView <Part> tableViewAddProductDelete;
    @FXML
    private TableColumn <Part, Integer> tableViewAddProductDeleteIDColumn;
    @FXML
    private TableColumn <Part, String>tableViewAddProductDeleteNameColumn;
    @FXML
    private TableColumn <Part, Integer>tableViewAddProductDeleteInvColumn;
    @FXML
    private TableColumn <Part, Double> tableViewAddProductDeletePriceColumn;




    public void addProductCancelHandler(ActionEvent actionEvent) throws IOException {
        Inventory.confirmationScreen("Cancel", "Are you sure you want to Cancel?");
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
