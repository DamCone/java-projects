
package controlador;

import bbdd.ConectaBBDD;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class VentanaBorrarFXMLController implements Initializable {
    private ConectaBBDD con;
    
    @FXML
    private TextField textNumSerie;
    
    @FXML
    public void borrar(){
        int respuestaJ, i = 0, rc = -1;
        boolean encontrado = false;
        boolean continuaSiExcepcion = true;
        String[] buttons = {"Si", "No"};
        String sentSql;
        int id2 = -1;
        Alert a;

        //tratamos posible excepción
        try {
            id2 = Integer.parseInt(textNumSerie.getText());
        } catch (Exception e) {
            // aviso de Error
            System.out.println("Error en la entrada de datos");
            textNumSerie.setText("");
            textNumSerie.requestFocus();
            continuaSiExcepcion = false;
        }

        if (continuaSiExcepcion) {
            // buscamos el ordenador a borrar
            try {
                con.conecta();
                con.crearSentencia();
                sentSql = "SELECT * FROM ordenadores WHERE numSerie = " + id2;
                System.out.println(sentSql);
                con.ejecutaSQL(sentSql);

                if (con.irSiguiente()) {
                    // lo hemos encontrado
                    try {
                        // mensaje de confirmacion
                        // Swing rc = JOptionPane.showOptionDialog(this,"Realmente desea borrar el registro con ID = [" + id2 + "]?",
                        //"Confirmation",JOptionPane.WARNING_MESSAGE,0,null,buttons,buttons[1]);
                        // Un Alert en JavaFX
                        a = new Alert(AlertType.NONE);
                        Optional<ButtonType> result;
                        a.setAlertType(AlertType.CONFIRMATION);
                        a.setHeaderText(null);
                        a.setContentText("Confirmación de borrado");
                        result = a.showAndWait();                      
                         if (result.get() == ButtonType.OK) {
                            sentSql = "DELETE FROM ordenadores WHERE numSerie = " + id2;
                            System.out.println(sentSql);
                            con.updateSQL(sentSql);
                            con.cerrarConexion();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("No se encuentra ese número de serie");
                    textNumSerie.requestFocus();
                }
            } catch (SQLException ex) {
                // mensaje de error
                System.out.println("Atención!");
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con = new ConectaBBDD();
        String linea = "";
        try {
            con.conecta();
            con.crearSentencia();
            con.ejecutaSQL("SELECT * FROM tipos");
            while (con.irSiguiente()) {
                System.out.println("Hola");
                linea += con.devRegActTipo();
                linea = "";
            }
        } catch (SQLException ex) {
            // Alerta correspondiente
            System.out.println("Error 1");
        } catch (Exception ex) {
            // Alerta correspondiente
            System.out.println("Error 2");
            ex.printStackTrace();
        }
    }    
    
}
