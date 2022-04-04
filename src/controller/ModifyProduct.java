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


public class ModifyProduct implements Initializable {
    int index;
    Parent scene;
    Stage stage;

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
    @FXML
    private TableView<Part> tableViewModifyProductAdd;
    @FXML
    private TableColumn<Part, Integer>tableViewModifyProductAddIDColumn;
    @FXML
    private TableColumn<Part, String> tableViewModifyProductAddNameColumn;
    @FXML
    private TableColumn <Part, Integer> tableViewModifyProductAddInvColumn;
  @FXML
    private TextField textFieldSearchProduct;
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
    @FXML
    private Label modifyProductId;
    @FXML
    private ObservableList<Part> selectedPartsOfProducts = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Part> deletedPartsOfProducts = FXCollections.observableArrayList();
    private Product product;

    @FXML
    void modifyProductSaveHandler(ActionEvent actionEvent)throws IOException{
    String partName = textFieldModifyProductName.getText();
    String partInventory = textFieldModifyProductInv.getText();
    String partCost = textFieldModifyProductPrice.getText();
    String partMin = textFieldModifyProductMin.getText();
    String partMax = textFieldModifyProductMax.getText();

        if (partName == null || partName.length() == 0 || partInventory == null ||
            partInventory.length() == 0 || partCost == null || partCost.length() == 0 ||
            partMax.length() == 0 || partMin.length() == 0)
    {

        Inventory.warningScreen("Warning","One or more blank Fields","Fields cannot be blank");
    }

        else {

        try {
            int id = Integer.parseInt(modifyProductId.getText());
            String name = textFieldModifyProductName.getText();
            double price = Double.parseDouble(textFieldModifyProductInv.getText());
            int stock = Integer.parseInt(textFieldModifyProductPrice.getText());
            int min = Integer.parseInt(textFieldModifyProductMin.getText());
            int max = Integer.parseInt(textFieldModifyProductMax.getText());

            if (stock < min || stock > max) {

                Inventory.warningScreen("Warning", "Check Min/Max", "Min Cannot be Greater than Max");
            } else {

                Product newProduct = new Product(id,name,price,stock,min,max);


                for (Part selectedPartsOfProducts:selectedPartsOfProducts){
                    newProduct.addAssociatedParts((selectedPartsOfProducts));
                }
                for (Part deletedPartsOfProducts:deletedPartsOfProducts){
                    newProduct.deleteAssociatedPart(deletedPartsOfProducts);

                }
                Inventory.updateProduct(index, product);
                stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();

            }

        } catch(NumberFormatException e) {
            Inventory.warningScreen("Warning", "Error", "One or More Fields are Empty");
        }

    }
}


    public void modifyProductCancelHandler(ActionEvent actionEvent) throws IOException {
        Inventory.confirmationScreen("Cancel", "Are you sure you want to Cancel?");
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void addProductsModifyHandler(ActionEvent actionEvent) throws IOException {
        Part selectedPart = tableViewModifyProductAdd.getSelectionModel().getSelectedItem();
        if (selectedPart==null){
            Inventory.warningScreen("Warning","You must select a part" , " Select a part from the top table");
        }
        else {
            selectedPartsOfProducts.add(selectedPart);
        }
    }


    public void modifyDeleteHandler(ActionEvent actionEvent) {
        if(tableViewModifyProductDelete.getSelectionModel().isEmpty()) {
            Inventory.warningScreen("Error", "No Part was Selected", "Please choose a part from the list");
        }
        if(Inventory.confirmationScreen("Delete selected", "Are you sure you want to delete this part?")){
            Part selectedPart = tableViewModifyProductDelete.getSelectionModel().getSelectedItem();
            Inventory.deletePart(selectedPart);

        }
    }
    public void runModifyProductSearch(ActionEvent actionEvent) { String query = textFieldSearchProduct.getText();
        ObservableList<Part> parts = Inventory.lookUpPart(query);
        if(parts.size() == 0){
            try {
                int partID = Integer.parseInt(query);
                Part part = Inventory.lookUpPart(partID);
                if(part != null){

                    tableViewModifyProductAdd.getSelectionModel().select(part);
                    return;
                }
                Inventory.warningScreen("ID was not found","Valid ID not entered","Entered Product Name or ID" );
                return;
            }
            catch (NumberFormatException ignored){
                tableViewModifyProductAdd.getSelectionModel().clearSelection();
                tableViewModifyProductAdd.setItems(parts);
            }
        }
        tableViewModifyProductAdd.setItems(parts);
        tableViewModifyProductAdd.getSelectionModel().clearSelection();
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
        tableViewModifyProductDelete.setItems(selectedPartsOfProducts);

        Product product = Inventory.getAllProducts().get(index);
        int productId = Inventory.getAllProducts().get(index).getId();
        modifyProductId.setText("Auto-Gen: " + productId);
        textFieldModifyProductName.setText(product.getName());
        textFieldModifyProductInv.setText(Integer.toString(product.getStock()));
        textFieldModifyProductPrice.setText(Double.toString(product.getPrice()));
        textFieldModifyProductMin.setText(Integer.toString(product.getMin()));
        textFieldModifyProductMax.setText(Integer.toString(product.getMax()));

    }


}
