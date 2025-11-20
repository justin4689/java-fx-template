package com.template.controller;

import com.template.service.NavigationService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Contrôleur de login - Gère l'authentification utilisateur
 * Conforme au pattern MVC avec séparation stricte Model/View
 */
public class LoginController {
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;

    // Données mockées (remplacer par service d'authentification réel)
    private static final String MOCK_EMAIL = "";
    private static final String MOCK_PASS = "";

    @FXML
    private void handleLogin() {
        if (MOCK_EMAIL.equals(emailField.getText()) && MOCK_PASS.equals(passwordField.getText())) {
            try {
                NavigationService.getInstance().navigateTo("components/layout.fxml");
            } catch (Exception e) {

                System.out.println(e.getMessage());
                showError("Erreur de navigation", e.getMessage());
            }
        } else {
            showError("Identifiants incorrects", "Email ou mot de passe invalide");
        }
    }

    @FXML
    private void goToRegister() {
        try {
            NavigationService.getInstance().navigateTo("register.fxml");
        } catch (Exception e) {

            showError("Navigation impossible", e.getMessage());
        }
    }

    @FXML
    private void goToForgotPassword() {
        try {
            NavigationService.getInstance().navigateTo("forgot-password.fxml");
        } catch (Exception e) {
            showError("Navigation impossible", e.getMessage());
        }
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
}