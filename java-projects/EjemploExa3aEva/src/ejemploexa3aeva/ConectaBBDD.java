
package ejemploexa3aeva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConectaBBDD {

    private static final String URL = "jdbc:mariadb://localhost:3308/15_gestion";
    private static final String USUARIO = "root"; // Tu usuario de MySQL
    private static final String CONTRASENA = "alumnoalumno"; // Tu contraseña de MySQL

    public Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            System.err.println("Error al conectar a la BBDD: " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }

    public void desconectar(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println("Error al desconectar de la BBDD: " + e.getMessage());
            }
        }
    }

    public List<Articulo> obtenerTodosLosArticulos() {
        List<Articulo> articulos = new ArrayList<>();
        String sql = "SELECT id, nombre, precio, codigo, grupo FROM articulos ORDER BY id";
        Connection conn = conectar();
        Statement stmt = null;
        ResultSet rs = null;

        if (conn == null) return articulos; // No se pudo conectar

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Articulo articulo = new Articulo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getFloat("precio"),
                        rs.getString("codigo"),
                        rs.getInt("grupo")
                );
                articulos.add(articulo);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener artículos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
            desconectar(conn);
        }
        return articulos;
    }

    public boolean insertarArticulo(Articulo articulo) {
        String sql = "INSERT INTO articulos (nombre, precio, codigo, grupo) VALUES (?, ?, ?, ?)";
        Connection conn = conectar();
        PreparedStatement pstmt = null;
        boolean exito = false;

        if (conn == null) return false;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, articulo.getNombre());
            pstmt.setFloat(2, articulo.getPrecio());
            pstmt.setString(3, articulo.getCodigo());
            pstmt.setInt(4, articulo.getGrupo());

            int filasAfectadas = pstmt.executeUpdate();
            exito = (filasAfectadas > 0);
        } catch (SQLException e) {
            System.err.println("Error al insertar artículo: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
            desconectar(conn);
        }
        return exito;
    }

    public boolean modificarArticulo(Articulo articulo) {
        String sql = "UPDATE articulos SET nombre = ?, precio = ?, codigo = ?, grupo = ? WHERE id = ?";
        Connection conn = conectar();
        PreparedStatement pstmt = null;
        boolean exito = false;

        if (conn == null) return false;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, articulo.getNombre());
            pstmt.setFloat(2, articulo.getPrecio());
            pstmt.setString(3, articulo.getCodigo());
            pstmt.setInt(4, articulo.getGrupo());
            pstmt.setInt(5, articulo.getId());

            int filasAfectadas = pstmt.executeUpdate();
            exito = (filasAfectadas > 0);
        } catch (SQLException e) {
            System.err.println("Error al modificar artículo: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
            desconectar(conn);
        }
        return exito;
    }

    public boolean eliminarArticulo(int idArticulo) {
        String sql = "DELETE FROM articulos WHERE id = ?";
        Connection conn = conectar();
        PreparedStatement pstmt = null;
        boolean exito = false;

        if (conn == null) return false;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idArticulo);

            int filasAfectadas = pstmt.executeUpdate();
            exito = (filasAfectadas > 0);
        } catch (SQLException e) {
            System.err.println("Error al eliminar artículo: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
            desconectar(conn);
        }
        return exito;
    }
}