package model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }

    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);

    }

    public static Part lookUpPart(int partId) {
        for (Part part : allParts) {
            if (part.getId() == partId) {
                return part;
            }
        }
        return null;
    }

    public static Product lookUpProduct(int productId) {
        for (Product product : allProducts) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public static ObservableList<Product> lookUpProduct(String productName) {
        ObservableList<Product> nameProduct = FXCollections.observableArrayList();
        ObservableList<Product> allProducts = getAllProducts();

        for (Product foundProduct : allProducts) {
            if (foundProduct.getName().contains(productName)) {
                nameProduct.add(foundProduct);

            }
        }
        return nameProduct;
    }

    public static ObservableList<Part> lookUpPart(String partName) {
        ObservableList<Part> namePart = FXCollections.observableArrayList();
        ObservableList<Part> allParts = getAllParts();

        for (Part foundPart : allParts) {
            if (foundPart.getName().contains(partName)) {
                namePart.add(foundPart);

            }
        }
        return namePart;
    }

    public static void updatePart(int index, Part selectedPart) {
        allParts.set(index, selectedPart);
    }

    public static void updateProduct(int index, Product selectedProduct) {
        allProducts.set(index, selectedProduct);
    }

    public static boolean deleteProduct(Product selectedProduct) {
        Product productDelete = lookUpProduct(selectedProduct.getId());

        if (productDelete == null) {
            System.out.println(lookUpProduct(selectedProduct.getId()));
        } else {
            allProducts.remove(productDelete);
            System.out.println("Product Deleted");
        }
        return true;
    }
    public static boolean deletePart(Product selectedPart) {
        Part partDelete = lookUpPart(selectedPart.getId());

        if (partDelete == null) {
            System.out.println(lookUpProduct(selectedPart.getId()));
        } else {
            allParts.remove(partDelete);
            System.out.println("Part Deleted");
        }
        return true;
}

