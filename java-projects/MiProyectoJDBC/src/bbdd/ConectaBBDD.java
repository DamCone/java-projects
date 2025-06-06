package bbdd;

import java.sql.*;
import modelo.Articulo;

public class ConectaBBDD {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public void conecta() throws SQLException {
        try {
            // Es buena práctica registrar el driver una sola vez o dejar que JDBC 4+ lo haga.
            // Class.forName("com.mysql.cj.jdbc.Driver"); // Opcional para JDBC 4.0+
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:33306/15_gestion", "root", "alumnoalumno");
            System.out.println("Conexión establecida con la Base de datos...");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la BBDD: " + e.getMessage());
            e.printStackTrace();
            throw e; // Relanzar para que el controlador sepa del error
        }
        // Removí el Class.forName de aquí porque puede lanzar ClassNotFoundException
        // y es mejor manejarlo donde se llama o asegurar que el driver está en el classpath.
        // Para proyectos con Ant, asegúrate que el JAR de MySQL Connector/J está en la librería del proyecto.
    }

    public void crearSentencia() throws SQLException {
        if (conn == null) {
            throw new SQLException("No hay conexión activa para crear una sentencia.");
        }
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        System.out.println("Sentencia creada con éxito.");
    }

    public void cerrarConexion() throws SQLException {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
            System.out.println("Conexión cerrada con éxito.");
        } catch (SQLException e) {
            System.err.println("ERROR: No se ha PODIDO CERRAR la conexión: " + e.getMessage());
            throw e;
        }
    }

    public void ejecutaSQL(String sql) throws SQLException {
        if (stmt == null) {
            throw new SQLException("La sentencia no ha sido creada.");
        }
        rs = stmt.executeQuery(sql);
        System.out.println("SQL ejecutada correctamente: " + sql);
    }

    public int updateSQL(String sql) throws SQLException {
        if (stmt == null) {
            throw new SQLException("La sentencia no ha sido creada.");
        }
        int affectedRows = stmt.executeUpdate(sql);
        System.out.println("SQL update ejecutada correctamente, filas afectadas: " + affectedRows + " SQL: " + sql);
        return affectedRows;
    }

    public Articulo devRegistroActual() throws SQLException {
        if (rs == null || rs.isBeforeFirst() || rs.isAfterLast()) {
             // Podrías lanzar una excepción o retornar null si no hay un registro actual válido
            System.err.println("ResultSet no está posicionado en un registro válido.");
            return null; // o throw new SQLException("No hay registro actual");
        }
        return new Articulo(
            String.valueOf(rs.getInt("id")), // Asumiendo que 'id' es INT en la BD
            rs.getString("nombre"),
            rs.getFloat("precio"),
            rs.getString("codigo"),
            rs.getInt("grupo")
        );
    }

    public boolean irSiguiente() throws SQLException { if (rs == null) return false; return rs.next(); }
    public boolean irAnterior() throws SQLException { if (rs == null) return false; return rs.previous(); }
    public boolean irPrimero() throws SQLException { if (rs == null) return false; return rs.first(); }
    public boolean irFinal() throws SQLException { if (rs == null) return false; return rs.last(); }
    
    public boolean isPrimero() throws SQLException {
        if (rs == null) return true; // Si no hay resultset, no se puede mover, como si estuviera en el primero y único (vacío)
        return rs.isFirst();
    }

    public boolean isUltimo() throws SQLException {
        if (rs == null) return true; // Similar a isPrimero
        return rs.isLast();
    }

    public int grabaRegistro(Articulo art) throws SQLException {
        String sql = "INSERT INTO articulos(nombre, precio, codigo, grupo) VALUES (" +
                     "'" + art.getNombre().replace("'", "''") + "'," + // Escapar comillas simples
                     art.getPrecio() + "," +
                     "'" + art.getCodigo().replace("'", "''") + "'," +
                     art.getGrupo() + ")";
        return updateSQL(sql);
    }

    public int modiRegistro(Articulo art) throws SQLException {
        if (art.getId() == null || art.getId().trim().isEmpty()) {
            throw new SQLException("El ID del artículo no puede ser nulo o vacío para modificar.");
        }
        String sql = "UPDATE articulos SET " +
                     "nombre = '" + art.getNombre().replace("'", "''") + "', " +
                     "precio = " + art.getPrecio() + ", " +
                     "codigo = '" + art.getCodigo().replace("'", "''") + "', " +
                     "grupo = " + art.getGrupo() + " " +
                     "WHERE id = " + art.getId();
        return updateSQL(sql);
    }
}