package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.InHousePart;
import model.Inventory;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(new Scene(root, 900, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
    /*    InHousePart book = new InHousePart(1,"Winds of Winter", 35.50, 1, 2, 5, 64);
        Inventory.addPart(book);*/
        launch(args);
    }

}

