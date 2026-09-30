package vallegrande.edu.pe.mysqlprueba.model;

public class Mensaje {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private String mensaje;

    // Constructor completo para inicializar los registros
    public Mensaje(int id, String nombre, String correo, String telefono, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.mensaje = mensaje;
    }

    // --- GETTERS ---
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getMensaje() { return mensaje; }

    // --- SETTERS ---
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}
