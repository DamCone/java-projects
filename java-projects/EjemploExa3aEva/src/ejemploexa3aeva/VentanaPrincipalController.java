
package ejemploexa3aeva;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL; // Importar URL

public class VentanaPrincipalController {

    @FXML
    private MenuItem menuItemArticulos; // No es estrictamente necesario si solo usas onAction

    @FXML
    void abrirMantArticulos(ActionEvent event) {
        try {
            URL fxmlUrl = getClass().getResource("MantArticulos.fxml");
            if (fxmlUrl == null) {
                System.err.println("No se pudo encontrar MantArticulos.fxml.");
                return;
            }
            Parent root = FXMLLoader.load(fxmlUrl);
            
            Stage stage = new Stage();
            stage.setTitle("Mantenimiento de Artículos");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal
            // stage.initOwner(((MenuItem)event.getSource()).getParentPopup().getOwnerWindow()); // Para centrar respecto al menú
            stage.showAndWait(); // Muestra y espera a que se cierre

        } catch (IOException e) {
            System.err.println("Error al cargar MantArticulos.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void salirAplicacion(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
}