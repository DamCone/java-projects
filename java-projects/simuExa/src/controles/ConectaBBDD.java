package controles;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.time.LocalDate;
import java.sql.PreparedStatement;


public class ConectaBBDD {

    private Connection conn = null;
    private Statement sentenciaSQL = null;
    private ResultSet rsL = null;
    private ResultSet rsP = null;

    public ConectaBBDD() {
    }

    public void conecta() throws SQLException {
        try {
            //Registrando el Driver
            String driver = "org.mariadb.jdbc.Driver";
            Class.forName(driver).newInstance();
            System.out.println("Driver " + driver + " Registrado correctamente");
            //Abrir la conexión con la Base de Datos
            System.out.println("Conectando con la Base de datos...");
            String jdbcUrl = "jdbc:mariadb://localhost:3308/libreria"; // o IP
            conn = DriverManager.getConnection(jdbcUrl, "root", "alumnoalumno");
            System.out.println("Conexión establecida con la Base de datos...");
        } catch (SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Errores de Class.forName
            e.printStackTrace();
        }
    }
    
     public void crearSentencia() {
        try {
            // Crear una sentencia para enviar consultas a la base de datos
            sentenciaSQL = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("\nSentencia creada con éxito.");
        } catch (SQLException ex) {
            System.out.println("\nERROR: NO se ha creado el objeto Statement.");
        }

    }
     
      public void cerrarConexionL() {
        // se cerrará la conexión a la BBDD.
        try {
            if (rsL != null) {
                rsL.close();
            }
            if (sentenciaSQL != null) {
                sentenciaSQL.close();
            }
            if (conn != null) {
                conn.close();
            }
            System.out.println("\nConexión cerrada con éxito.");
        } catch (SQLException ex) {
            System.out.println("\nERROR: NO se ha PODIDO CERRAR la conexión.");
        }
    }
      
      public void cerrarConexionP() {
        // se cerrará la conexión a la BBDD.
        try {
            if (rsP != null) {
                rsP.close();
            }
            if (sentenciaSQL != null) {
                sentenciaSQL.close();
            }
            if (conn != null) {
                conn.close();
            }
            System.out.println("\nConexión cerrada con éxito.");
        } catch (SQLException ex) {
            System.out.println("\nERROR: NO se ha PODIDO CERRAR la conexión.");
        }
    }
      
    public void ejecutaSQLL(String sql) {
        try {
            // realiza la consulta y devuelve resultados
            rsL = sentenciaSQL.executeQuery(sql);
            System.out.println("SQL ejecuta correctamente");
        } catch (SQLException ex) {
            System.out.println("ERROR: No se ha podido ejecutar la SQL: " + sql);
        }
    }
    
    public void ejecutaSQLP(String sql) {
        try {
            // realiza la consulta y devuelve resultados
            rsP = sentenciaSQL.executeQuery(sql);
            System.out.println("SQL ejecuta correctamente");
        } catch (SQLException ex) {
            System.out.println("ERROR: No se ha podido ejecutar la SQL: " + sql);
        }
    }

    public int updateSQL(String sql) {
            // actualiza la BBDD
            int upd = -1;
            try {
                upd = sentenciaSQL.executeUpdate(sql);
            } catch (SQLException e) {
                upd = -1;
            }
            return upd;
    }
    
    public boolean irFinal() {
        boolean ok = false;
        try {
            ok = rsL.last();
        } catch (SQLException ex) {
            System.out.println("\nERROR: No se ha podido ir al último");
        }
        return ok;
    }
    public boolean irSiguiente() {
        boolean ok = false;
        try {
            ok = rsL.next();
        } catch (SQLException ex) {
            System.out.println("\nERROR: No se ha podido ir al siguiente");
        }
        return ok;
    }
    
    public boolean irAnterior() {
        boolean ok = false;
        try {
            ok = rsL.previous();
        } catch (SQLException ex) {
            System.out.println("\nERROR: No se ha podido ir al anterior");
        }
        return ok;
    }
    
    public boolean irPrimero() {
        boolean ok = false;
        try {
            ok = rsL.first();
        } catch (SQLException ex) {
            System.out.println("\nERROR: No se ha podido ir al primero");
            ex.printStackTrace();
        }
        return ok;
    }
    
    public boolean irFinalP() {
        boolean ok = false;
        try {
            ok = rsP.last();
        } catch (SQLException ex) {
            System.out.println("\nERROR: No se ha podido ir al último");
        }
        return ok;
    }
    public boolean irSiguienteP() {
        boolean ok = false;
        try {
            ok = rsP.next();
        } catch (SQLException ex) {
            System.out.println("\nERROR: No se ha podido ir al siguiente");
        }
        return ok;
    }
    
    public boolean irAnteriorP() {
        boolean ok = false;
        try {
            ok = rsP.previous();
        } catch (SQLException ex) {
            System.out.println("\nERROR: No se ha podido ir al anterior");
        }
        return ok;
    }
    
