package vallegrande.edu.pe.mysqlprueba.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductorDAO {

    // 1. LISTAR
    public List<Productor> listarProductores() {
        List<Productor> lista = new ArrayList<>();
        String sql = "SELECT * FROM productores";

        try (Connection con = Conexion.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Productor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("telefono"),
                        rs.getString("comunidad")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // 2. REGISTRAR (INSERT)
    public boolean insertar(Productor productor) {
        String sql = "INSERT INTO productores (nombre, dni, telefono, comunidad) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, productor.getNombre());
            ps.setString(2, productor.getDni());
            ps.setString(3, productor.getTelefono());
            ps.setString(4, productor.getComunidad());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 3. EDITAR (UPDATE)
    public boolean actualizar(Productor productor) {
        String sql = "UPDATE productores SET nombre = ?, dni = ?, telefono = ?, comunidad = ? WHERE id = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, productor.getNombre());
            ps.setString(2, productor.getDni());
            ps.setString(3, productor.getTelefono());
            ps.setString(4, productor.getComunidad());
            ps.setInt(5, productor.getId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 4. ELIMINAR (DELETE)
    public boolean eliminar(int id) {
        String sql = "DELETE FROM productores WHERE id = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
