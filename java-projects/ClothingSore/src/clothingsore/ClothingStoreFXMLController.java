package clothingsore;

import java.io.IOException; 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader; 
import javafx.fxml.Initializable;
import javafx.scene.Parent; 
import javafx.scene.Scene; 
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;


public class ClothingStoreFXMLController implements Initializable {

    // --- Tus otras declaraciones @FXML ---
    @FXML private MenuBar menuBar; // Asegúrate de tener un fx:id="menuBar" en tu FXML principal
    @FXML private MenuItem menuItemLogin;
    @FXML private MenuItem menuItemRegister;
    @FXML private MenuItem menuItemExit;
    @FXML private MenuItem menuItemViewAll;

    @FXML private AnchorPane centerPane;
    @FXML private Button btnViewArticles;
    @FXML private Button btnLogin;
    @FXML private Button btnRegister; // Asegúrate de tener fx:id="btnRegister" si usas el botón
    @FXML private ImageView imgBanner;


    @FXML
    void handleLogin(ActionEvent event) {
        System.out.println("Acción: Iniciar Sesión");
        // --- Implementaremos esto después ---
        showAlert(Alert.AlertType.INFORMATION, "Login", "Login functionality not implemented yet.");
    }

    // Este método se llama desde el Menú o el Botón de Registro
    @FXML
    void handleRegister(ActionEvent event) {
        System.out.println("Acción: Registrarse - Abriendo ventana...");
        try {
            // 1. Crear el FXMLLoader
            // Busca RegisterFXML.fxml en el MISMO paquete que esta clase
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterFXML.fxml"));

            // 2. Cargar el nodo raíz del FXML de registro
            Parent registerRoot = loader.load();

            // 3. Crear una nueva ventana (Stage) para el registro
            Stage registerStage = new Stage();
            registerStage.setTitle("Register New User");
            registerStage.setScene(new Scene(registerRoot));

            // 4. Configurar Modalidad: Bloquea la ventana principal mientras esta está abierta
            registerStage.initModality(Modality.WINDOW_MODAL); // O APPLICATION_MODAL

            // 5. Establecer la ventana "dueña" (la principal)
            // Necesitamos obtener una referencia a la ventana principal actual.
            // Podemos obtenerla desde cualquier nodo que ya esté en la escena, como el menú o un botón.
            Window ownerWindow = null;
            if (menuBar != null) { // Intenta desde el menuBar si existe
                 ownerWindow = menuBar.getScene().getWindow();
            } else if (btnRegister != null) { // Intenta desde el botón si existe
                 ownerWindow = btnRegister.getScene().getWindow();
            }
             // Añade más 'else if' si es necesario para otros controles como btnLogin, etc.

            if (ownerWindow != null) {
                 registerStage.initOwner(ownerWindow);
            } else {
                 System.err.println("Warning: Could not determine owner window for Register Stage.");
                 // Si no se encuentra dueño, APPLICATION_MODAL es más seguro
                 registerStage.initModality(Modality.APPLICATION_MODAL);
            }


            // 6. (Opcional) Hacer que la ventana no sea redimensionable
            registerStage.setResizable(false);

            // 7. Mostrar la ventana y esperar a que se cierre
            registerStage.showAndWait();

            // --- Código después de que la ventana de registro se cierra ---
            // Podrías, por ejemplo, refrescar alguna lista si fuera necesario,
            // pero por ahora no hacemos nada aquí.
            System.out.println("Ventana de Registro cerrada.");


        } catch (IOException e) {
            System.err.println("Error al cargar la ventana de registro: " + e.getMessage());
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Could not open the registration window.");
        } catch (Exception e) {
             System.err.println("Error inesperado al abrir registro: " + e.getMessage());
             e.printStackTrace();
             showAlert(Alert.AlertType.ERROR, "Error", "An unexpected error occurred.");
        }
    }

    // Asegúrate de que si tienes un botón, su método onAction llame a handleRegister
    @FXML
    void handleRegisterAction(ActionEvent event) {
         handleRegister(event); // Llama al mismo método que el menú
    }


     @FXML
    void handleExit(ActionEvent event) {
        System.out.println("Acción: Salir");
        javafx.application.Platform.exit();
    }

    @FXML
    void handleViewAll(ActionEvent event) {
         System.out.println("Acción: Ver Todos los Artículos");
         showAlert(Alert.AlertType.INFORMATION, "View Articles", "View Articles functionality not implemented yet.");
         // Aquí irá la lógica para cargar y mostrar los artículos en centerPane
    }

    // --- Métodos para los botones (pueden llamar a los del menú si quieres) ---
     @FXML
    void handleLoginAction(ActionEvent event) {
         handleLogin(event);
    }

     @FXML
    void handleViewArticlesAction(ActionEvent event) {
         handleViewAll(event);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Main Controller Initialized.");
        // Puedes poner aquí el código para cargar la imagen inicial si no lo hiciste antes
         try {
            String imagePath = "/images/store_logo.png"; // CAMBIA ESTA RUTA
            Image bannerImage = new Image(getClass().getResourceAsStream(imagePath));
            if (bannerImage != null && imgBanner != null) { // Verifica que imgBanner no sea null
                imgBanner.setImage(bannerImage);
            } else if(imgBanner != null) {
                 System.err.println("Error: No se pudo cargar la imagen banner desde: " + imagePath);
            }
         } catch (Exception e) {
              System.err.println("Error cargando imagen banner inicial: " + e.getMessage());
              // e.printStackTrace(); // Descomentar para más detalles si falla
         }
    }

    // Método auxiliar para mostrar alertas (puedes moverlo a una clase Util)
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}