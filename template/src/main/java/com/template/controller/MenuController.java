package com.template.controller;

import com.template.service.NavigationService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import org.kordamp.ikonli.javafx.FontIcon;

/**
 * Contrôleur du menu latéral - Gère la navigation et l'état actif des boutons
 * Implémente le pattern de navigation par contrôleur imbriqué (fx:include)
 */
public class MenuController {
    private StackPane contentArea;

    @FXML private Button btnDashboard;
    @FXML private Button btnClients;
    @FXML private Button btnSettings;
    @FXML private Button btnUserManagement;

    // Boutons du sous-menu Paramètres
    @FXML private Button btnSettingsGeneral;
    @FXML private Button btnSettingsSecurity;
    @FXML private Button btnSettingsAppearance;

    @FXML private VBox settingsSubmenu;
    @FXML private FontIcon settingsChevronIcon;

    /**
     * Injection du contentArea depuis DashboardController
     * Initialise aussi le menu par défaut (Tableau de bord)
     */
    public void setContentArea(StackPane contentArea) {
        this.contentArea = contentArea;
        initDefaultMenu();
    }

    private void initDefaultMenu() {
        // Charge la vue par défaut et active le bouton correspondant
        loadContent("dashboard-home.fxml", btnDashboard);
    }

    /**
     * Charge un contenu dans la zone centrale et met à jour l'état actif du menu
     * @param fxmlFile Nom du fichier FXML à charger
     * @param activeButton Bouton à activer visuellement
     */
    private void loadContent(String fxmlFile, Button activeButton) {
        try {
            // 1. Réinitialise l'état de tous les boutons
            removeActiveClassFromAllButtons();

            // 2. Active le bouton cliqué
            activeButton.getStyleClass().add("active");

            // 3. Charge la nouvelle vue
             FXMLLoader loader = new  FXMLLoader(
                    getClass().getResource("/com/template/views/" + fxmlFile)
            );
            Node node = loader.load();
            contentArea.getChildren().clear();
            contentArea.getChildren().add(node);

        } catch (IOException e) {
            System.err.println("⚠️ Vue non trouvée: " + fxmlFile);
            e.printStackTrace();
        }
    }

    /**
     * Retire la classe CSS "active" de tous les boutons du menu
     */
    private void removeActiveClassFromAllButtons() {
        btnDashboard.getStyleClass().remove("active");
        btnClients.getStyleClass().remove("active");
        btnUserManagement.getStyleClass().remove("active");
        btnSettings.getStyleClass().remove("active");

        // Sous-menu Paramètres
        if (btnSettingsGeneral != null) {
            btnSettingsGeneral.getStyleClass().remove("active");
        }
        if (btnSettingsSecurity != null) {
            btnSettingsSecurity.getStyleClass().remove("active");
        }
        if (btnSettingsAppearance != null) {
            btnSettingsAppearance.getStyleClass().remove("active");
        }
    }

    /**
     * Active visuellement un bouton du sous-menu Paramètres et désactive les autres
     */
    private void setActiveSettingsSubmenu(Button activeSubmenuButton) {
        if (btnSettingsGeneral != null) {
            btnSettingsGeneral.getStyleClass().remove("active");
        }
        if (btnSettingsSecurity != null) {
            btnSettingsSecurity.getStyleClass().remove("active");
        }
        if (btnSettingsAppearance != null) {
            btnSettingsAppearance.getStyleClass().remove("active");
        }

        if (activeSubmenuButton != null && !activeSubmenuButton.getStyleClass().contains("active")) {
            activeSubmenuButton.getStyleClass().add("active");
        }
    }

    // Gestionnaires d'événements pour chaque menu
    @FXML private void loadDashboard() { loadContent("dashboard-home.fxml", btnDashboard); }
    @FXML private void loadClients() { loadContent("clients.fxml", btnClients); }
    @FXML private void loadUserManagement() { loadContent("user-management.fxml", btnUserManagement); }

    @FXML
    private void loadSettings(ActionEvent event) {
        // Active le bouton principal Paramètres dans le menu
        loadContent("settings.fxml", btnSettings);

        // Gère l'état actif du sous-menu selon le bouton cliqué
        Object source = event.getSource();
        if (source instanceof Button clickedButton) {
            setActiveSettingsSubmenu(clickedButton);
        }
    }

    @FXML
    private void toggleSettingsSubmenu() {
        if (settingsSubmenu == null) return;
        boolean visible = !settingsSubmenu.isVisible();
        settingsSubmenu.setVisible(visible);
        settingsSubmenu.setManaged(visible);

        // Met à jour l'orientation du chevron
        if (settingsChevronIcon != null) {
            settingsChevronIcon.setIconLiteral(visible ? "mdi2c-chevron-down" : "mdi2c-chevron-right");
        }
    }

    @FXML
    private void handleLogout() {
        removeActiveClassFromAllButtons();
        try {
            NavigationService.getInstance().navigateTo("login.fxml");
        } catch (IOException e) {
            showError("Déconnexion impossible", e.getMessage());
        }
    }

    private void showError(String title, String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(
                javafx.scene.control.Alert.AlertType.ERROR
        );
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
}