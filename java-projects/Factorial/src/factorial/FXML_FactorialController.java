
package factorial;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXML_FactorialController implements Initializable {
    
    @FXML
    private TextField valor;
    
    @FXML
    private Label lab;
    
    @FXML
    private void calcularFactorial(){
        try {
            int v = Integer.parseInt(valor.getText());
            
            if (v < 0) {
                lab.setText("Introduce un número positivo");
                return;
            }
            
            int resultado = 1;
            for (int i = 2; i <= v; i++) {
                resultado *= i;
            }
            lab.setText("Factorial: "+ resultado);
        } catch(NumberFormatException e){
            lab.setText("Introduce un número entero válido.");
        }
    }
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
