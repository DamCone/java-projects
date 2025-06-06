package telefonos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Telefonos {
private Connection conexion;
private Statement sentenciaSQL;
private ResultSet cdr; // conjunto de resultados
public Telefonos() {
conectar();
// crear una sentencia para enviar consultas
crearSentencia();
}
private void conectar() {
try {
//Registrando el Driver
 String driver = "com.mysql.cj.jdbc.Driver";
 Class.forName(driver).newInstance();
 System.out.println("Driver " + driver + " Registrado correctamente");
//Abrir la conexión con la Base de Datos
 System.out.println("Conectando con la Base de datos...");
 String jdbcUrl = "jdbc:mysql://localhost:33306/bd_telefonos";
 conexion = DriverManager.getConnection(jdbcUrl, "root", "alumnoalumno");
 System.out.println("Conexión establecida con la Base de datos...");
} catch (SQLException se) {
//Errores de JDBC
 se.printStackTrace();
} catch (Exception e) {
//Errores de Class.forName
e.printStackTrace();
}
}
private void crearSentencia() {
try {
// Crear una sentencia para enviar consultas a la base de datos
 sentenciaSQL = conexion.createStatement();
 System.out.println("\nSentencia creada con éxito.");
} catch (SQLException ex) {
 System.out.println("\nERROR: NO se ha creado el objeto Statement.");
}
}
public void cerrarConexion() {
// se cerrará la conexión a la BBDD.
try {
if (cdr != null) {
 cdr.close();
}
if (sentenciaSQL != null) {
 sentenciaSQL.close();
}
if (conexion != null) {
 conexion.close();
}
 System.out.println("\nConexión cerrada con éxito.");
} catch (SQLException ex) {
 System.out.println("\nERROR: NO se ha PODIDO CERRAR la conexión.");
}
}
public ResultSet buscarFilasEnTelefonos(String subcad, int tipoBúsqueda) {
// realiza la consulta y devuelve resultados
 String[] cadena = {"'" + subcad + "%'", "'%" + subcad + "%'"};
try {
 cdr = sentenciaSQL.executeQuery(
"SELECT * FROM " + "telefonos"
+ " WHERE nombre LIKE " + cadena[tipoBúsqueda - 1]);
} catch (SQLException ex) {
 System.out.println("\nERROR: NO se ha ejecuta la consulta correctamente");
}
return cdr;
}
public void mostrarTabla() {
int nColumnas;
try {
 nColumnas = cdr.getMetaData().getColumnCount();
while (cdr.next()) {
for (int i = 1; i <= nColumnas; ++i) {
 System.out.print(cdr.getString(i) + " ");
}
 System.out.println();
}
} catch (SQLException ex) {
 System.out.println("\nERROR: No se han podido mostrar registros");
}
}
public static void main(String[] args) {
// TODO code application logic here
 Telefonos bd = null;
 Scanner leer = new java.util.Scanner(System.in);
int n = 2;
 bd = new Telefonos();
 System.out.println("Cadena de caracteres a buscar: ");
 String str = leer.next();
 System.out.println("(1) Que empiece por, (2) Otro: ");
 n = leer.nextInt();
 leer.close();
 bd.buscarFilasEnTelefonos(str, n);
 bd.mostrarTabla();
 bd.cerrarConexion();
}
}