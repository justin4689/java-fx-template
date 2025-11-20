package com.template.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Contrôleur principal du dashboard - Gère l'injection du menu
 * Conforme au pattern de contrôleur imbriqué avec fx:include
 */
public class DashboardController implements Initializable {
    @FXML private StackPane contentArea;
    @FXML private MenuController menuController; // Injection automatique via fx:id
    @FXML private HBox menuContainer; // Conteneur du menu pour le toggle
    private boolean isMenuVisible = true; // État actuel du menu

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Le menuController est automatiquement injecté grâce à fx:id="menu"
        // On lui passe la référence au contentArea pour qu'il puisse charger les vues
        menuController.setContentArea(contentArea);
    }

    /**
     * Bascule la visibilité du menu latéral
     */
    @FXML
    public void toggleMenu() {
        isMenuVisible = !isMenuVisible;
        menuContainer.setVisible(isMenuVisible);
        menuContainer.setManaged(isMenuVisible);
        
        // Ajuste la marge du contentArea en fonction de l'état du menu
        if (isMenuVisible) {
            contentArea.setStyle("-fx-padding: 0 0 0 200;"); // Ajustez la largeur selon votre menu
        } else {
            contentArea.setStyle("-fx-padding: 0;");
        }
    }
}