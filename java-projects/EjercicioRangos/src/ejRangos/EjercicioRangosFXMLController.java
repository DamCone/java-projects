package ejRangos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

public class EjercicioRangosFXMLController implements Initializable {
    
    @FXML
    private Label mix;
    
    @FXML
    private Slider sliderR;
    
    @FXML
    private Slider sliderG;
    
    @FXML
    private Slider sliderB;
    
    private int r = 0;
    
    private int g = 0;
    
    private int b = 0;
    
    @FXML
    private void cambiarColor(){
        r = (int) sliderR.getValue();
        g = (int) sliderG.getValue();
        b = (int) sliderB.getValue();
        mix.setTextFill(Color.rgb(r, g, b));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
