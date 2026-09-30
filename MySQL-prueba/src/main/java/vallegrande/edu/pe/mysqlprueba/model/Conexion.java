package vallegrande.edu.pe.mysqlprueba.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Configuración apuntando al puerto 3307 de tu contenedor Docker
    private static final String URL = "jdbc:mysql://127.0.0.1:3307/sistema_usuarios";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConexion() throws SQLException {
        try {
            // Carga explícita del driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
