package vallegrande.edu.pe.app;

import vallegrande.edu.pe.controller.BibliotecaController;
import vallegrande.edu.pe.model.Libro;
import vallegrande.edu.pe.model.Autor; // Agregamos la importación del nuevo modelo
import vallegrande.edu.pe.view.BibliotecaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController();
        BibliotecaView view = new BibliotecaView();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            view.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Titulo:");
                    String titulo = scanner.nextLine();
                    System.out.println("Autor:");
                    String autor = scanner.nextLine();
                    System.out.println("Año:");
                    int anio = scanner.nextInt();
                    scanner.nextLine();

                    //Validar datos
                    if (titulo.isEmpty() || autor.isEmpty() || anio <= 0) {
                        System.out.println("Datps no validos");
                    } else {
                        Libro libro = new Libro(id, titulo, autor, anio);
                        controller.agregarLibro(libro);
                    }
                    break;
                case 2:
                    controller.listarLibros();
                    break;
                case 3:
                    System.out.println("Ingrese Titulo o Autor");
                    String criterio = scanner.nextLine();
                    controller.buscarLibro(criterio);
                    break;
                case 4:
                    // NUEVA OPCIÓN: Registrar autor Nuevo
                    System.out.println("ID:");
                    int idAutor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nombre del Autor:");
                    String nombreAutor = scanner.nextLine();

                    if (nombreAutor.isEmpty()) {
                        System.out.println("X No puede estar vacio.");
                    } else {
                        Autor nuevoAutor = new Autor(idAutor, nombreAutor);
                        controller.registrarAutor(nuevoAutor);
                    }
                    break;
                case 5:
                    // NUEVA OPCIÓN: Listar autores Nuevo
                    controller.listarAutores();
                    break;
                case 6: // Cambiado a 6 para salir correctamente con el nuevo menú
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 6); // Cambiado a 6
        scanner.close();
    }
}
