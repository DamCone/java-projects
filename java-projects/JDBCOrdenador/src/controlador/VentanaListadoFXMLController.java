
package controlador;

import com.sun.jdi.connect.spi.Connection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Slider;
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.scene.layout.Pane;
import bbdd.ConectaBBDD;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Ordenador;
import modelo.Portatil;
import modelo.Sobremesa;

public class VentanaListadoFXMLController implements Initializable {
    
    private ConectaBBDD con ;
    
    @FXML
    private Button btPrimero, btAnterior, btSiguiente, btUltimo;
    
    @FXML
    private ComboBox ComboBox_Tipo;
    
    @FXML
    private Pane pSobre;
    
    @FXML
    private Pane pPor;
    
    @FXML
    private TextField textNumSerie;
    
    @FXML
    private TextField textMarca;
    
    @FXML
    private TextField textModelo;
    
    @FXML
    private TextField textMicro;
    
    @FXML
    private TextField textMemoria;
    
    @FXML
    private RadioButton radioDvdNo;
    
    @FXML
    private RadioButton radioDvdSi;
    
    @FXML
    private Slider sliderUSB;
    
    @FXML
    private RadioButton radioSonSi;
    
    @FXML
    private RadioButton radioSonNo;
    
    @FXML
    private TextField textTamanyo;
    
    @FXML
    private TextField textPeso;
    
    @FXML
    private TextField textPulgada;
    
    @FXML
    private Label idPos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con = new ConectaBBDD();
        String linea = "", sql;
        int tam;
        try {
            con.conecta();
            con.crearSentencia();
            con.ejecutaSQL("SELECT * FROM tipos");
            while (con.irSiguiente()) {
                linea += con.devRegActTipo();
                ComboBox_Tipo.getItems().add(linea);
                linea = "";
            }
            ComboBox_Tipo.getSelectionModel().selectFirst();
            con.cerrarConexion();
        } catch (SQLException ex) {
            // Alerta correspondiente
            System.out.println("Error 1");
        } catch (Exception ex) {
            // Alerta correspondiente
            System.out.println("Error 2");
            ex.printStackTrace();
        }
        pPor.setDisable(true);

        try {
            con.conecta();
            con.crearSentencia();
            sql = "SELECT * FROM ordenadores JOIN tipos WHERE ordenadores.tipo=tipos.codigo";
            con.ejecutaSQL(sql);
            tam = con.tamanyo();
            irPrimeroOrd();
            actualizaBotones();
            idPos.setText(con.posRs() + "/" + con.tamanyo());
        } catch (SQLException ex) {
            // aviso a usuario
            System.out.println("Atención!");
        }
    } 
    
    @FXML
    public void irPrimeroOrd() {
        try {
            // TODO
            Ordenador o;
            con.irPrimero();
            o = con.obtenerOrdenador();
            mostrarOrdenador(o);
            actualizaBotones();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaListadoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void irUltimoOrd() {
        try {
            // TODO
            Ordenador o;
            con.irFinal();
            o = con.obtenerOrdenador();
            mostrarOrdenador(o);
            actualizaBotones();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaListadoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void irSiguienteOrd() {
        try {
            // TODO
            Ordenador o;
            con.irSiguiente();
            o = con.obtenerOrdenador();
            mostrarOrdenador(o);
            actualizaBotones();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaListadoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void irAnteriorOrd() {
        try {
            // TODO
            Ordenador o;
            con.irAnterior();
            o = con.obtenerOrdenador();
            mostrarOrdenador(o);
            actualizaBotones();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaListadoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert a = new Alert(tipo);
        a.setTitle(tipo == Alert.AlertType.ERROR ? "Error" : tipo == Alert.AlertType.WARNING ? "Advertencia" : "Información");
        a.setHeaderText(null);
        a.setContentText(mensaje);
        a.showAndWait();
    }
    
    private void actualizaBotones() {
        try {
            boolean esPrimero = con.isPrimero();
            boolean esUltimo = con.isUltimo();
            int pos = con.posRs();
            int total = con.tamanyo();

            if (textNumSerie.getText().isEmpty() && textModelo.getText().isEmpty()) {
                 esPrimero = true;
                 esUltimo = true;
            }

            btPrimero.setDisable(esPrimero);
            btAnterior.setDisable(esPrimero);
            btSiguiente.setDisable(esUltimo);
            btUltimo.setDisable(esUltimo);
            idPos.setText(pos + "/" + total);
        } catch (Exception e) {
            btPrimero.setDisable(true);
            btAnterior.setDisable(true);
            btSiguiente.setDisable(true);
            btUltimo.setDisable(true);
            idPos.setText("0/0");
        }
    }
    
    public void mostrarOrdenador(Ordenador ord) {
        if (ord == null) return;

        textNumSerie.setText(Integer.toString(ord.getNum_serie()));
        textMarca.setText(ord.getMarca());
        textModelo.setText(ord.getModelo());
        textMicro.setText(ord.getMicroprocesador());
        textMemoria.setText(ord.getMemoria());
        radioDvdSi.setSelected(ord.isLectorDVD());
        radioDvdNo.setSelected(!ord.isLectorDVD());

        if (ord instanceof Sobremesa) {
            Sobremesa sobre = (Sobremesa) ord;
            ComboBox_Tipo.getSelectionModel().select("01 - Sobremesa");
            sliderUSB.setValue(sobre.getNumUSB());
            radioSonSi.setSelected(sobre.isTarjetaSonido());
            radioSonNo.setSelected(!sobre.isTarjetaSonido());
            textTamanyo.setText(sobre.getTamaño());

            pSobre.setVisible(true);
            pSobre.setDisable(false);
            pPor.setVisible(false);
            pPor.setDisable(true);
        } else if (ord instanceof Portatil) {
            Portatil port = (Portatil) ord;
            ComboBox_Tipo.getSelectionModel().select("02 - Portátil");
            textPeso.setText(String.valueOf(port.getPeso()));
            textPulgada.setText(String.valueOf(port.getPulgadas()));

            pPor.setVisible(true);
            pPor.setDisable(false);
            pSobre.setVisible(false);
            pSobre.setDisable(true);
        }
    }
    @FXML
    public void cerrarVentana() {
        try {
            con.cerrarConexion();
            Stage stage = (Stage) textNumSerie.getScene().getWindow();
            stage.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
