
package practicaexamen2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import java.util.Optional;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


public class VentanaBorrarFXMLController implements Initializable {

    private ConectaBBDD con;
    
    @FXML
    private TextField textNumSerie;
    
    @FXML
    private void borraOrd() {
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
        this.con = new ConectaBBDD();
    }    
    
}
