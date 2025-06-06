
package ejemploexa3aeva;

// MantArtGeneController.java
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class MantArtGeneController implements Initializable {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtCodigo;
    @FXML private TextField txtGrupoId;

    @FXML private Button btnPrimero;
    @FXML private Button btnAnterior;
    @FXML private Button btnSiguiente;
    @FXML private Button btnUltimo;

    @FXML private Button btnNuevo;
    @FXML private Button btnGuardar;
    @FXML private Button btnModificar;
    @FXML private Button btnEliminar;
    @FXML private Button btnCerrar;

    private ConectaBBDD conectorBBDD;
    private List<Articulo> listaArticulos;
    private int indiceActual = -1; // -1 significa que no hay artículo cargado o la lista está vacía
    private boolean enModoNuevo = false; // Para saber si estamos creando un nuevo artículo

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        conectorBBDD = new ConectaBBDD();
        cargarArticulos();
        mostrarArticuloActual();
        actualizarEstadoBotonesNavegacion();
        txtId.setEditable(false); // El ID no se edita manualmente
    }

    private void cargarArticulos() {
        listaArticulos = conectorBBDD.obtenerTodosLosArticulos();
        if (listaArticulos != null && !listaArticulos.isEmpty()) {
            if(indiceActual == -1 || indiceActual >= listaArticulos.size()){ // Si era -1 o se borró el último
                 indiceActual = 0; // Ir al primero por defecto
            }
            // Si indiceActual era válido, se mantiene para reflejar cambios.
        } else {
            indiceActual = -1; // No hay artículos
        }
    }

    private void mostrarArticuloActual() {
        if (indiceActual != -1 && listaArticulos != null && !listaArticulos.isEmpty() && indiceActual < listaArticulos.size()) {
            Articulo art = listaArticulos.get(indiceActual);
            txtId.setText(String.valueOf(art.getId()));
            txtNombre.setText(art.getNombre());
            txtPrecio.setText(String.valueOf(art.getPrecio()));
            txtCodigo.setText(art.getCodigo());
            txtGrupoId.setText(String.valueOf(art.getGrupo()));
            habilitarCamposEdicion(false); // Por defecto, no editables hasta "Nuevo" o "Modificar"
            enModoNuevo = false;
        } else {
            limpiarCampos();
            habilitarCamposEdicion(false);
        }
        actualizarEstadoBotonesNavegacion();
        actualizarEstadoBotonesCRUD();
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtPrecio.clear();
        txtCodigo.clear();
        txtGrupoId.clear();
    }

    private void habilitarCamposEdicion(boolean habilitar) {
        txtNombre.setEditable(habilitar);
        txtPrecio.setEditable(habilitar);
        txtCodigo.setEditable(habilitar);
        txtGrupoId.setEditable(habilitar);
    }
    
    private void actualizarEstadoBotonesNavegacion() {
        boolean hayArticulos = listaArticulos != null && !listaArticulos.isEmpty();
        btnPrimero.setDisable(!hayArticulos || indiceActual == 0 || enModoNuevo);
        btnAnterior.setDisable(!hayArticulos || indiceActual == 0 || enModoNuevo);
        btnSiguiente.setDisable(!hayArticulos || indiceActual == listaArticulos.size() - 1 || enModoNuevo);
        btnUltimo.setDisable(!hayArticulos || indiceActual == listaArticulos.size() - 1 || enModoNuevo);
    }

    private void actualizarEstadoBotonesCRUD() {
        boolean hayArticulos = listaArticulos != null && !listaArticulos.isEmpty();
        boolean hayArticuloSeleccionado = indiceActual != -1;

        btnNuevo.setDisable(enModoNuevo);
        btnGuardar.setDisable(!enModoNuevo); // Solo activo en modo nuevo
        
        // Modificar y Eliminar solo si no estamos en modo nuevo Y hay un artículo seleccionado
        btnModificar.setDisable(enModoNuevo || !hayArticuloSeleccionado); 
        btnEliminar.setDisable(enModoNuevo || !hayArticuloSeleccionado);
    }


    // --- ACCIONES DE NAVEGACIÓN ---
    @FXML void irAPrimero(ActionEvent event) {
        if (listaArticulos != null && !listaArticulos.isEmpty()) {
            indiceActual = 0;
            mostrarArticuloActual();
        }
    }

    @FXML void irAAnterior(ActionEvent event) {
        if (listaArticulos != null && !listaArticulos.isEmpty() && indiceActual > 0) {
            indiceActual--;
            mostrarArticuloActual();
        }
    }

    @FXML void irASiguiente(ActionEvent event) {
        if (listaArticulos != null && !listaArticulos.isEmpty() && indiceActual < listaArticulos.size() - 1) {
            indiceActual++;
            mostrarArticuloActual();
        }
    }

    @FXML void irAUltimo(ActionEvent event) {
        if (listaArticulos != null && !listaArticulos.isEmpty()) {
            indiceActual = listaArticulos.size() - 1;
            mostrarArticuloActual();
        }
    }

    // --- ACCIONES CRUD ---
    @FXML void accionNuevo(ActionEvent event) {
        enModoNuevo = true;
        limpiarCampos();
        txtId.setText("(Nuevo)"); // Indicador visual
        habilitarCamposEdicion(true);
        txtNombre.requestFocus();
        actualizarEstadoBotonesNavegacion(); // Deshabilita navegación
        actualizarEstadoBotonesCRUD();
    }

    @FXML void accionGuardar(ActionEvent event) { // Este botón es para GUARDAR un NUEVO artículo
        if (!enModoNuevo) {
            mostrarAlerta("Información", "Acción no válida", "Use 'Modificar' para cambiar un artículo existente.", Alert.AlertType.INFORMATION);
            return;
        }

        // Validaciones básicas
        if (txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty() || 
            txtCodigo.getText().isEmpty() || txtGrupoId.getText().isEmpty()) {
            mostrarAlerta("Error", "Campos vacíos", "Todos los campos (excepto ID) son obligatorios.", Alert.AlertType.ERROR);
            return;
        }

        try {
            String nombre = txtNombre.getText();
            float precio = Float.parseFloat(txtPrecio.getText());
            String codigo = txtCodigo.getText();
            int grupoId = Integer.parseInt(txtGrupoId.getText());

            Articulo nuevoArticulo = new Articulo(nombre, precio, codigo, grupoId);
            if (conectorBBDD.insertarArticulo(nuevoArticulo)) {
                mostrarAlerta("Éxito", "Artículo Guardado", "El nuevo artículo ha sido guardado.", Alert.AlertType.INFORMATION);
                cargarArticulos(); // Recargar lista
                // Ir al último artículo (el recién insertado)
                if (listaArticulos != null && !listaArticulos.isEmpty()) {
                     indiceActual = listaArticulos.size() -1; // Asumiendo que se añade al final por ID autoincremental
                }
                enModoNuevo = false;
                mostrarArticuloActual(); // Muestra el nuevo o el primero si la lista estaba vacía
            } else {
                mostrarAlerta("Error", "Error al Guardar", "No se pudo guardar el artículo en la BBDD.", Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Formato Incorrecto", "Precio e ID Grupo deben ser números válidos.", Alert.AlertType.ERROR);
        }
    }

    @FXML void accionModificar(ActionEvent event) { // Este botón es para MODIFICAR el artículo EN PANTALLA
        if (enModoNuevo || indiceActual == -1) {
             mostrarAlerta("Información", "Acción no válida", "No hay artículo seleccionado para modificar o está en modo nuevo.", Alert.AlertType.INFORMATION);
            return;
        }
        // Si los campos no están editables, los habilita para modificar
        if (!txtNombre.isEditable()) {
            habilitarCamposEdicion(true);
            txtNombre.requestFocus();
            mostrarAlerta("Información", "Modo Edición", "Campos habilitados para edición. Realice los cambios y pulse 'Modificar' de nuevo para guardar.", Alert.AlertType.INFORMATION);
            // Cambiar texto del botón Modificar a "Guardar Cambios" podría ser una mejora UX
            return;
        }

        // Si ya estaban editables, procede a guardar los cambios
        try {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            float precio = Float.parseFloat(txtPrecio.getText());
            String codigo = txtCodigo.getText();
            int grupoId = Integer.parseInt(txtGrupoId.getText());

            if (nombre.isEmpty() || codigo.isEmpty()) {
                 mostrarAlerta("Error", "Campos vacíos", "Nombre y Código son obligatorios.", Alert.AlertType.ERROR);
                 return;
            }

            Articulo articuloModificado = new Articulo(id, nombre, precio, codigo, grupoId);
            if (conectorBBDD.modificarArticulo(articuloModificado)) {
                mostrarAlerta("Éxito", "Artículo Modificado", "El artículo ha sido modificado.", Alert.AlertType.INFORMATION);
                int indiceGuardado = indiceActual; // Guardar el índice actual
                cargarArticulos(); // Recargar lista
                indiceActual = indiceGuardado; // Restaurar índice
                mostrarArticuloActual(); // Muestra el artículo modificado
            } else {
                mostrarAlerta("Error", "Error al Modificar", "No se pudo modificar el artículo.", Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Formato Incorrecto", "Precio e ID Grupo deben ser números válidos. ID debe ser un número.", Alert.AlertType.ERROR);
        } catch (Exception e) {
            mostrarAlerta("Error", "Error General", "Ocurrió un error: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    

    @FXML void accionEliminar(ActionEvent event) {
        if (enModoNuevo || indiceActual == -1 || listaArticulos == null || listaArticulos.isEmpty()) {
            mostrarAlerta("Información", "No seleccionad", "No hay artículo seleccionado para eliminar.", Alert.AlertType.INFORMATION);
            return;
        }

        Articulo artAEliminar = listaArticulos.get(indiceActual);
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar Eliminación");
        confirmacion.setHeaderText("Eliminar Artículo: " + artAEliminar.getNombre());
        confirmacion.setContentText("¿Está seguro de que desea eliminar este artículo?");

        Optional<ButtonType> resultado = confirmacion.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            if (conectorBBDD.eliminarArticulo(artAEliminar.getId())) {
                mostrarAlerta("Éxito", "Artículo Eliminado", "El artículo ha sido eliminado.", Alert.AlertType.INFORMATION);
                int indiceBorrado = indiceActual;
                cargarArticulos(); // Recargar
                // Ajustar el índice actual después de borrar
                if (listaArticulos.isEmpty()) {
                    indiceActual = -1;
                } else if (indiceBorrado >= listaArticulos.size()) { // Si se borró el último
                    indiceActual = listaArticulos.size() - 1;
                } else {
                    indiceActual = indiceBorrado; // Mantenerse en el mismo índice (ahora apunta al siguiente)
                }
                mostrarArticuloActual();
            } else {
                mostrarAlerta("Error", "Error al Eliminar", "No se pudo eliminar el artículo.", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String titulo, String cabecera, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecera);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}