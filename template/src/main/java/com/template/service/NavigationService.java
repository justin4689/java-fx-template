package com.template.service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class NavigationService {
    private static NavigationService instance;
    private Stage stage;

    private NavigationService() {}

    public static NavigationService getInstance() {
        if (instance == null) instance = new NavigationService();
        return instance;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void navigateTo(String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/template/" + fxmlFile));
        Pane root = loader.load();
        Scene scene = new Scene(root, 1200, 800);

        // Ajout du CSS
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/template/css/styles.css")).toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Gestion Métier - " + fxmlFile.replace("-view.fxml", ""));
        stage.show();
    }
}