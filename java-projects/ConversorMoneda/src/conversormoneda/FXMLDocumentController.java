
package conversormoneda;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label lbLibras;
    @FXML
    private TextField euros;
    
    @FXML
    private void handleBtnConverAction(ActionEvent event){
        float cantEuros, cantLibras;
        cantEuros = Float.parseFloat(euros.getText());
        
        cantLibras = (float) (cantEuros * 1.13);
        
        lbLibras.setText(String.valueOf(cantLibras)+" Libras");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
