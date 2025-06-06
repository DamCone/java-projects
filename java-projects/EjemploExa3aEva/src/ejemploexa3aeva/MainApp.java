package ejemploexa3aeva;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL; // Importar URL

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Es crucial que el FXML esté en la misma carpeta o uses la ruta correcta.
            // Para asegurar que lo encuentra si está en la misma carpeta:
            URL fxmlUrl = getClass().getResource("VentanaPrincipal.fxml");
            if (fxmlUrl == null) {
                System.err.println("No se pudo encontrar VentanaPrincipal.fxml. Asegúrate de que está en la misma carpeta.");
                return;
            }
            Parent root = FXMLLoader.load(fxmlUrl);

            Scene scene = new Scene(root);
            primaryStage.setTitle("Gestión Empresa - Menú Principal");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            System.err.println("Error al cargar VentanaPrincipal.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}