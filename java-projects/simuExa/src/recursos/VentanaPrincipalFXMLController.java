/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package recursos;

import controles.ConectaBBDD;
import controles.Libro;
import controles.Prestamo;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import java.sql.ResultSet;


/**
 * FXML Controller class
 *
 * @author Damián
 */
public class VentanaPrincipalFXMLController implements Initializable {
    
    private ConectaBBDD con;
    
    @FXML
    private TextField txtIdPrestamo, txtIdLibro, txtTituloLibro, txtAutorLibro, txtNombreUsuario;
    
    @FXML
    private DatePicker dpFechaPrestamo;
    
    @FXML
    private CheckBox chkDevuelto;
    
    @FXML
    private Slider sliderDuracion;
    
    @FXML
    private Button btnPrimero, btnAnterior, btnSiguiente, btnUltimo;
    
    @FXML
    private void handleAgregar(){
        Libro l;
        Prestamo p;
        int graba;
        int graba2;
        ConectaBBDD con2 = new ConectaBBDD();
        // creamos la alerta
        Alert a = new Alert(Alert.AlertType.NONE);
        if (valida()) {
            try {
                con2.conecta();
                con2.crearSentencia();
                // recogemos los valores de la ventana
                l = obtenLib();
                p = obtenPre();
                graba = con2.grabaRegistroL(l);
                graba2 = con2.grabaRegistroP(p);
                if (graba == 1 && graba2 == 1) {
                    a.setAlertType(Alert.AlertType.INFORMATION);
                    a.setHeaderText(null);
                    a.setContentText("\"* * * Artículo insertado * * * \"");
                    a.show();
                } else if (graba == -1) {
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setHeaderText(null);
                    a.setContentText("ERROR: integridad referencial o SQL truncada");
                    a.show();
                } else {
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setHeaderText(null);
                    a.setContentText("* * * no se pudo insertar Artículo * * *");
                    a.show();
                }
                con2.cerrarConexionL();
                con2.cerrarConexionP();
            } catch (Exception ex) {
                a.setAlertType(Alert.AlertType.ERROR);
                a.setHeaderText(null);
                a.setContentText("ERROR: con la BBDD.");
                a.show();
            }
        }
    }
    
    @FXML
    private void handleBuscar(){
        
    }
    
    @FXML
    private void handleActualizar(){
        Libro l;
        Prestamo p;
        int graba1;
        int graba2;
        ConectaBBDD con2 = new ConectaBBDD();
        // creamos la alerta
        Alert a = new Alert(Alert.AlertType.NONE);
        if (valida()) {
            try {
                con2.conecta();
                con2.crearSentencia();
                l = obtenLib();
                p = obtenPre();
                graba1 = con2.modiRegistroL(l);
                graba2 = con2.modiRegistroP(p);
                // podemos continuar
                if (graba1 == 1 && graba1 == 1) {
                    a.setAlertType(Alert.AlertType.INFORMATION);
                    a.setHeaderText(null);
                    a.setContentText("* * * Ha modificado un Artículo * * * ");
                    a.show();

                } else if (graba1 == -1 || graba2 ==-1) {
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setHeaderText(null);
                    a.setContentText("ERROR: integridad referencial o SQL truncada");
                    a.show();
                } else {
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setHeaderText(null);
                    a.setContentText("* * * no se pudo modificar Artículo * * *");
                    a.show();
                }
                con2.cerrarConexionL();
                con2.cerrarConexionP();
            } catch (Exception ex) {
                a.setAlertType(Alert.AlertType.ERROR);
                a.setHeaderText(null);
                a.setContentText("ERROR: con la BBDD.");
                a.show();
            }

        }
    }
    
