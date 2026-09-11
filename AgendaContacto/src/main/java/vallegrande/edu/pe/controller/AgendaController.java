package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Contacto;
import java.util.ArrayList;

public class AgendaController {

    //Lista Contactos (Almacenar)
    private ArrayList<Contacto> contactos;

    //Constructor
    public AgendaController(){
        contactos = new ArrayList<>();
    }

    //Agregar Contacto
    public void agregarContacto(Contacto contacto){
        contactos.add(contacto);
    }

    //Listar Contactos
    public void listarContactos(){
        System.out.println("LISTA DE CONTACTOS");
        for (Contacto contacto : contactos){
            contacto.mostrarContacto();
        }
    }

    // Retornar la lista completa
    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    // Buscar por nombre o apellido
    public ArrayList<Contacto> buscarPorNombreOApellido(String texto) {
        ArrayList<Contacto> encontrados = new ArrayList<>();
        // Pasamos a minúsculas para que encuentre coincidencia parcial o exacta
        String buscar = texto.toLowerCase();

        for (Contacto c : contactos) {
            if (c.getNombres().toLowerCase().contains(buscar) || c.getApellidos().toLowerCase().contains(buscar)) {
                encontrados.add(c);
            }
        }
        return encontrados;
    }

    // Eliminar por ID
    public boolean eliminarPorId(int idBuscado) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getId() == idBuscado) {
                contactos.remove(i);
                return true; // Si lo encuentra y elimina
            }
        }
        return false; // Si no existía el ID
    }
}
