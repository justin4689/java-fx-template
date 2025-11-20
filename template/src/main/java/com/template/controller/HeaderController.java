package com.template.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HeaderController {
    @FXML
    private Button menuButton;
    
    @FXML
    private void toggleMenu() {
        // Cette méthode sera appelée par le bouton de menu
        // La logique est gérée par le DashboardController via l'événement
    }
    
    @FXML
    private void showNotifications() {
        // À implémenter : afficher les notifications
        System.out.println("Afficher les notifications");
    }
    
    @FXML
    private void showUserMenu() {
        // À implémenter : afficher le menu utilisateur
        System.out.println("Afficher le menu utilisateur");
    }
}
