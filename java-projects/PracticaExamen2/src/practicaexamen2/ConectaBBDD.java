
package practicaexamen2;


import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;


public class ConectaBBDD {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    
    private String dameCodigoTipo(String clase) {
        String tipo = "", sql;
        ResultSet r;
        
        sql = "SELECT codigo FROM tipos WHERE descripcion ='" + clase + "'";
        System.out.println(sql);
        try {
            ejecutaSQL(sql);
            irPrimero();
            tipo = rs.getString("codigo");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tipo;
    }
    
    public void ejecutaSQL(String sql) throws SQLException {
        if (stmt == null) {
            throw new SQLException("La sentencia no ha sido creada.");
        }
        rs = stmt.executeQuery(sql);
        System.out.println("SQL ejecutada correctamente: " + sql);
    }
    
    public void conecta() throws SQLException {
        try {
            //Registrando el Driver
            String driver = "org.mariadb.jdbc.Driver";
            Class.forName(driver).newInstance();
            System.out.println("Driver " + driver + " Registrado correctamente");
            //Abrir la conexión con la Base de Datos
            System.out.println("Conectando con la Base de datos...");
            String jdbcUrl = "jdbc:mariadb://localhost:3308/15_gestion"; // o IP
            con = DriverManager.getConnection(jdbcUrl, "root", "alumnoalumno");
            System.out.println("Conexión establecida con la Base de datos...");
        } catch (SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Errores de Class.forName
            e.printStackTrace();
        }
    }
    
    public Ordenador obtenerOrdenador() {
        Ordenador ord = null;
        String tipo, marca, modelo, micro, memoria, tamaño;
        float peso, pulgadas;
        int numusb, numSer;
        boolean lector, tarSonido;
        try {
            // recogemos valores del resultset
            numSer = rs.getInt("numSerie");
            tipo = rs.getString("tipo");
            marca = rs.getString("marca");
            modelo = rs.getString("modelo");
            micro = rs.getString("micro");
            memoria = rs.getString("memoria");
            lector = rs.getBoolean("lector");
            numusb = rs.getInt("numusb");
            tarSonido = rs.getBoolean("tarjetasonido");
            tamaño = rs.getString("tamaño");
            peso = rs.getFloat("peso");
            pulgadas = rs.getFloat("pulgadas");
            if (tipo.contentEquals("01")) {
                ord = new Sobremesa(numSer, marca, modelo, micro, memoria, lector, numusb, tarSonido, tamaño);
            } else if (tipo.contentEquals("02")) {
                ord = new Portatil(numSer, marca, modelo, micro, memoria, lector, peso, pulgadas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ord;
    }
    
    
    public int grabaOrdenador(Ordenador ord) throws java.sql.SQLException {
        int ok = -1;
        String tipo = "", sql;
        Sobremesa ordena = null;
        Portatil ordPort = null;
        if (ord instanceof Sobremesa) {
            tipo = dameCodigoTipo("Sobremesa");
        } else if (ord instanceof Portatil) {
            tipo = dameCodigoTipo("Portátil");
        }
        sql = "INSERT INTO ordenadores VALUES (";
        sql = sql + ord.getNum_serie();
        sql = sql + ",'" + tipo;
        sql = sql + "','" + ord.getMarca() + "'";
        sql = sql + ",'" + ord.getModelo() + "'";
        sql = sql + ",'" + ord.getMicroprocesador() + "'";
        sql = sql + ",'" + ord.getMemoria() + "'";
        sql = sql + "," + ord.isLectorDVD();

        if (ord instanceof Sobremesa) {
            ordena = (Sobremesa) ord;
            sql = sql + "," + ordena.getNumUSB();
            sql = sql + "," + ordena.isTarjetaSonido();
            sql = sql + ",'" + ordena.getTamaño() + "',null,null)";
        } else {
            ordPort = (Portatil) ord;
            sql = sql + ",null,null,null," + ordPort.getPeso();
            sql = sql + "," + ordPort.getPulgadas() + ")";
        }
        ok = this.updateSQL(sql);
        return (ok);
    }
    
    public int posRs() throws SQLException{
        int pos=0;
        pos = rs.getRow();
        return pos;
    }
    public boolean isPrimero() throws SQLException {
        if (rs == null) return true; // Si no hay resultset, no se puede mover, como si estuviera en el primero y único (vacío)
        return rs.isFirst();
    }
    
    public boolean isUltimo() throws SQLException {
        if (rs == null) return true; // Similar a isPrimero
        return rs.isLast();
    }
    
    public int tamanyo() throws java.sql.SQLException {
        int tam = 0, origen = 0;
        origen = rs.getRow();
        rs.last();
        tam = rs.getRow();
        rs.absolute(origen);
        return tam;
    }
    
    public boolean irSiguiente() throws SQLException { if (rs == null) return false; return rs.next(); }
    public boolean irAnterior() throws SQLException { if (rs == null) return false; return rs.previous(); }
    public boolean irPrimero() throws SQLException { if (rs == null) return false; return rs.first(); }
    public boolean irFinal() throws SQLException { if (rs == null) return false; return rs.last(); }
    
    public int updateSQL(String sql) throws SQLException {
        if (stmt == null) {
            throw new SQLException("La sentencia no ha sido creada.");
        }
        int affectedRows = stmt.executeUpdate(sql);
        System.out.println("SQL update ejecutada correctamente, filas afectadas: " + affectedRows + " SQL: " + sql);
        return affectedRows;
    }
    
    public void crearSentencia() throws SQLException {
        if (con == null) {
            throw new SQLException("No hay conexión activa para crear una sentencia.");
        }
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        System.out.println("Sentencia creada con éxito.");
    }
    
    public String devRegActTipo() throws SQLException {
        if (rs == null) {
            throw new SQLException("ResultSet es null, no se puede obtener el tipo.");
        }
        // Asegúrate que los nombres de las columnas ("codigo", "descripcion")
        // coincidan exactamente con tu tabla 'tipos'.
        String codigo = rs.getString("codigo");
        String descripcion = rs.getString("descripcion");
        return codigo + " - " + descripcion; // Formato para el ComboBox
    }
    
    public void cerrarConexion() throws SQLException {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
            System.out.println("Conexión cerrada con éxito.");
        } catch (SQLException e) {
            System.err.println("ERROR: No se ha PODIDO CERRAR la conexión: " + e.getMessage());
            throw e;
        }
    }
}