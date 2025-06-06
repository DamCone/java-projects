package clothingsore;

import classes.Customer;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterFXMLController implements Initializable {

    // --- Elementos inyectados desde el FXML ---
    @FXML private TextField tfUsername;
    @FXML private PasswordField pfPassword;
    @FXML private TextField tfEmail;
    @FXML private TextField tfName;
    @FXML private TextField tfDni;
    @FXML private TextField tfAddress;
    @FXML private DatePicker dpBirthdate;
    @FXML private TextField tfPhone;
    @FXML private TextField tfGender;
    @FXML private Button btnRegisterSubmit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Código inicial si es necesario (ej: pre-rellenar algún campo)
        System.out.println("Register Controller Initialized.");
    }

    @FXML
    private void handleRegisterSubmit(ActionEvent event) {
        System.out.println("Register button clicked!");

        // 1. Leer datos de los campos
        String username = tfUsername.getText();
        String password = pfPassword.getText(); // Considerar añadir campo confirmar contraseña
        String email = tfEmail.getText();
        String name = tfName.getText();
        String dni = tfDni.getText();
        String address = tfAddress.getText();
        LocalDate birthdate = dpBirthdate.getValue();
        String phone = tfPhone.getText();
        // String gender = tfGender.getText(); // Leer si lo usas

        // 2. Validación básica (ejemplo)
        if (username.isBlank() || password.isBlank() || email.isBlank() || name.isBlank() || dni.isBlank()) {
            showAlert(AlertType.WARNING, "Validation Error", "Username, Password, Email, Name, and DNI cannot be empty.");
            return; // Detener si falla la validación
        }
        // Aquí podrías añadir más validaciones:
        // - Formato de email
        // - Formato de DNI
        // - Si la contraseña y confirmar contraseña coinciden
        // - Si el username ya existe (necesitarías acceso a la lista de usuarios)

        // 3. Crear el objeto Customer (si la validación es correcta)
        // Nota: Asumiendo que tu constructor de Customer toma estos parámetros.
        // Ajusta según la definición de tu clase Customer.
        // Por ahora, DNI se pasa como String, podrías añadir validación de formato.
        try {
             // IMPORTANTE: Ajusta los parámetros según tu clase Customer
             // He omitido gender, address, phone y birthdate para simplificar, añádelos si los tienes en Customer
            Customer newCustomer = new Customer(username, password, name, "ApellidosPorDefecto", email, dni);
            // newCustomer.setAddress(address); // Si tienes setters
            // newCustomer.setPhone(phone);
            // newCustomer.setBirthdate(birthdate);

            System.out.println("New Customer object created: " + newCustomer.toString());

            // 4. "Guardar" el usuario (POR AHORA, SÓLO LO MOSTRAMOS)
            // Aquí es donde, más adelante, añadirías el usuario a tu ObservableList
            // y llamarías al método para guardar en fichero.
            // Ejemplo: DataManager.getInstance().addUser(newCustomer);
            // Ejemplo: FileManager.saveUsers(DataManager.getInstance().getUserList());


            // 5. Mostrar mensaje de éxito
            showAlert(AlertType.INFORMATION, "Registration Successful", "User '" + username + "' registered successfully!");

            // 6. Cerrar la ventana de registro
            closeWindow();

        } catch (Exception e) {
            // Capturar cualquier otro error durante la creación o "guardado"
             showAlert(AlertType.ERROR, "Registration Error", "An unexpected error occurred: " + e.getMessage());
             e.printStackTrace(); // Imprime el error detallado en la consola
        }
    }

    // --- Métodos de ayuda ---

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null); // No usamos cabecera
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void closeWindow() {
        // Obtener el Stage (ventana) actual desde el botón que disparó el evento
        Stage stage = (Stage) btnRegisterSubmit.getScene().getWindow();
        stage.close();
    }
}