    @FXML
    private void handleEliminar() {
        try {
            // Obtener el ID desde el TextField
            int idP = Integer.parseInt(txtIdPrestamo.getText());
            int idL = Integer.parseInt(txtIdPrestamo.getText());
            
            // Primero, eliminar los préstamos que usen ese libro
            int prestamosEliminados = con.eliminarPrestamoPorIdLibro(idP);

            // Luego, eliminar el libro
            int libroEliminado = con.eliminarLibroPorId(idL);

            if (libroEliminado > 0) {
                System.out.println("Libro y préstamos eliminados correctamente.");
            } else {
                System.out.println("No se encontró ningún libro con ese ID.");
            }

        } catch (NumberFormatException e) {
            System.out.println("El ID debe ser un número válido.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    
    @FXML
private void handleExportar() {
    try {
        if (con == null) {
            con = new ConectaBBDD();
            con.conecta();
            con.crearSentencia();
        }

        con.ejecutaSQLP("SELECT * FROM prestamos"); 

        ResultSet rs = con.getResultSetPrestamos(); 

        FileWriter writer = new FileWriter(System.getProperty("user.home") + "/reporte_exportados.txt");

        con.irAntesDelPrimeroP();

        while (rs.next()) {
            int id = rs.getInt("id");
            String titulo = rs.getString("titulo");
            String autor = rs.getString("autor");
            String nombre = rs.getString("nombre_usuario");
            LocalDate fecha = rs.getDate("fecha_prestamo").toLocalDate();
            int duracion = rs.getInt("duracion_dias");
            boolean devuelto = rs.getBoolean("devuelto");

            String linea = String.format(
                "ID: %d | Titulo: %s | Autor: %s | Nombre: %s | Fecha: %s | Duracion: %d | Devuelto: %b\n",
                id, titulo, autor, nombre, fecha.toString(), duracion, devuelto
            );

            writer.write(linea);
        }

        writer.close();

        mostrarAlerta("El fichero se ha exportado correctamente.", Alert.AlertType.INFORMATION);

    } catch (IOException | SQLException e) {
        mostrarAlerta("Error al exportar el fichero.", Alert.AlertType.ERROR);
        e.printStackTrace();
    }
}

    
    private Libro obtenLib() {
        Libro l;
        int ide;
        String titulo;
        String autor;        

        ide = Integer.parseInt(txtIdLibro.getText());
        titulo = txtTituloLibro.getText();
        autor = txtAutorLibro.getText();

        if (ide == 0) {
            l = new Libro(0, titulo, autor);
        } else {
            l = new Libro(ide, titulo, autor);
        }
        return l;
    }
    
    private Prestamo obtenPre() {
        Prestamo p;
        int ide = Integer.parseInt(txtIdPrestamo.getText());
        int ideL = Integer.parseInt(txtIdLibro.getText());
        String nombre_usuario = txtNombreUsuario.getText();
        LocalDate fechaP = dpFechaPrestamo.getValue();
        int duracionD = (int) sliderDuracion.getValue();
        boolean dev = chkDevuelto.isSelected();

        if (ide == 0) {
            p = new Prestamo(0, ideL, nombre_usuario, fechaP, duracionD, dev);
        } else {
            p = new Prestamo(ide, ideL, nombre_usuario, fechaP, duracionD, dev);
        }
        return p;
    }
    
    private boolean cargaPantalla(Libro l, Prestamo p) {
        Alert a = new Alert(Alert.AlertType.NONE);
        boolean ok = true;
        try {
            txtIdPrestamo.setText(String.valueOf(p.getId()));
            txtIdLibro.setText(String.valueOf(l.getId()));
            txtTituloLibro.setText(l.getTitulo());
            txtAutorLibro.setText(l.getAutor());
            txtNombreUsuario.setText(p.getNombreUsuario());
            dpFechaPrestamo.setValue(p.getFechaPrestamo());
            chkDevuelto.setSelected(p.isDevuelto());
        } catch (Exception ex) {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("ERROR: No se ha podido cargar la pantalla");
            a.show();
            ok = false;
        }
        return ok;
    }
    
    private boolean valida (){
        int idL = Integer.parseInt(txtIdPrestamo.getText());
        String t = txtTituloLibro.getText();
        String a = txtAutorLibro.getText();
        String nu = txtNombreUsuario.getText();
        LocalDate fp = dpFechaPrestamo.getValue();
        
        if (t.isEmpty() || a.isEmpty() || nu.isEmpty() || fp.equals("") || idL < 1) {
            mostrarAlerta("Todos los campos (excepto ID para inserción) son obligatorios.", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }
    
    private void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert a = new Alert(tipo);
        a.setTitle(tipo == Alert.AlertType.ERROR ? "Error" : tipo == Alert.AlertType.WARNING ? "Advertencia" : "Información");
        a.setHeaderText(null);
        a.setContentText(mensaje);
        a.showAndWait();
    }
    
    @FXML
    public void handlePrimero() {
        // TODO
        Libro l;
        Prestamo p;
        con.irPrimero();
        con.irPrimeroP();
        l = con.devRegistroActualL();
        p = con.devRegistroActualP();
        cargaPantalla(l, p);
        actualizaBotones();
    }

    @FXML
    public void handleUltimo() {
        // TODO
        Libro l;
        Prestamo p;
        con.irFinal();
        con.irFinalP();
        l = con.devRegistroActualL();
        p = con.devRegistroActualP();
        cargaPantalla(l,p);
        actualizaBotones();
    }

    @FXML
    public void handleSiguiente() {
        // TODO
        Libro l;
        Prestamo p;
        con.irSiguiente();
        con.irSiguienteP();
        l = con.devRegistroActualL();
        p = con.devRegistroActualP();
        cargaPantalla(l,p);
        actualizaBotones();
    }

    @FXML
    public void handleAnterior() {
        // TODO
        Libro l;
        Prestamo p;
        con.irAnterior();
        con.irAnteriorP();
        l = con.devRegistroActualL();
        p = con.devRegistroActualP();
        cargaPantalla(l,p);
        actualizaBotones();;
    }
    private void actualizaBotones() {
        try {
            boolean esPrimero = con.isPrimero();
            boolean esUltimo = con.isUltimo();

            btnPrimero.setDisable(esPrimero);
            btnAnterior.setDisable(esPrimero);
            btnSiguiente.setDisable(esUltimo);
            btnUltimo.setDisable(esUltimo);
        } catch (SQLException ex) {
            System.out.println("Error al actualizar los botones");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Libro l;
        Prestamo p;
        
        try {
            con = new ConectaBBDD();
            con.conecta();
            con.crearSentencia();
            con.ejecutaSQLL("SELECT * FROM libros");
            con.ejecutaSQLP("SELECT * FROM prestamos");
            con.irPrimeroP();
            try {
                if (con.irPrimero()) {
                    l = con.devRegistroActualL();
                    p = con.devRegistroActualP();
                    cargaPantalla(l,p);
                    btnPrimero.setDisable(true);
                    btnAnterior.setDisable(true);
                }
                System.out.println(con.tamanyoL());
                if (con.isPrimero() && (con.tamanyoL() > 1)) {
                    btnSiguiente.setDisable(false);
                    btnUltimo.setDisable(false);

                } else {
                    btnPrimero.setDisable(true);
                    btnAnterior.setDisable(true);
                    btnSiguiente.setDisable(true);
                    btnUltimo.setDisable(true);
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
    
}
