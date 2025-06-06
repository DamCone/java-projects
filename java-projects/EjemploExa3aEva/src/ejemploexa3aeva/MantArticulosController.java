
package ejemploexa3aeva;

// MantArticulosController.java
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL; // Importar URL

public class MantArticulosController {

    @FXML
    private Button btnMantGeneral;

    @FXML
    private Button btnVolver;

    @FXML
    void abrirMantArtGene(ActionEvent event) {
        try {
            URL fxmlUrl = getClass().getResource("MantArtGene.fxml");
            if (fxmlUrl == null) {
                System.err.println("No se pudo encontrar MantArtGene.fxml.");
                return;
            }
            Parent root = FXMLLoader.load(fxmlUrl);
            
            Stage stage = new Stage();
            stage.setTitle("Mantenimiento General de Artículos");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            // stage.initOwner(btnMantGeneral.getScene().getWindow()); // Centrar
            stage.showAndWait();

        } catch (IOException e) {
            System.err.println("Error al cargar MantArtGene.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void volverAMenuPrincipal(ActionEvent event) {
        Stage stage = (Stage) btnVolver.getScene().getWindow();
        stage.close();
    }
}