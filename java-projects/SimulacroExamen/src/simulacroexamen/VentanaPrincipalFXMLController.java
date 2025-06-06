package simulacroexamen;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class VentanaPrincipalFXMLController {

    @FXML private TextField txtIdPrestamo;
    @FXML private TextField txtIdLibro;
    @FXML private TextField txtTituloLibro;
    @FXML private TextField txtAutorLibro;
    @FXML private TextField txtNombreUsuario;
    @FXML private DatePicker dpFechaPrestamo;
    @FXML private Slider sliderDuracion;
    @FXML private Label lblDuracionValor;
    @FXML private CheckBox chkDevuelto;
    @FXML private Label lblEstado;

    @FXML private Button btnAgregar;
    @FXML private Button btnBuscar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;
    @FXML private Button btnExportar;
    @FXML private Button btnLimpiar;
    @FXML private Button btnPrimero;
    @FXML private Button btnAnterior;
    @FXML private Button btnSiguiente;
    @FXML private Button btnUltimo;

    private ConectaBBDD conexionBBDD;
    private List<Prestamo> listaPrestamos;
    private List<Libro> listaLibros;
    private int indiceActualPrestamo = -1;

    @FXML
    public void initialize() {
        conexionBBDD = new ConectaBBDD();
        listaPrestamos = new ArrayList<>();
        listaLibros = new ArrayList<>();

        sliderDuracion.valueProperty().addListener((obs, oldVal, newVal) -> 
            lblDuracionValor.setText(String.valueOf(newVal.intValue()))
        );
        
        txtIdLibro.textProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null && !newVal.trim().isEmpty()) {
                try {
                    int idLibro = Integer.parseInt(newVal.trim());
                    buscarYMostrarLibro(idLibro);
                } catch (NumberFormatException e) {
                    txtTituloLibro.clear();
                    txtAutorLibro.clear();
                }
            } else {
                 txtTituloLibro.clear();
                 txtAutorLibro.clear();
            }
        });

        cargarLibrosDesdeBD();
        cargarPrestamosDesdeBD();
        mostrarPrestamoActual();
        actualizarEstadoBotonesNavegacion();
    }

    private void cargarLibrosDesdeBD() {
        listaLibros.clear();
        if (conexionBBDD.conectar() != null) {
            try (ResultSet rs = conexionBBDD.ejecutarConsulta("SELECT id, titulo, autor FROM libros")) {
                while (rs.next()) {
                    listaLibros.add(new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor")));
                }
            } catch (SQLException e) {
                mostrarAlerta("Error BD", "No se pudieron cargar los libros: " + e.getMessage(), AlertType.ERROR);
            } finally {
                conexionBBDD.desconectar();
            }
        }
    }
    
    private void buscarYMostrarLibro(int idLibro) {
        Optional<Libro> libroOpt = listaLibros.stream().filter(l -> l.getId() == idLibro).findFirst();
        if (libroOpt.isPresent()) {
            Libro libro = libroOpt.get();
            txtTituloLibro.setText(libro.getTitulo());
            txtAutorLibro.setText(libro.getAutor());
        } else {
            txtTituloLibro.clear();
            txtAutorLibro.clear();
        }
    }


    private void cargarPrestamosDesdeBD() {
        listaPrestamos.clear();
        if (conexionBBDD.conectar() != null) {
            String sql = "SELECT p.id, p.id_libro, p.nombre_usuario, p.fecha_prestamo, p.duracion_dias, p.devuelto " +
                         "FROM prestamos p ORDER BY p.id";
            try (ResultSet rs = conexionBBDD.ejecutarConsulta(sql)) {
                while (rs.next()) {
                    listaPrestamos.add(new Prestamo(
                            rs.getInt("id"),
                            rs.getInt("id_libro"),
                            rs.getString("nombre_usuario"),
                            rs.getDate("fecha_prestamo").toLocalDate(),
                            rs.getInt("duracion_dias"),
                            rs.getBoolean("devuelto")
                    ));
                }
                if (!listaPrestamos.isEmpty()) {
                    indiceActualPrestamo = 0;
                } else {
                    indiceActualPrestamo = -1;
                }
            } catch (SQLException e) {
                mostrarAlerta("Error BD", "No se pudieron cargar los préstamos: " + e.getMessage(), AlertType.ERROR);
            } finally {
                conexionBBDD.desconectar();
            }
        }
        mostrarPrestamoActual();
        actualizarEstadoBotonesNavegacion();
    }

    private void mostrarPrestamoActual() {
        if (indiceActualPrestamo != -1 && indiceActualPrestamo < listaPrestamos.size()) {
            Prestamo p = listaPrestamos.get(indiceActualPrestamo);
            txtIdPrestamo.setText(String.valueOf(p.getId()));
            txtIdLibro.setText(String.valueOf(p.getIdLibro()));
            buscarYMostrarLibro(p.getIdLibro()); // Esto actualizará titulo y autor
            txtNombreUsuario.setText(p.getNombreUsuario());
            dpFechaPrestamo.setValue(p.getFechaPrestamo());
            sliderDuracion.setValue(p.getDuracionDias());
            lblDuracionValor.setText(String.valueOf(p.getDuracionDias()));
            chkDevuelto.setSelected(p.isDevuelto());
            lblEstado.setText("Mostrando préstamo " + (indiceActualPrestamo + 1) + " de " + listaPrestamos.size());
        } else {
            handleLimpiarCampos();
            lblEstado.setText("No hay préstamos para mostrar.");
        }
    }

    @FXML
    private void handleAgregar() {
        if (!validarCamposPrincipales()) return;

        try {
            int idLibro = Integer.parseInt(txtIdLibro.getText());
            String nombreUsuario = txtNombreUsuario.getText();
            LocalDate fechaPrestamo = dpFechaPrestamo.getValue();
            int duracion = (int) sliderDuracion.getValue();
            boolean devuelto = chkDevuelto.isSelected();

            Optional<Libro> libroExiste = listaLibros.stream().filter(l -> l.getId() == idLibro).findFirst();
            if(!libroExiste.isPresent()){
                mostrarAlerta("Error", "El ID del libro no existe.", AlertType.ERROR);
                return;
            }

            if (conexionBBDD.conectar() != null) {
                String sql = "INSERT INTO prestamos (id_libro, nombre_usuario, fecha_prestamo, duracion_dias, devuelto) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = conexionBBDD.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                    pstmt.setInt(1, idLibro);
                    pstmt.setString(2, nombreUsuario);
                    pstmt.setDate(3, java.sql.Date.valueOf(fechaPrestamo));
                    pstmt.setInt(4, duracion);
                    pstmt.setBoolean(5, devuelto);
                    int affectedRows = pstmt.executeUpdate();
                    if (affectedRows > 0) {
                        mostrarAlerta("Éxito", "Préstamo agregado correctamente.", AlertType.INFORMATION);
                        cargarPrestamosDesdeBD();
                        handleUltimo(); 
                    }
                } catch (SQLException e) {
                    mostrarAlerta("Error BD", "No se pudo agregar el préstamo: " + e.getMessage(), AlertType.ERROR);
                } finally {
                    conexionBBDD.desconectar();
                }
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error de formato", "ID Libro debe ser un número.", AlertType.ERROR);
        } catch (NullPointerException e) {
             mostrarAlerta("Error de datos", "Fecha de préstamo es obligatoria.", AlertType.ERROR);
        }
    }
    
    @FXML
    private void handleBuscar() { // Busca préstamos por ID de Libro
        if (txtIdLibro.getText().trim().isEmpty()) {
            mostrarAlerta("Información", "Ingrese un ID de Libro para buscar sus préstamos.", AlertType.INFORMATION);
            cargarPrestamosDesdeBD(); // Carga todos si no hay ID
            return;
        }
        try {
            int idLibroBusqueda = Integer.parseInt(txtIdLibro.getText().trim());
            listaPrestamos.clear();
             if (conexionBBDD.conectar() != null) {
                String sql = "SELECT p.id, p.id_libro, p.nombre_usuario, p.fecha_prestamo, p.duracion_dias, p.devuelto " +
                             "FROM prestamos p WHERE p.id_libro = ? ORDER BY p.id";
                try (PreparedStatement pstmt = conexionBBDD.getConnection().prepareStatement(sql)) {
                    pstmt.setInt(1, idLibroBusqueda);
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        listaPrestamos.add(new Prestamo(
                                rs.getInt("id"),
                                rs.getInt("id_libro"),
                                rs.getString("nombre_usuario"),
                                rs.getDate("fecha_prestamo").toLocalDate(),
                                rs.getInt("duracion_dias"),
                                rs.getBoolean("devuelto")
                        ));
                    }
                    if (!listaPrestamos.isEmpty()) {
                        indiceActualPrestamo = 0;
                        mostrarAlerta("Búsqueda", "Se encontraron " + listaPrestamos.size() + " préstamos para el libro ID " + idLibroBusqueda, AlertType.INFORMATION);
                    } else {
                        indiceActualPrestamo = -1;
                         mostrarAlerta("Búsqueda", "No se encontraron préstamos para el libro ID " + idLibroBusqueda, AlertType.INFORMATION);
                    }
                } catch (SQLException e) {
                    mostrarAlerta("Error BD", "Error al buscar préstamos: " + e.getMessage(), AlertType.ERROR);
                } finally {
                    conexionBBDD.desconectar();
                }
            }
            mostrarPrestamoActual();
            actualizarEstadoBotonesNavegacion();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error de formato", "ID Libro para búsqueda debe ser un número.", AlertType.ERROR);
            cargarPrestamosDesdeBD();
        }
    }


    @FXML
    private void handleActualizar() {
        if (txtIdPrestamo.getText().isEmpty() || indiceActualPrestamo == -1) {
            mostrarAlerta("Error", "No hay préstamo seleccionado para actualizar.", AlertType.ERROR);
            return;
        }
        if (!validarCamposPrincipales()) return;

        try {
            int idPrestamo = Integer.parseInt(txtIdPrestamo.getText());
            int idLibro = Integer.parseInt(txtIdLibro.getText());
            String nombreUsuario = txtNombreUsuario.getText();
            LocalDate fechaPrestamo = dpFechaPrestamo.getValue();
            int duracion = (int) sliderDuracion.getValue();
            boolean devuelto = chkDevuelto.isSelected();

            Optional<Libro> libroExiste = listaLibros.stream().filter(l -> l.getId() == idLibro).findFirst();
            if(!libroExiste.isPresent()){
                mostrarAlerta("Error", "El ID del libro no existe.", AlertType.ERROR);
                return;
            }

            if (conexionBBDD.conectar() != null) {
                String sql = "UPDATE prestamos SET id_libro = ?, nombre_usuario = ?, fecha_prestamo = ?, duracion_dias = ?, devuelto = ? WHERE id = ?";
                try (PreparedStatement pstmt = conexionBBDD.getConnection().prepareStatement(sql)) {
                    pstmt.setInt(1, idLibro);
                    pstmt.setString(2, nombreUsuario);
                    pstmt.setDate(3, java.sql.Date.valueOf(fechaPrestamo));
                    pstmt.setInt(4, duracion);
                    pstmt.setBoolean(5, devuelto);
                    pstmt.setInt(6, idPrestamo);
                    int affectedRows = pstmt.executeUpdate();
                    if (affectedRows > 0) {
                        mostrarAlerta("Éxito", "Préstamo actualizado correctamente.", AlertType.INFORMATION);
                        int indiceGuardado = indiceActualPrestamo;
                        cargarPrestamosDesdeBD();
                        if (indiceGuardado < listaPrestamos.size()) {
                            indiceActualPrestamo = indiceGuardado;
                            mostrarPrestamoActual();
                        } else {
                            handlePrimero();
                        }
                    } else {
                         mostrarAlerta("Error", "No se pudo actualizar el préstamo (ID no encontrado).", AlertType.ERROR);
                    }
                } catch (SQLException e) {
                    mostrarAlerta("Error BD", "No se pudo actualizar el préstamo: " + e.getMessage(), AlertType.ERROR);
                } finally {
                    conexionBBDD.desconectar();
                }
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error de formato", "ID Préstamo o ID Libro debe ser un número.", AlertType.ERROR);
        } catch (NullPointerException e) {
             mostrarAlerta("Error de datos", "Fecha de préstamo es obligatoria.", AlertType.ERROR);
        }
    }

    @FXML
    private void handleEliminar() {
        if (txtIdPrestamo.getText().isEmpty() || indiceActualPrestamo == -1) {
            mostrarAlerta("Error", "No hay préstamo seleccionado para eliminar.", AlertType.ERROR);
            return;
        }
        try {
            int idPrestamo = Integer.parseInt(txtIdPrestamo.getText());
            if (conexionBBDD.conectar() != null) {
                String sql = "DELETE FROM prestamos WHERE id = ?";
                try (PreparedStatement pstmt = conexionBBDD.getConnection().prepareStatement(sql)) {
                    pstmt.setInt(1, idPrestamo);
                    int affectedRows = pstmt.executeUpdate();
                    if (affectedRows > 0) {
                        mostrarAlerta("Éxito", "Préstamo eliminado correctamente.", AlertType.INFORMATION);
                        cargarPrestamosDesdeBD(); // Recarga y va al primero o limpia
                    } else {
                         mostrarAlerta("Error", "No se pudo eliminar el préstamo (ID no encontrado).", AlertType.ERROR);
                    }
                } catch (SQLException e) {
                    mostrarAlerta("Error BD", "No se pudo eliminar el préstamo: " + e.getMessage(), AlertType.ERROR);
                } finally {
                    conexionBBDD.desconectar();
                }
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error de formato", "ID Préstamo debe ser un número.", AlertType.ERROR);
        }
    }

    @FXML
private void handleExportar() {
    if (listaPrestamos.isEmpty()) {
        mostrarAlerta("Información", "No hay préstamos para exportar.", AlertType.INFORMATION);
        return;
    }
    String lineSeparator = System.lineSeparator(); 

    try (FileWriter writer = new FileWriter("prestamos_exportados.txt")) {
        writer.write("ID_Prestamo;ID_Libro;Titulo_Libro;Autor_Libro;Nombre_Usuario;Fecha_Prestamo;Duracion_Dias;Devuelto" + lineSeparator);

        for (Prestamo p : listaPrestamos) {
            Libro libroAsociado = listaLibros.stream()
                                    .filter(l -> l.getId() == p.getIdLibro())
                                    .findFirst().orElse(new Libro(0, "Desconocido", "Desconocido"));

            String lineaDatos = String.format("%d;%d;%s;%s;%s;%s;%d;%s",
                    p.getId(),
                    p.getIdLibro(),
                    libroAsociado.getTitulo(),
                    libroAsociado.getAutor(),
                    p.getNombreUsuario(),
                    p.getFechaPrestamo().toString(),
                    p.getDuracionDias(),
                    p.isDevuelto() ? "SI" : "NO");
            
            writer.write(lineaDatos + lineSeparator);
        }
        mostrarAlerta("Éxito", "Datos de préstamos exportados a prestamos_exportados.txt", AlertType.INFORMATION);
    } catch (IOException e) {
        mostrarAlerta("Error de Archivo", "No se pudo exportar: " + e.getMessage(), AlertType.ERROR);
    }
}

    
    @FXML
    private void handleLimpiarCampos() {
        txtIdPrestamo.clear();
        txtIdLibro.clear();
        txtTituloLibro.clear();
        txtAutorLibro.clear();
        txtNombreUsuario.clear();
        dpFechaPrestamo.setValue(null);
        sliderDuracion.setValue(7);
        lblDuracionValor.setText("7");
        chkDevuelto.setSelected(false);
        lblEstado.setText("Campos limpiados. Listo para nueva entrada o búsqueda.");
    }


    @FXML private void handlePrimero() {
        if (!listaPrestamos.isEmpty()) {
            indiceActualPrestamo = 0;
            mostrarPrestamoActual();
        }
        actualizarEstadoBotonesNavegacion();
    }

    @FXML private void handleAnterior() {
        if (indiceActualPrestamo > 0) {
            indiceActualPrestamo--;
            mostrarPrestamoActual();
        }
        actualizarEstadoBotonesNavegacion();
    }

    @FXML private void handleSiguiente() {
        if (indiceActualPrestamo < listaPrestamos.size() - 1) {
            indiceActualPrestamo++;
            mostrarPrestamoActual();
        }
        actualizarEstadoBotonesNavegacion();
    }

    @FXML private void handleUltimo() {
        if (!listaPrestamos.isEmpty()) {
            indiceActualPrestamo = listaPrestamos.size() - 1;
            mostrarPrestamoActual();
        }
        actualizarEstadoBotonesNavegacion();
    }
    
    private void actualizarEstadoBotonesNavegacion() {
        boolean hayPrestamos = !listaPrestamos.isEmpty();
        btnPrimero.setDisable(!hayPrestamos || indiceActualPrestamo == 0);
        btnAnterior.setDisable(!hayPrestamos || indiceActualPrestamo == 0);
        btnSiguiente.setDisable(!hayPrestamos || indiceActualPrestamo == listaPrestamos.size() - 1);
        btnUltimo.setDisable(!hayPrestamos || indiceActualPrestamo == listaPrestamos.size() - 1);

        btnActualizar.setDisable(!hayPrestamos);
        btnEliminar.setDisable(!hayPrestamos);
    }

    private boolean validarCamposPrincipales() {
        if (txtIdLibro.getText().trim().isEmpty() || 
            txtNombreUsuario.getText().trim().isEmpty() ||
            dpFechaPrestamo.getValue() == null) {
            mostrarAlerta("Campos incompletos", "ID Libro, Nombre Usuario y Fecha Préstamo son obligatorios.", AlertType.WARNING);
            return false;
        }
        try {
            Integer.parseInt(txtIdLibro.getText().trim());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error de formato", "ID Libro debe ser un número.", AlertType.ERROR);
            return false;
        }
        return true;
    }

    private void mostrarAlerta(String titulo, String mensaje, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}