package vallegrande.edu.pe.app;

import vallegrande.edu.pe.controller.AgendaController;
import vallegrande.edu.pe.model.Contacto;
import vallegrande.edu.pe.view.AngendaView;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Crear los componentes
        AgendaController controller = new AgendaController();
        AngendaView view = new AngendaView();

        //Crear contactos
        Contacto contacto1 = new Contacto(1, "Ana", "Torres", "Cañete", "983745656", "ana@gmail.com");
        Contacto contacto2 = new Contacto(2, "Carlos", "Perez", "Imperial", "951264456", "carlos@gmail.com");
        Contacto contacto3 = new Contacto(3, "Maria", "Lopez", "San Vicente", "941235678", "maria@gmail.com");
        Contacto contacto4 = new Contacto(4, "Juan", "Castro", "Mala", "932145678", "juan@gmail.com");
        Contacto contacto5 = new Contacto(5, "Luis", "Torres", "Chilca", "921548763", "luis@gmail.com");

        //Agregar contactos al controlador
        controller.agregarContacto(contacto1);
        controller.agregarContacto(contacto2);
        controller.agregarContacto(contacto3);
        controller.agregarContacto(contacto4);
        controller.agregarContacto(contacto5);

        // Bucle interactivo para el menu
        int opcion = 0;
        int proximoId = 6;

        do {
            view.mostrarTitulo();
            view.mostrarMenu();
            opcion = view.leerOpcion();

            switch(opcion) {
                case 1:
                    // Registrar
                    Contacto nuevo = view.pedirDatosNuevoContacto(proximoId);
                    controller.agregarContacto(nuevo);
                    proximoId++;
                    view.mostrarMensaje("Contacto Agregado correctamente\n");
                    break;
                case 2:
                    controller.listarContactos();
                    break;
                case 3:
                    String textoBuscar = view.pedirTextoBusqueda();
                    ArrayList<Contacto> encontrados = controller.buscarPorNombreOApellido(textoBuscar);

                    System.out.println("RESULTADOS DE BUSQUEDA:");
                    if(encontrados.isEmpty()) {
                        view.mostrarMensaje("No hay contactos para mostrar.\n");
                    } else {
                        for(Contacto c : encontrados) {
                            c.mostrarContacto();
                        }
                    }
                    break;
                case 4:
                    int idEliminar = view.pedirIdEliminar();
                    boolean eliminado = controller.eliminarPorId(idEliminar);

                    if(eliminado) {
                        view.mostrarMensaje("Contacto eliminado correctamente.\n");
                    } else {
                        view.mostrarMensaje("Error: No se encontro ningun contacto con ese ID.\n");
                    }
                    break;
                case 5:
                    view.mostrarMensaje("Saliendo de la agenda... ¡Adios!");
                    break;
                default:
                    view.mostrarMensaje("Opcion no valida. Intente de nuevo.\n");
                    break;
            }
        } while(opcion != 5);
    }
}
