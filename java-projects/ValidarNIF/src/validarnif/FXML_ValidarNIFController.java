
package validarnif;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXML_ValidarNIFController implements Initializable {
    
    @FXML
    private TextField dni;
    
    @FXML
    private Label lab;
    
    @FXML
    private void validar(){
        String d = dni.getText();
        if (!d.matches("\\d{8}[A-Z]")) {
             lab.setText("Formato inválido. Deben ser 8 números y una letra.");
             return;
        }
        int numero = Integer.parseInt(d.substring(0, 8));
        char letra = d.charAt(8);
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letraCorrecta = letras.charAt(numero % 23);
        
        if (letra == letraCorrecta) {
            lab.setText("Validación: El DNI es correcto!");
        } else {
            lab.setText("Validación: El DNI es incorrecto...");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
