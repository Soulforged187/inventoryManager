package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

// logical modelling for arrays, adding parts to array, adding products to arrays, looking up parts, removing from arrays.
public class Inventory {
    //arrays
    private static final ObservableList<Product> productInventory = FXCollections.observableArrayList();
    private static final ObservableList<Part> partInventory = FXCollections.observableArrayList();
    //getter for parts in array
    public static ObservableList<Part> getAllParts() {
        return partInventory;
    }
    //getter for products in array
    public static ObservableList<Product> getAllProducts() {
        return productInventory;
    }
    // add parts to an array
    public static void addPart(Part newPart) {
        partInventory.add(newPart);
    }
    // add products to an array
    public static void addProduct(Product newProduct) {
        productInventory.add(newProduct);

    }
   // search and return parts in array based on id .
    public static Part lookUpPart(int partId) {
        for (Part part : partInventory) {
            if (part.getId() == partId) {
                return part;
            }
        }
        return null;
    }
   // search and return products in array based on id.
    public static Product lookUpProduct(int productId) {
        for (Product product : productInventory) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
    // search and return products in array based on name.
    public static ObservableList<Product> lookUpProduct(String productName) {
        ObservableList<Product> nameProduct = FXCollections.observableArrayList();
        ObservableList<Product> productInventory = getAllProducts();

        for (Product foundProduct : productInventory) {
            if (foundProduct.getName().contains(productName)) {
                nameProduct.add(foundProduct);

            }
        }
        return nameProduct;
    }
    // search and return parts in array based on name.
    public static ObservableList<Part> lookUpPart(String partName) {
        ObservableList<Part> namePart = FXCollections.observableArrayList();
        ObservableList<Part> partInventory = getAllParts();

        for (Part foundPart : partInventory) {
            if (foundPart.getName().contains(partName)) {
                namePart.add(foundPart);

            }
        }
        return namePart;
    }
    //update part and set index (id) primary key
    public static void updatePart(int index, Part selectedPart) {
        partInventory.set(index, selectedPart);
    }
    //update product and set index (id) primary key
    public static void updateProduct(int index, Product selectedProduct) {
        productInventory.set(index, selectedProduct);
    }
    //remove product based on ID
    public static void deleteProduct(Product selectedProduct) {
        Product productDelete = lookUpProduct(selectedProduct.getId());
        productInventory.remove(productDelete);
    }
     // delete part based on ID
    public static void deletePart(Part selectedPart) {
        Part partDelete = lookUpPart(selectedPart.getId());
        partInventory.remove(partDelete);
    }
  // confirmation screen function set to allow different alerts and get user confirmation
   public static boolean confirmationScreen(String title,  String content){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText("Confirm ?");
        alert.setContentText(content);
        Optional<ButtonType> result=alert.showAndWait();
        return result.get() == ButtonType.OK;
    }
   // Warning screen function designed to allow different warnings based on the error or to inform the user what inputs are required for validations.
    public static void warningScreen(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        Optional<ButtonType> result=alert.showAndWait();

    }
}

