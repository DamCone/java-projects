
package dadosrol;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FXML_DadosRolController implements Initializable {
    
    @FXML
    private ToggleButton seis;
    
    @FXML
    private ToggleButton ocho;
    
    @FXML
    private ToggleButton diez;
    
    @FXML
    private ToggleButton doce;
    
    @FXML
    private ToggleButton veinte;
    
    @FXML
    private Label numero;
    
    @FXML
    private void lanzar(){
        int num = 0;
        if (seis.isSelected()) {
            num = (int)(Math.random() * 6) + 1;
        } else if (ocho.isSelected()) {
            num = (int)(Math.random() * 8) + 1;
        } else if (diez.isSelected()) {
            num = (int)(Math.random() * 10) + 1;
        } else if (doce.isSelected()) {
            num = (int)(Math.random() * 12) + 1;
        } else if (veinte.isSelected()) {
            num = (int)(Math.random() * 20) + 1;
        }
        
        if (num != 0) {
            numero.setText(""+num);
        } else {
            numero.setText("Escoge un dado!");
        }
        
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg = new ToggleGroup();
        seis.setToggleGroup(tg);
        ocho.setToggleGroup(tg);
        diez.setToggleGroup(tg);
        doce.setToggleGroup(tg);
        veinte.setToggleGroup(tg);
        
        Image image6 = new Image(getClass().getResource("/Images/seis.png").toExternalForm(), 40, 40, true, true);
        seis.setGraphic(new ImageView(image6));
        
        Image image8 = new Image(getClass().getResource("/Images/ocho.png").toExternalForm(), 40, 40, true, true);
        ocho.setGraphic(new ImageView(image8));
        
        Image image10 = new Image(getClass().getResource("/Images/diez.png").toExternalForm(), 40, 40, true, true);
        diez.setGraphic(new ImageView(image10));
        
        Image image12 = new Image(getClass().getResource("/Images/doce.png").toExternalForm(), 40, 40, true, true);
        doce.setGraphic(new ImageView(image12));
        
        Image image20 = new Image(getClass().getResource("/Images/veinte.png").toExternalForm(), 40, 40, true, true);
        veinte.setGraphic(new ImageView(image20));
    }    
    
}
