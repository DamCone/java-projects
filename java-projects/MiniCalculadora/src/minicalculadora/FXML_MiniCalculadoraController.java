package minicalculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class FXML_MiniCalculadoraController implements Initializable {

    @FXML
    private TextField v1;
    @FXML
    private TextField v2;
    @FXML
    private TextField idResultado;

    @FXML
    private void btnSuma(ActionEvent event) {
        operar("+");
    }

    @FXML
    private void btnResta(ActionEvent event) {
        operar("-");
    }

    @FXML
    private void btnMult(ActionEvent event) {
        operar("*");
    }

    @FXML
    private void btnDiv(ActionEvent event) {
        operar("/");
    }

    @FXML
    private void btnClear(ActionEvent event) {
        idResultado.setText("RESULTADO");
        v1.clear();
        v2.clear();
    }

    private void operar(String operador) {
        try {
            float num1 = Float.parseFloat(v1.getText());
            float num2 = Float.parseFloat(v2.getText());
            float resultado = 0;

            switch (operador) {
                case "+" -> resultado = num1 + num2;
                case "-" -> resultado = num1 - num2;
                case "*" -> resultado = num1 * num2;
                case "/" -> {
                    if (num2 == 0) {
                        mostrarError("No se puede dividir por cero.");
                        return;
                    }
                    resultado = num1 / num2;
                }
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
        // TODO
    }
}
