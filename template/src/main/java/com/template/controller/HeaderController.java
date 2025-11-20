package com.template.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HeaderController {
    @FXML
    private Button menuButton;

    // Référence vers le contrôleur principal pour piloter le menu latéral
    private DashboardController dashboardController;

    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }

    @FXML
    private void toggleMenu() {
        if (dashboardController != null) {
            dashboardController.toggleMenu();
        }
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
