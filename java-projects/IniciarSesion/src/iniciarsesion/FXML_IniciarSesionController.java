package iniciarsesion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXML_IniciarSesionController implements Initializable {
    
    @FXML
    private TextField usuario;
    
    @FXML
    private PasswordField contrasenya;
    
    @FXML
    private Label lab;
    
    
    @FXML
private void iniciar() {
    boolean usuIsOk = false;
    boolean contraIsOk = false;
    boolean todoOk = false;

    File archivo = new File("users.txt");
    System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());

    if (!archivo.exists()) {
        lab.setText("Archivo users.txt no encontrado.");
        return;
    }

    try (Scanner lector = new Scanner(archivo)) {
        while (lector.hasNext()) {
            String usu = lector.next();
            String contra = lector.next();

            if (usu.equals(usuario.getText())) {
                usuIsOk = true;
                if (contra.equals(contrasenya.getText())) {
                    contraIsOk = true;
                    todoOk = true;
                    break;
                }
            }
        }

        if (todoOk) {
            lab.setText("Usuario y contraseña válidos.");
        } else if (usuIsOk) {
            lab.setText("Contraseña inválida.");
        } else {
            lab.setText("Usuario inválido.");
        }

    } catch (FileNotFoundException ex) {
        lab.setText("Archivo no encontrado.");
        ex.printStackTrace();
    } catch (Exception e) {
        lab.setText("Error inesperado: " + e.getMessage());
        e.printStackTrace();
    }
}

    
    @FXML
private void registrar(){
    File archivo = new File("users.txt");
    System.out.println("Archivo absoluto: " + archivo.getAbsolutePath());

    try {
        String usu = usuario.getText().trim();
        String contra = contrasenya.getText().trim();

        if (!usu.isEmpty() && !contra.isEmpty()) {
            try (FileWriter w = new FileWriter(archivo, true)) {
                w.write(usu + " " + contra + "\n");
                lab.setText("Usuario añadido!");
            }
        } else {
            lab.setText("Debes añadir un usuario y contraseña.");
        }
    } catch (Exception e) {
        lab.setText("Error: " + e.getMessage());
        e.printStackTrace();
    }
}

    
    @FXML
    private void cancelar(){
        usuario.clear();
        contrasenya.clear();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }    
    
}
