package vallegrande.edu.pe.model;

public class Autor {

    // ATRIBUTOS
    private int id;
    private String nombre;

    //CONSTRUCTOR
    public Autor(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    //GETTERS
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }

    //MOSTRAR AUTOR
    public void mostrarAutor(){
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("------------------------------------");
    }
}
