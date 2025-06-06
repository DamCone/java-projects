
package parimpar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.Action;

public class FXML_ParImparController implements Initializable {
    
    @FXML
    private TextField idNum;
    
    @FXML
    private Label idResultado;
    
    @FXML
    private void btnAction(ActionEvent event){
        float num = Float.parseFloat(idNum.getText());
        
        if (num % 2 == 0) {
            idResultado.setText(String.valueOf("¡Es Par!"));
        } else {
            idResultado.setText(String.valueOf("¡Es Impar!"));
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