    public boolean irPrimeroP() {
        boolean ok = false;
        try {
            ok = rsP.first();
        } catch (SQLException ex) {
            System.out.println("\nERROR: No se ha podido ir al primero");
            ex.printStackTrace();
        }
        return ok;
    }
    
    public int tamanyoL() throws java.sql.SQLException {
        int tam = 0, origen = 0;
        origen = rsL.getRow();
        rsL.last();
        tam = rsL.getRow();
        rsL.absolute(origen);
        return tam;
    }
    
    public boolean isPrimero() throws SQLException {
        return rsL.isFirst();
    }

    public boolean isUltimo() throws SQLException {
            return rsL.isLast();
    }

    public int posActual() throws SQLException{
            return rsL.getRow();
    }
    
    public int grabaRegistroL(Libro l) throws java.sql.SQLException {
    int ok;
    String sql = "INSERT INTO libros (titulo, autor) VALUES (?, ?)";
    
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, l.getTitulo());
        ps.setString(2, l.getAutor());
        ok = ps.executeUpdate();
    }
    
    return ok;
}

    
    public int grabaRegistroP(Prestamo p) throws java.sql.SQLException {
    int ok;
    String sql = "INSERT INTO prestamos (id_libro, nombre_usuario, fecha_prestamo, duracion_dias, devuelto) VALUES (?, ?, ?, ?, ?)";
    
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, p.getIdLibro());
        ps.setString(2, p.getNombreUsuario());
        ps.setDate(3, java.sql.Date.valueOf(p.getFechaPrestamo())); // Asegúrate que p.getFechaPrestamo() devuelve LocalDate
        ps.setInt(4, p.getDuracionDias());
        ps.setBoolean(5, p.isDevuelto());
        ok = ps.executeUpdate();
    }
    
    return ok;
}

    
    public int modiRegistroL(Libro l) throws SQLException {
    int ok = -1;
    String sql = "UPDATE libros SET titulo = ?, autor = ? WHERE id = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, l.getTitulo());
        ps.setString(2, l.getAutor());
        ps.setInt(3, l.getId());

        ok = ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println("[ ERROR ] al modificar el libro: " + e.getMessage());
        ok = -1;
    }

    return ok;
}

    
    public int modiRegistroP(Prestamo p) throws SQLException {
    int ok = -1;
    String sql = "UPDATE prestamos SET nombre_usuario = ?, fecha_prestamo = ?, duracion_dias = ?, devuelto = ? WHERE id = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, p.getNombreUsuario());
        ps.setDate(2, java.sql.Date.valueOf(p.getFechaPrestamo())); // convierte LocalDate a SQL Date
        ps.setInt(3, p.getDuracionDias());
        ps.setBoolean(4, p.isDevuelto());
        ps.setInt(5, p.getId());

        ok = ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println("[ ERROR ] al modificar el préstamo: " + e.getMessage());
        ok = -1;
    }
    return ok;
}
    
    public Libro devRegistroActualL() {
        Libro l = null;
        try {
            l = new Libro(rsL.getInt("id"), rsL.getString("titulo"), rsL.getString("autor"));
        } catch (SQLException e) {
            System.out.println("\nERROR: No se ha podido obtener el Libro");
        }
        return (l);
    }
    
    public Prestamo devRegistroActualP() {
        Prestamo p = null;
        try {
            LocalDate fechaPrestamo = rsP.getDate("fecha_prestamo").toLocalDate();
            p = new Prestamo(rsP.getInt("id"), rsP.getInt("id_libro"), rsP.getString("nombre_usuario")
                    , fechaPrestamo, rsP.getInt("duracion_dias"), rsP.getBoolean("devuelto"));
        } catch (SQLException e) {
            System.out.println("\nERROR: No se ha podido obtener el Prestamo");
        }
        return (p);
    }
    
        // Elimina todos los préstamos con ese id_libro
    public int eliminarPrestamoPorIdLibro(int idLibro) throws SQLException {
        String sql = "DELETE FROM prestamos WHERE id_libro = " + idLibro;
        return this.updateSQL(sql);
    }

    // Elimina un libro por su ID
    public int eliminarLibroPorId(int idLibro) throws SQLException {
        String sql = "DELETE FROM libros WHERE id = " + idLibro;
        return this.updateSQL(sql);
    }
    
    public void irAntesDelPrimero() {
        try {
            rsL.beforeFirst();
            rsP.beforeFirst();
            System.out.println("Cursor antes de la primera fila.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getResultSetPrestamos() {
        return rsP;
    }

    public void irAntesDelPrimeroP() {
        try {
            if (rsP != null) {
                rsP.beforeFirst();
                System.out.println("Cursor de préstamos antes de la primera fila.");
            } else {
                System.out.println("ResultSet de préstamos no inicializado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al posicionar el cursor antes del primero en préstamos.");
            e.printStackTrace();
        }
    }
    

}