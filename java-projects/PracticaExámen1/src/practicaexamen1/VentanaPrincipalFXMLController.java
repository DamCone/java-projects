
package practicaexamen1;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import java.sql.SQLException;
import javafx.event.ActionEvent;

public class VentanaPrincipalFXMLController implements Initializable {
    
    private ConectaBBDD con;
    
    @FXML
    private TextField id, nombre, precio, codigo, grupo;
    
    @FXML
    private Button bt_Primero, bt_Ultimo, bt_Siguiente, bt_Anterior;
    
    private Articulo obtenArt() {
        Articulo art;
        String ide;
        String nom;
        float pre;
        String cod;
        int gru;

        ide = id.getText();
        nom = nombre.getText();
        pre = Float.parseFloat(precio.getText());
        cod = codigo.getText();
        gru = Integer.parseInt(grupo.getText());

        if (ide.equalsIgnoreCase("")) {
            art = new Articulo("", nom, pre, cod, gru);
        } else {
            art = new Articulo(ide, nom, pre, cod, gru);
        }
        return art;
    }
    
    private boolean cargaArticulo(Articulo art) {
        Alert a = new Alert(AlertType.NONE);
        boolean ok = true;
        try {
            id.setText(art.getId());
            nombre.setText(art.getNombre());
            precio.setText(String.valueOf(art.getPrecio()));
            codigo.setText(art.getCodigo());
            grupo.setText(String.valueOf(art.getGrupo()));
        } catch (Exception ex) {
            a.setAlertType(AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("ERROR: No se ha podido cargar el Artículo");
            a.show();
            ok = false;
        }
        return ok;
    }
    
    private void mostrarAlerta(String mensaje, AlertType tipo) {
        Alert a = new Alert(tipo);
        a.setTitle(tipo == AlertType.ERROR ? "Error" : tipo == AlertType.WARNING ? "Advertencia" : "Información");
        a.setHeaderText(null);
        a.setContentText(mensaje);
        a.showAndWait();
    }
    
    private boolean valida (){
        String nom = nombre.getText();
        String preStr = precio.getText();
        String cod = codigo.getText();
        String gruStr = grupo.getText();
        
        if (nom.isEmpty() || preStr.isEmpty() || cod.isEmpty() || gruStr.isEmpty()) {
            mostrarAlerta("Todos los campos (excepto ID para inserción) son obligatorios.", AlertType.WARNING);
            return false;
        }
        try {
            Float.parseFloat(preStr);
        } catch (NumberFormatException e) {
            mostrarAlerta("El formato del precio no es válido.", AlertType.WARNING);
            return false;
        }
        try {
            Integer.parseInt(gruStr);
        } catch (NumberFormatException e) {
            mostrarAlerta("El formato del grupo no es válido.", AlertType.WARNING);
            return false;
        }
        return true;
    }
    
    @FXML
    private void aceptarActionInsertar() {
        Articulo art1;
        int graba;
        ConectaBBDD con2 = new ConectaBBDD();
        // creamos la alerta
        Alert a = new Alert(AlertType.NONE);
        if (valida()) {
            try {
                con2.conecta();
                con2.crearSentencia();
                // recogemos los valores de la ventana
                art1 = obtenArt();
                graba = con2.grabaRegistro(art1);
                if (graba == 1) {
                    a.setAlertType(AlertType.INFORMATION);
                    a.setHeaderText(null);
                    a.setContentText("\"* * * Artículo insertado * * * \"");
                    a.show();
                } else if (graba == -1) {
                    a.setAlertType(AlertType.ERROR);
                    a.setHeaderText(null);
                    a.setContentText("ERROR: integridad referencial o SQL truncada");
                    a.show();
                } else {
                    a.setAlertType(AlertType.ERROR);
                    a.setHeaderText(null);
                    a.setContentText("* * * no se pudo insertar Artículo * * *");
                    a.show();
                }
                con2.cerrarConexion();
            } catch (Exception ex) {
                a.setAlertType(AlertType.ERROR);
                a.setHeaderText(null);
                a.setContentText("ERROR: con la BBDD.");
                a.show();
            }
        }
    }
    
    @FXML
    private void aceptarActionModificar(ActionEvent evt) {
        Articulo art1;
        int graba;
        ConectaBBDD con2 = new ConectaBBDD();
        // creamos la alerta
        Alert a = new Alert(AlertType.NONE);
        if (valida()) {
            try {
                con2.conecta();
                con2.crearSentencia();
                art1 = obtenArt();
                graba = con2.modiRegistro(art1);
                // podemos continuar
                if (graba == 1) {
                    a.setAlertType(AlertType.INFORMATION);
                    a.setHeaderText(null);
                    a.setContentText("* * * Ha modificado un Artículo * * * ");
                    a.show();

                } else if (graba == -1) {
                    a.setAlertType(AlertType.ERROR);
                    a.setHeaderText(null);
                    a.setContentText("ERROR: integridad referencial o SQL truncada");
                    a.show();
                } else {
                    a.setAlertType(AlertType.ERROR);
                    a.setHeaderText(null);
                    a.setContentText("* * * no se pudo modificar Artículo * * *");
                    a.show();
                }
                con2.cerrarConexion();
            } catch (Exception ex) {
                a.setAlertType(AlertType.ERROR);
                a.setHeaderText(null);
                a.setContentText("ERROR: con la BBDD.");
                a.show();
            }

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Articulo a;
        try {
            con = new ConectaBBDD();
            con.conecta();
            con.crearSentencia();
            con.ejecutaSQL("SELECT * FROM articulos");
            con.irSiguiente();
            try {
                if (con.irPrimero()) {
                    a = con.devRegistroActual();
                    cargaArticulo(a);
                    bt_Primero.setDisable(true);
                    bt_Anterior.setDisable(true);
                }
                System.out.println(con.tamanyo());
                if (con.isPrimero() && (con.tamanyo() > 1)) {
                    bt_Siguiente.setDisable(false);
                    bt_Ultimo.setDisable(false);

                } else {
                    bt_Primero.setDisable(true);
                    bt_Anterior.setDisable(true);
                    bt_Siguiente.setDisable(true);
                    bt_Ultimo.setDisable(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error: al posicionar en el primero");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error: en la conexion a BBDD");
        }
    }  
    
     @FXML
    public void irPrimero() {
        // TODO
        Articulo a;
        con.irPrimero();
        a = con.devRegistroActual();
        cargaArticulo(a);
        actualizaBotones();
    }

    @FXML
    public void irUltimo() {
        // TODO
        Articulo a;
        con.irFinal();
        a = con.devRegistroActual();
        cargaArticulo(a);
        actualizaBotones();
    }

    @FXML
    public void irSiguiente() {
        // TODO
        Articulo a;
        con.irSiguiente();
        a = con.devRegistroActual();
        cargaArticulo(a);
        actualizaBotones();
    }

    @FXML
    public void irAnterior() {
        // TODO
        Articulo a;
        con.irAnterior();
        a = con.devRegistroActual();
        cargaArticulo(a);
        actualizaBotones();
    }

    private void actualizaBotones() {
        try {
            boolean esPrimero = con.isPrimero();
            boolean esUltimo = con.isUltimo();

            bt_Primero.setDisable(esPrimero);
            bt_Anterior.setDisable(esPrimero);
            bt_Siguiente.setDisable(esUltimo);
            bt_Ultimo.setDisable(esUltimo);
        } catch (SQLException ex) {
            System.out.println("Error al actualizar los botones");
        }
    }
}
