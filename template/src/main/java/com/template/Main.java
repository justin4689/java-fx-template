package com.template;

import com.template.service.NavigationService;
import javafx.application.Application;
import javafx.stage.Stage;
import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.PrimerLight;
import atlantafx.base.theme.NordDark;
import atlantafx.base.theme.NordLight;

import org.kordamp.ikonli.javafx.FontIcon;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Thèmes sombres
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());


        NavigationService nav = NavigationService.getInstance();
        nav.setStage(primaryStage);
        nav.navigateTo("components/layout.fxml");
    }
}