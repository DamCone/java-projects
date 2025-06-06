package minicalculadora2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FXML_MiniCalculadora2Controller implements Initializable {

    @FXML
    private TextField v1;
    @FXML
    private TextField v2;
    
    
    private ToggleGroup radioGroup = new ToggleGroup();
    
    @FXML
    private Button idResultado;
    @FXML
    private RadioButton suma;
    @FXML
    private RadioButton producto;
    @FXML
    private RadioButton elevado;
    
    
    
    @FXML
    private void btnReset(ActionEvent event) {
        idResultado.setText("RESULTADO");
        v1.clear();
        v2.clear();
    }
    
    @FXML
    private void btnCalcular(ActionEvent event) {
        try {
            float num1 = Float.parseFloat(v1.getText());
            float num2 = Float.parseFloat(v2.getText());
            String resultado = "Resultado";

            if (suma.isSelected()) {
                resultado = num1 + "+" + num2 + "= " + (num1 + num2);
            } else if(producto.isSelected()){
                resultado = "Producto: " + (num1 % num2);
            } else if(elevado.isSelected()){
                resultado = num1 + "^" + num2 + "= " + (Math.pow(num1, num2));
            } else {
                mostrarError("Debe haber una opción seleccionada.");
            }

            idResultado.setText(String.valueOf(resultado));
        } catch (NumberFormatException e) {
            mostrarError("Por favor, introduce solo números válidos.");
        } catch (Exception e) {
            mostrarError("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radioGroup = new ToggleGroup();
        suma.setToggleGroup(radioGroup);
        producto.setToggleGroup(radioGroup);
        elevado.setToggleGroup(radioGroup);
    }
}
