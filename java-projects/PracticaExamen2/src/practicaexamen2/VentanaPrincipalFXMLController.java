
package practicaexamen2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaPrincipalFXMLController implements Initializable {
    
    private ConectaBBDD con;
    
    @FXML
    private ComboBox ComboBox_Tipo;
    
    @FXML
    private Pane pSobre, pPor;
    
    @FXML
    private TextField textNumSerie, textMarca, textModelo, textMicro, textMemoria, textTamanyo, textPeso, textPulgada;
    
    @FXML
    private RadioButton radioDvdNo, radioDvdSi, radioSonSi, radioSonNo;
    
    @FXML
    private Slider sliderUSB;
    
    
    
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
                ComboBox_Tipo.getItems().add(linea);
                linea = "";
            }
            ComboBox_Tipo.getSelectionModel().selectFirst();
            
        } catch (SQLException ex) {
            // Alerta correspondiente
            System.out.println("Error 1");
        } catch (Exception ex) {
            // Alerta correspondiente
            System.out.println("Error 2");
            ex.printStackTrace();
        }
        pPor.setDisable(true);
    } 
    
    @FXML
    private void comboBox_TipoActionPerformed() {
        String tipo = (String) ComboBox_Tipo.getValue();
        tipo = tipo.substring(0, 2);
        System.out.println(tipo);
        if (tipo.equalsIgnoreCase("01")) {
            // habilitamos los controles del tipo 0
            pSobre.setDisable(false);
            pPor.setDisable(true);
        } else {
            // habilitamos los controles del tipo 1
            pPor.setDisable(false);
            pSobre.setDisable(true);
        }
    }
    
    @FXML
    void guardarOrdenador() {
        Ordenador ord1 = null;
        int numSerie, usb = -1, resp = -1;
        boolean dvd = true, sonido = true;
        String marca, modelo, micro, mem, tam, tipo;
        float peso = 0, pulga = 0;
        int i = 0;
        boolean datosCorrectos = true;

        //determinamos si es un sobremesa o un portatil
        tipo = (String) ComboBox_Tipo.getValue();
        tipo = tipo.substring(0, 2);
        //Datos comunes a ambos tipos de equipo                
        //Numero de serie, capturamos y tratamos excepción de conversión de datos
        try {
            numSerie = (Integer.parseInt(textNumSerie.getText()));
        } catch (NumberFormatException e) {
            // aviso a usuario
            System.out.println("Error en la entrada de datos del número de serie");
            numSerie = -1;
            datosCorrectos = false;
            textNumSerie.requestFocus();
        }
        try {
            //Verificamos que la marca no esté vacía
            if (textMarca.getText().equalsIgnoreCase("") && datosCorrectos) {
                // aviso de error
                System.out.println("No puedes dejar la Marca vacía");
            }
            marca = textMarca.getText();
            //que el modelo no esté vacío
            if (textModelo.getText().equalsIgnoreCase("") && datosCorrectos) {
                // aviso de error
                System.out.println("No puedes dejar el modelo vacío");
            }
            modelo = textModelo.getText();
            //que el microprocesador no esté vacío
            if (textMicro.getText().equalsIgnoreCase("") && datosCorrectos) {
                // aviso de error
                System.out.println("No puedes dejar el microprocesador vacío");
            }
            micro = textMicro.getText();
            //que la memoria no esté vacía
            if (textMemoria.getText().equalsIgnoreCase("") && datosCorrectos) {
                // aviso de error
                System.out.println("No puedes dejar la memoria vacía");
            }
            mem = textMemoria.getText();
            //DVD si / no
            if (radioDvdNo.isSelected()) {
                dvd = true;
            }
            if (radioDvdNo.isSelected()) {
                dvd = false;
            }
            //si es un sobremesa
            if (tipo.equalsIgnoreCase("01")) {
                //USB, capturamos
                usb = (int) sliderUSB.getValue();
                //Tarjeta de sonido si / no
                if (radioSonSi.isSelected()) {
                    sonido = true;
                }
                if (radioSonNo.isSelected()) {
                    sonido = false;
                }
                //que el tamaño no esté vacío
                if (textTamanyo.getText().equalsIgnoreCase("") && datosCorrectos) {
                    // aviso de error
                    System.out.println("No puedes dejar el tamaño vacío");
                }
                tam = textTamanyo.getText();
                //si los datos son correctos instanciamos un nuevo sobremesa y lo añadimos al array    
                if (datosCorrectos) {
                    ord1 = new Sobremesa(numSerie, marca, modelo, micro, mem, dvd, usb, sonido, tam);
                }
            } //si es un portatil
            else {
                //que el peso no esté vacío
                if (textPeso.getText().equalsIgnoreCase("") && datosCorrectos) {
                    // aviso de error
                    System.out.println("No puedes dejar el peso vacío");
                }
                try {
                    peso = Float.parseFloat(textPeso.getText());
                } catch (NumberFormatException e) {
                    // aviso de error
                    System.out.println("Error debe ser un número Atención!");
                    datosCorrectos = false;
                    textPeso.requestFocus();
                }
                //que las pulgadas no estén vacías
                if (textPulgada.getText().equalsIgnoreCase("") && datosCorrectos) {
                    // aviso de error
                    System.out.println("No puedes dejar las pulgadas vacío");
                }
                try {
                    pulga = Float.parseFloat(textPulgada.getText());
                } catch (NumberFormatException e) {
                    // aviso de error
                    System.out.println("Error debe ser un número Atención!");
                    datosCorrectos = false;
                    textPulgada.requestFocus();
                }
                //si los datos son correctos instanciamos un nuevo portátil y lo añadimos al array
                if (datosCorrectos) {
                    ord1 = new Portatil(numSerie, marca, modelo, micro, mem, dvd, peso, pulga);
                }
            }
            if (datosCorrectos) {
                // AQUÍ HARÍAMOS LA INSERCIÓN, CUANDO CAMPOS CORRECTOS    
                try {
                    con.conecta();
                    con.crearSentencia();
                    resp = con.grabaOrdenador(ord1);
                    System.out.println("respuesta  :" + resp);
                    if (resp != -1) {
                        // aviso al usuario
                        System.out.println("Ordenador insertado en la BBDD");
                    } else {
                        // aviso de error
                        System.out.println("No se ha podido insertar Atención!");
                    }
                    con.cerrarConexion();
                    // restableceDatos();
                } catch (SQLException ex) {
                    // aviso de error
                    System.out.println("Atención!");
                } catch (Exception ex) {
                    // aviso de error
                    System.out.println("Atención!");
                }

            }
        } catch (Exception e) {
            // aviso de error
            System.out.println("Atención:  Error");
            datosCorrectos = false;
        }

    }
    
    @FXML
    private void abrirVentanaBorrar() {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaBorrarFXML.fxml"));
        Parent rootBorrar = loader.load();
        Stage stageBorrar = new Stage();
        stageBorrar.setTitle("Borrar Ordenador");
        stageBorrar.setScene(new Scene(rootBorrar));
        stageBorrar.initModality(Modality.WINDOW_MODAL);
            stageBorrar.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipalFXMLController.class.getName()).log(Level.SEVERE, "Error al cargar VentanaBorrarFXML", ex);        
        }
    }
    
    @FXML
    private void abrirVentanaListar() {
        try {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("VentanaListarFXML.fxml"));
        Parent rootListar = loader1.load();
        Stage stageListar = new Stage();
        stageListar.setTitle("Lista Ordenadores");
        stageListar.setScene(new Scene(rootListar));
        stageListar.initModality(Modality.WINDOW_MODAL);
            stageListar.showAndWait();
            System.out.println("8");
        } catch (IOException ex) {
        Logger.getLogger(VentanaPrincipalFXMLController.class.getName()).log(Level.SEVERE, "Error al cargar VentanaBorrarFXML", ex);        }
    }
}
