package burguermenuapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class FXML_BurguerMenuAppController implements Initializable {
    
    @FXML
    private RadioButton pollo;
    @FXML
    private RadioButton cerdo;
    @FXML
    private RadioButton ternera;
    @FXML
    private RadioButton vegana;
    
    @FXML
    private RadioButton normal;
    @FXML
    private RadioButton integral;
    @FXML
    private RadioButton centeno;
    
    @FXML
    private RadioButton fritas;
    @FXML
    private RadioButton gajo;
    @FXML
    private RadioButton caseras;
    
    @FXML
    private RadioButton cola;
    @FXML
    private RadioButton naranja;
    @FXML
    private RadioButton limon;
    @FXML
    private RadioButton agua;
    @FXML
    private RadioButton cerveza;
    
    @FXML
    private RadioButton doble;
    @FXML
    private RadioButton extraQueso;
    @FXML
    private RadioButton extraPatatas;
    
    @FXML
    private RadioButton ketchup;
    @FXML
    private RadioButton barbacoa;
    @FXML
    private RadioButton mostaza;
    @FXML
    private RadioButton miel;
    @FXML
    private RadioButton thai;
    
    @FXML
    private RadioButton aDomicilio;
    @FXML
    private RadioButton local;
    
    @FXML
    private Label lab;
    @FXML
    private Label lab1;
    @FXML
    private Label lab2;
    
    public ToggleGroup asignarTG5(RadioButton a, RadioButton b, RadioButton c, RadioButton d, RadioButton e){
        ToggleGroup radioGroup = new ToggleGroup();
        a.setToggleGroup(radioGroup);
        b.setToggleGroup(radioGroup);
        c.setToggleGroup(radioGroup);
        d.setToggleGroup(radioGroup);
        e.setToggleGroup(radioGroup);
        return radioGroup;
    }
    public ToggleGroup asignarTG4(RadioButton a, RadioButton b, RadioButton c, RadioButton d){
        ToggleGroup radioGroup = new ToggleGroup();
        a.setToggleGroup(radioGroup);
        b.setToggleGroup(radioGroup);
        c.setToggleGroup(radioGroup);
        d.setToggleGroup(radioGroup);
        return radioGroup;
    }
    public ToggleGroup asignarTG3(RadioButton a, RadioButton b, RadioButton c){
        ToggleGroup radioGroup = new ToggleGroup();
        a.setToggleGroup(radioGroup);
        b.setToggleGroup(radioGroup);
        c.setToggleGroup(radioGroup);
        return radioGroup;
    }
    public ToggleGroup asignarTG2(RadioButton a, RadioButton b){
        ToggleGroup radioGroup = new ToggleGroup();
        a.setToggleGroup(radioGroup);
        b.setToggleGroup(radioGroup);
        return radioGroup;
    }
    
    @FXML
    private void calcular(){
        double precio = 8;
        double iva = 0.21;
        if (ternera.isSelected() || vegana.isSelected()) {
            precio++;
        }
        if (caseras.isSelected()) {
            precio++;
        }
        if (doble.isSelected()) {
            precio += 2;
        } 
        if (extraQueso.isSelected()) {
            precio += 0.50;
        }
        if (extraPatatas.isSelected()) {
            precio ++;
        }
        if (ketchup.isSelected()) {
            precio += 0.50;
        }
        if (barbacoa.isSelected()) {
            precio += 0.50;
        }
        if (mostaza.isSelected()) {
            precio += 0.50;
        }
        if (miel.isSelected()) {
            precio += 0.50;
        }
        if (thai.isSelected()) {
            precio += 0.50;
        }
        iva = precio * iva;
        double precioFinal = precio + iva;
        
        if (local.isSelected()) {
            precioFinal -= precioFinal * 0.20;
        }
        
        lab.setText("Precio final: "+precioFinal);
        lab1.setText("Precio: "+precio);
        lab2.setText("IVA: "+iva);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tipo = new ToggleGroup();
        tipo = asignarTG4(pollo, cerdo, ternera, vegana);
        
        ToggleGroup pan = new ToggleGroup();
        tipo = asignarTG3(normal, integral, centeno);
        
        ToggleGroup patatas = new ToggleGroup();
        tipo = asignarTG3(fritas, gajo, caseras);
        
        ToggleGroup bebida = new ToggleGroup();
        tipo = asignarTG5(cola, naranja, limon, agua, cerveza);
        
        ToggleGroup reparto = new ToggleGroup();
        tipo = asignarTG2(aDomicilio, local);
    }    
    
}
