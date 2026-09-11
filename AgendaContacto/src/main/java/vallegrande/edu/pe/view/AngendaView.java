package vallegrande.edu.pe.view;

import vallegrande.edu.pe.model.Contacto;
import java.util.ArrayList;
import java.util.Scanner;

public class AngendaView {

    // Scanner para leer lo que escribe el usuario
    private Scanner teclado = new Scanner(System.in);

    //Mostrar Titulo
    public void mostrarTitulo() {
        System.out.println("---------------------------");
        System.out.println("AGENDA DE CONTACTOS");
        System.out.println("---------------------------");
    }

    //Mostrar Mensaje
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    // Mostrar el menú exacto
    public void mostrarMenu() {
        System.out.println("1. Registrar contacto");
        System.out.println("2. Listar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Salir");
        System.out.print("Elija una opcion: ");
    }

    // Leer la opción del menú
    public int leerOpcion() {
        try {
            return Integer.parseInt(teclado.nextLine());
        } catch (Exception e) {
            return -1; // Si pone letras, devuelve -1 para evitar que se caiga la consola
        }
    }

    // Pedir los datos para un nuevo contacto
    public Contacto pedirDatosNuevoContacto(int nuevoId) {
        System.out.println("--- REGISTRO DE CONTACTO ---");
        System.out.print("Nombres: ");
        String nom = teclado.nextLine();
        System.out.print("Apellidos: ");
        String ape = teclado.nextLine();
        System.out.print("Direccion: ");
        String dir = teclado.nextLine();
        System.out.print("Telefono: ");
        String tel = teclado.nextLine();
        System.out.print("Correo Electronico: ");
        String cor = teclado.nextLine();

        // Creamos y devolvemos el objeto listo
        return new Contacto(nuevoId, nom, ape, dir, tel, cor);
    }

    // Leer el texto para buscar
    public String pedirTextoBusqueda() {
        System.out.print("Ingrese nombre o apellido a buscar: ");
        return teclado.nextLine();
    }

    // Leer el ID para eliminar
    public int pedirIdEliminar() {
        System.out.print("Ingrese el ID del contacto a eliminar: ");
        try {
            return Integer.parseInt(teclado.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
}
