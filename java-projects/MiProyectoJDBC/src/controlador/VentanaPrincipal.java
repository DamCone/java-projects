package controlador;

import bbdd.ConectaBBDD;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modelo.Articulo;
import javafx.scene.control.Alert.AlertType;

import java.sql.SQLException;
import java.util.Optional;

public class VentanaPrincipal {

    @FXML private TextField id, nombre, precio, codigo, grupo;
    @FXML private Button btInsertar, btModificar, btBuscar, btPrimero, btAnterior, btSiguiente, btUltimo;

    private ConectaBBDD con;

    @FXML
    public void initialize() {
        id.setEditable(false);
        try {
            con = new ConectaBBDD();
            con.conecta();
            con.crearSentencia();
            cargarPrimerArticulo();
        } catch (Exception e) {
            mostrarAlerta("Error crítico al conectar con la BBDD: " + e.getMessage(), AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void cargarPrimerArticulo() throws SQLException {
        con.ejecutaSQL("SELECT * FROM articulos ORDER BY id"); // Ordenar por id es buena práctica
        if (con.irPrimero()) {
            Articulo a = con.devRegistroActual();
            if (a != null) {
                cargaArticulo(a);
            } else {
                 // devRegistroActual retornó null, puede ser un problema con el ResultSet
                limpiarCamposYControles();
                mostrarAlerta("No se pudo cargar el primer artículo.", AlertType.WARNING);
            }
        } else {
            // La tabla está vacía
            limpiarCamposYControles();
            mostrarAlerta("No hay artículos en la base de datos.", AlertType.INFORMATION);
        }
        actualizaBotones();
    }
    
    private void limpiarCamposYControles() {
        id.clear();
        nombre.clear();
        precio.clear();
        codigo.clear();
        grupo.clear();
        btModificar.setDisable(true); 
    }

        private Articulo obtenArt() {
        String ide = id.getText(); 
        String nom = nombre.getText();
        String cod = codigo.getText();
        float pre = 0;
        int gru = 0;

        try {
            pre = Float.parseFloat(precio.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("El precio debe ser un número válido.", AlertType.ERROR);
            return null;
        }
        try {
            gru = Integer.parseInt(grupo.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("El grupo debe ser un número entero válido.", AlertType.ERROR);
            return null;
        }

        if (ide == null || ide.isEmpty()) {
            return new Articulo(null, nom, pre, cod, gru); 
        } else {
            return new Articulo(ide, nom, pre, cod, gru);
        }
    }

    private boolean cargaArticulo(Articulo art) {
        if (art == null) {
            limpiarCamposYControles();
            mostrarAlerta("No hay artículo para cargar.", AlertType.WARNING);
            btModificar.setDisable(true);
            return false;
        }
        try {
            id.setText(art.getId() != null ? art.getId() : "");
            nombre.setText(art.getNombre() != null ? art.getNombre() : "");
            precio.setText(String.format("%.2f", art.getPrecio()).replace(",", "."));
            codigo.setText(art.getCodigo() != null ? art.getCodigo() : "");
            grupo.setText(String.valueOf(art.getGrupo()));
            btModificar.setDisable(false);
            return true;
        } catch (Exception ex) {
            mostrarAlerta("ERROR: No se ha podido cargar el Artículo en los campos: " + ex.getMessage(), AlertType.ERROR);
            ex.printStackTrace();
            btModificar.setDisable(true);
            return false;
        }
    }

    private void mostrarAlerta(String mensaje, AlertType tipo) {
        Alert a = new Alert(tipo);
        a.setTitle(tipo == AlertType.ERROR ? "Error" : tipo == AlertType.WARNING ? "Advertencia" : "Información");
        a.setHeaderText(null);
        a.setContentText(mensaje);
        a.showAndWait();
    }

    private boolean valida() {
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

    private void actualizaBotones() {
        try {
            boolean esPrimero = con.isPrimero();
            boolean esUltimo = con.isUltimo();

            if (id.getText().isEmpty() && nombre.getText().isEmpty()) {
                 esPrimero = true;
                 esUltimo = true;
            }

            btPrimero.setDisable(esPrimero);
            btAnterior.setDisable(esPrimero);
            btSiguiente.setDisable(esUltimo);
            btUltimo.setDisable(esUltimo);

        } catch (Exception e) {
            btPrimero.setDisable(true);
            btAnterior.setDisable(true);
            btSiguiente.setDisable(true);
            btUltimo.setDisable(true);
        }
    }

    @FXML
    private void insertarArticulo() {
        if (valida()) {
            Articulo art1 = obtenArt();
            if (art1 == null) return;

            try {
                Articulo articuloAInsertar = new Articulo(null, art1.getNombre(), art1.getPrecio(), art1.getCodigo(), art1.getGrupo());
                
                int graba = con.grabaRegistro(articuloAInsertar);
                if (graba > 0) {
                    mostrarAlerta("Artículo insertado correctamente.", AlertType.INFORMATION);
                    con.ejecutaSQL("SELECT * FROM articulos ORDER BY id");
                    if (con.irFinal()) {
                        cargaArticulo(con.devRegistroActual());
                    }
                    actualizaBotones();
                } else {
                    mostrarAlerta("ERROR al insertar artículo (ninguna fila afectada).", AlertType.ERROR);
                }
            } catch (SQLException ex) {
                mostrarAlerta("ERROR de BBDD al insertar: " + ex.getMessage(), AlertType.ERROR);
                ex.printStackTrace();
            } catch (Exception ex) {
                mostrarAlerta("ERROR inesperado al insertar: " + ex.getMessage(), AlertType.ERROR);
                ex.printStackTrace();
            }
        }
    }
    
    @FXML
    private void modificarArticulo() {
        if (id.getText().isEmpty()) {
            mostrarAlerta("No hay un artículo cargado para modificar. Busque uno primero.", AlertType.WARNING);
            return;
        }
        if (valida()) {
            Articulo art1 = obtenArt();
             if (art1 == null) return;

            try {
                int modificado = con.modiRegistro(art1);
                if (modificado > 0) {
                    mostrarAlerta("Artículo modificado correctamente.", AlertType.INFORMATION);
                    actualizaBotones(); 
                } else {
                    mostrarAlerta("ERROR: No se pudo modificar el artículo (ninguna fila afectada o no se encontró).", AlertType.ERROR);
                }
            } catch (SQLException ex) {
                mostrarAlerta("ERROR de BBDD al modificar: " + ex.getMessage(), AlertType.ERROR);
                ex.printStackTrace();
            } catch (Exception ex) {
                mostrarAlerta("ERROR inesperado al modificar: " + ex.getMessage(), AlertType.ERROR);
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void buscarArticulo() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Buscar Artículo");
        dialog.setHeaderText("Buscar Artículo por ID");
        dialog.setContentText("Introduce el ID del artículo:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(idBuscado -> {
            if (idBuscado.trim().isEmpty()) {
                mostrarAlerta("El ID de búsqueda no puede estar vacío.", AlertType.WARNING);
                return;
            }
            try {
                try {
                    Integer.parseInt(idBuscado.trim());
                } catch (NumberFormatException e) {
                    mostrarAlerta("El ID debe ser un número.", AlertType.WARNING);
                    return;
                }

                con.ejecutaSQL("SELECT * FROM articulos WHERE id = " + idBuscado.trim());
                if (con.irPrimero()) {
                    Articulo a = con.devRegistroActual();
                     if (a != null) {
                        cargaArticulo(a);
                    } else {
                        limpiarCamposYControles();
                        mostrarAlerta("Artículo con ID '" + idBuscado + "' no encontrado o error al leerlo.", AlertType.INFORMATION);
                    }
                } else {
                    limpiarCamposYControles();
                    mostrarAlerta("Artículo con ID '" + idBuscado + "' no encontrado.", AlertType.INFORMATION);
                }
                actualizaBotones();
            } catch (SQLException e) {
                mostrarAlerta("Error de BBDD al buscar artículo: " + e.getMessage(), AlertType.ERROR);
                e.printStackTrace();
            } catch (Exception e) {
                mostrarAlerta("Error inesperado al buscar artículo: " + e.getMessage(), AlertType.ERROR);
                e.printStackTrace();
            }
        });
    }


    @FXML
    private void irPrimero() {
        try {
            if (con.irPrimero()) {
                cargaArticulo(con.devRegistroActual());
            } else {
                mostrarAlerta("No hay primer registro (tabla vacía o error).", AlertType.INFORMATION);
                limpiarCamposYControles();
            }
            actualizaBotones();
        } catch (Exception e) {
            mostrarAlerta("Error al ir al primer registro: " + e.getMessage(), AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    private void irAnterior() {
        try {
            if (con.irAnterior()) {
                cargaArticulo(con.devRegistroActual());
            } else {
            }
            actualizaBotones();
        } catch (Exception e) {
            mostrarAlerta("Error al ir al registro anterior: " + e.getMessage(), AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    private void irSiguiente() {
        try {
            if (con.irSiguiente()) {
                cargaArticulo(con.devRegistroActual());
            } else {
            }
            actualizaBotones();
        } catch (Exception e) {
            mostrarAlerta("Error al ir al siguiente registro: " + e.getMessage(), AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    private void irUltimo() {
        try {
            if (con.irFinal()) {
                cargaArticulo(con.devRegistroActual());
            } else {
                 mostrarAlerta("No hay último registro (tabla vacía o error).", AlertType.INFORMATION);
                 limpiarCamposYControles();
            }
            actualizaBotones();
        } catch (Exception e) {
            mostrarAlerta("Error al ir al último registro: " + e.getMessage(), AlertType.ERROR);
            e.printStackTrace();
        }
    }
}