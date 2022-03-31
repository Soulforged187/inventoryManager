package model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static final ObservableList<Product> productInventory = FXCollections.observableArrayList();
    private static final ObservableList<Part> partInventory = FXCollections.observableArrayList();

    public static ObservableList<Part> getAllParts() {
        return partInventory;
    }

    public static ObservableList<Product> getAllProducts() {
        return productInventory;
    }

    public static void addPart(Part newPart) {
        partInventory.add(newPart);
    }

    public static void addProduct(Product newProduct) {
        productInventory.add(newProduct);

    }

    public static Part lookUpPart(int partId) {
        for (Part part : partInventory) {
            if (part.getId() == partId) {
                return part;
            }
        }
        return null;
    }

    public static Product lookUpProduct(int productId) {
        for (Product product : productInventory) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

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

    public static void updatePart(int index, Part selectedPart) {
        partInventory.set(index, selectedPart);
    }

    public static void updateProduct(int index, Product selectedProduct) {
        productInventory.set(index, selectedProduct);
    }

    public static boolean deleteProduct(Product selectedProduct) {
        Product productDelete = lookUpProduct(selectedProduct.getId());

        if (productDelete == null) {
            System.out.println(lookUpProduct(selectedProduct.getId()));
        } else {
            productInventory.remove(productDelete);
            System.out.println("Product Deleted");
        }
        return true;
    }
    public static boolean deletePart(Product selectedPart) {
        Part partDelete = lookUpPart(selectedPart.getId());

        if (partDelete == null) {
            System.out.println(lookUpProduct(selectedPart.getId()));
        } else {
            partInventory.remove(partDelete);
            System.out.println("Part Deleted");
        }
        return true;
}
}

