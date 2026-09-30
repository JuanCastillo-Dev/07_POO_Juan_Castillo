package vallegrande.edu.pe.mysqlprueba.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MensajeDAO {
    // Método funcional para listar los registros en el TableView
    public List<Mensaje> listarMensajes() {
        List<Mensaje> lista = new ArrayList<>();
        String sql = "SELECT * FROM mensajes";

        try (Connection con = Conexion.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Mensaje(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getString("mensaje")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
