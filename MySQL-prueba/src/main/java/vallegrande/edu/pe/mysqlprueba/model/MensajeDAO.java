package vallegrande.edu.pe.mysqlprueba.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MensajeDAO {

    // Método corregido para listar los registros en el TableView
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

    // Método exigido para la persistencia del nuevo registro (S10)
    public boolean insertar(Mensaje mensaje) {
        String sql = "INSERT INTO mensajes (nombre, correo, telefono, mensaje) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mensaje.getNombre());
            ps.setString(2, mensaje.getCorreo());
            ps.setString(3, mensaje.getTelefono());
            ps.setString(4, mensaje.getMensaje());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
