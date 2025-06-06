package simulacroexamen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectaBBDD {

    private Connection connection;
    private final String URL = "jdbc:mariadb://localhost:3308/libreria";
    private final String USER = "root";
    private final String PASSWORD = "alumnoalumno"; 

    public Connection conectar() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); 
            return null;
        }
        return connection;
    }

    public void desconectar() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet ejecutarConsulta(String sql) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(sql);
    }

    public int ejecutarActualizacion(String sql) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeUpdate(sql);
    }
    
    public Connection getConnection() {
        return connection;
    }
}