package vallegrande.edu.pe.model;

public class Contacto {

    //Atributos
    private int id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String correo;

    //Constructor
    public Contacto(int id, String nombres, String apellidos, String direccion, String telefono, String correo){
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    //Metodo
    public void mostrarContacto(){
        System.out.println("ID:" + id);
        System.out.println("Nombre:" + nombres + " " + apellidos);
        System.out.println("Direccion:" + direccion);
        System.out.println("Telefono:" + telefono);
        System.out.println("Correo:" + correo);
        System.out.println("-----------------------------------");
    }

    //Métodos Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
