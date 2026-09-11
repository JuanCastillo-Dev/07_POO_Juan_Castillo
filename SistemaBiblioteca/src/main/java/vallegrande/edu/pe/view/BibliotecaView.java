package vallegrande.edu.pe.view;

public class BibliotecaView {
    //TITULO
    public void mostrarTitulo(){
        System.out.println("=================");
        System.out.println("SISTEMA DE BIBLIOTECA VG");
        System.out.println("=================");
    }
    //MENU (Actualizado idéntico a la captura de la consola esperada)
    public void mostrarMenu(){
        System.out.println("===== BIBLIOTECA =====");
        System.out.println("1. Registrar libro");
        System.out.println("2. Listar libros");
        System.out.println("3. Buscar libro");
        System.out.println("4. Registrar autor Nuevo");
        System.out.println("5. Listar autores Nuevo");
        System.out.println("6. Salir");
        System.out.println("Seleccione una opcion: ");
    }
    //MENSAJE
    public void mostrarMensaje( String mensaje){
        System.out.println(mensaje);
    }
}
