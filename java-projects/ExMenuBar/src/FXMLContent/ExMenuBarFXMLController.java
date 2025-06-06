
package FXMLContent;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author FX506
 */
public class ExMenuBarFXMLController implements Initializable {

    @FXML
    private MenuBar menuBar;
    
    @FXML
    private ImageView i1;
    
    @FXML
    private void add(){
        Alert a = new Alert(AlertType.INFORMATION);       
        a.setHeaderText(null);
        a.setTitle("Message");
        a.setContentText("The object has been added");
        a.show();
    }
    
    @FXML
    private void list(){
        Alert a = new Alert(AlertType.INFORMATION);       
        a.setHeaderText(null);
        a.setTitle("Message");
        a.setContentText("You have pressed list");
        a.show();
    }
    
    @FXML
    private void item(){
        Alert a = new Alert(AlertType.INFORMATION);       
        a.setHeaderText(null);
        a.setTitle("Message");
        a.setContentText("You have pressed Item");
        a.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
