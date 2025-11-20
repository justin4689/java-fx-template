src/main/java/com/metier/
├── Main.java
├── controller/
│   ├── LoginController.java
│   ├── RegisterController.java
│   ├── DashboardController.java
│   └── MenuController.java
├── model/
│   ├── StatData.java
│   └── User.java
└── service/
    └── NavigationService.java

src/main/resources/com/metier/view/
├── login.fxml
├── register.fxml
├── dashboard.fxml
├── menu.fxml
├── dashboard-home.fxml
├── clients.fxml
├── projects.fxml
├── reports.fxml
├── settings.fxml
├── training.fxml
├── support.fxml
└── styles.css


# Coordonnee de connexion
admin@metier.com / admin123

# Nettoie, compile et lance
mvn clean compile javafx:run