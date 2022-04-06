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

// This is the controller to Modify Products, built with the ability to change data within the ProductInventory array,
// can associate parts to a product, remove parts,  search functionality.
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
    private final ObservableList<Part> deletedPartsOfProducts = FXCollections.observableArrayList();
    private Product product;

    //Save handler for Modifying Products was designed this way to ensure an easy logical flow, first it will check if the fields have been filled with a warning screen to prompt the user in the instance of empty data.
    // Next it will check the fields to fill temporary variables, then check to ensure Min and Max are logically filled and that current stock is following set conventions.
    //Also, will allow the user to associate parts used to construct a product.
    // IDs are auto generated to ensure strong primary keys.
    // A catch statement is added to ensure the program won't crash in instance that are not anticipated.
    @FXML
    void modifyProductSaveHandler(ActionEvent actionEvent)throws IOException {
            String partName = textFieldModifyProductName.getText();
            String partInventory = textFieldModifyProductInv.getText();
            String partCost = textFieldModifyProductPrice.getText();
            String partMin = textFieldModifyProductMin.getText();
            String partMax = textFieldModifyProductMax.getText();


            if (partName == null || partName.length() == 0 || partInventory == null ||
                    partInventory.length() == 0 || partCost == null || partCost.length() == 0 ||
                    partMax.length() == 0 || partMin.length() == 0) {

                Inventory.warningScreen("Warning", "One or more blank Fields", "Fields cannot be blank");
            }else{
                try {
                    int id = Integer.parseInt(modifyProductId.getText());
                    String name = textFieldModifyProductName.getText();
                    double price = Double.parseDouble(textFieldModifyProductPrice.getText());
                    int stock = Integer.parseInt(textFieldModifyProductInv.getText());
                    int min = Integer.parseInt(textFieldModifyProductMin.getText());
                    int max = Integer.parseInt(textFieldModifyProductMax.getText());

                    if (stock < min || stock > max) {

                        Inventory.warningScreen("Warning", "Check Min/Max", "Min Cannot be Greater than Max");
                    } else {

                        Product newProduct = new Product(id, name, price, stock, min, max);

                        for (Part selectedProductPart : selectedPartsOfProducts) {
                            newProduct.addAssociatedParts(selectedProductPart);
                        }
                        for (Part deletedPartsOfProducts : deletedPartsOfProducts) {
                            newProduct.deleteAssociatedPart(deletedPartsOfProducts);
                        }
                        Inventory.updateProduct(index, product);
                        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                        scene = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
                        stage.setScene(new Scene(scene));
                        stage.show();

                    }

                } catch (NumberFormatException e) {
                    Inventory.warningScreen("Warning", "Error", "One or More Fields are Empty, Or Have the wrong Data Type");
                    e.printStackTrace();
                }

            }
    }
// Allows the user to cancel the actions taken in screen and return to the Main Page.
    public void modifyProductCancelHandler(ActionEvent actionEvent) throws IOException {
        Inventory.confirmationScreen("Cancel", "Are you sure you want to Cancel?");
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
   // Allows the user to add associated parts from the top table to the associated table on the bottom.
    public void addProductsModifyHandler(ActionEvent actionEvent) throws IOException {
        Part selectedPart = tableViewModifyProductDelete.getSelectionModel().getSelectedItem();
        if (selectedPart==null){
            Inventory.warningScreen("Warning","You must select a part" , " Select a part from the top table");
        }
        else {
            Part selectedPar = tableViewModifyProductDelete.getSelectionModel().getSelectedItem();
            selectedPartsOfProducts.add(selectedPar);
            tableViewModifyProductDelete.setItems(product.getAllAssociatedParts());
        }
    }

   // Allows the user to delete associated parts, essentially de-associating them from the Product.
    public void modifyDeleteHandler(ActionEvent actionEvent) {
        Part removePart = tableViewModifyProductDelete.getSelectionModel().getSelectedItem();
        if(tableViewModifyProductDelete.getSelectionModel().isEmpty()) {
            Inventory.warningScreen("Error", "No Part was Selected", "Please choose a part from the list");
        }
        if(Inventory.confirmationScreen("Delete selected", "Are you sure you want to delete this part?")){
            selectedPartsOfProducts.remove(removePart);
            deletedPartsOfProducts.add(removePart);
        }
    }
    // Allows the user to run a search based on the parts in the fields either by partial names, or full ID.
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
// sends the data to the fields based on the selected product on the previous screen.
    public void sendSelectedProduct (Product selectedProduct){
        modifyProductId.setText(String.valueOf(selectedProduct.getId()));
        textFieldModifyProductName.setText(selectedProduct.getName());
        textFieldModifyProductInv.setText(String.valueOf(selectedProduct.getStock()));
        textFieldModifyProductPrice.setText(String.valueOf(selectedProduct.getPrice()));
        textFieldModifyProductMin.setText(String.valueOf(selectedProduct.getMin()));
        textFieldModifyProductMax.setText(String.valueOf(selectedProduct.getMax()));
        product=selectedProduct;
        selectedPartsOfProducts = product.getAllAssociatedParts();
        tableViewModifyProductDelete.setItems(selectedPartsOfProducts);

}

// sends data to the table views from previous information on other screens.
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


    }


}
