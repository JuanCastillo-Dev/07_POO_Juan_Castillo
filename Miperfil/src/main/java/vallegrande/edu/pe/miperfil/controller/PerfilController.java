package vallegrande.edu.pe.miperfil.controller;

import vallegrande.edu.pe.miperfil.model.Perfil;
import vallegrande.edu.pe.miperfil.view.PerfilView;

public class PerfilController {
    private PerfilView view;

    public PerfilController(PerfilView view){
        this.view = view;
        view.getBtnMostrar().setOnAction( e -> mostrarPerfil());
        view.getBtnLimpiar().setOnAction( e -> limpiarCampos());
    }

    private void mostrarPerfil(){
        String nombre = view.getTxtNombre().getText();
        String carrera = view.getTxtCarrera().getText();
        String semestre = view.getTxtSemestre().getText();

        // NIVEL 3: Obtenemos el valor seleccionado del ComboBox
        String datoAdicional = view.getCmbDatoAdicional().getValue();

        // NIVEL 2: Validación del campo Nombre vacío
        if (nombre == null || nombre.trim().isEmpty()) {
            view.getLblResultado().setText("¡Error: El campo Nombre no puede estar vacío!");
            view.getLblResultado().setStyle("-fx-text-fill: #FF4D4D; -fx-font-weight: bold;"); // Alerta visual en rojo
            return;
        }

        // Si no seleccionó nada en el ComboBox, le asignamos un texto por defecto
        if (datoAdicional == null) {
            datoAdicional = "No especificado";
        }

        // Restauramos el estilo original del texto desde el CSS
        view.getLblResultado().setStyle("");

        // Creamos el modelo Perfil con la estructura MVC (Nivel 5)
        Perfil perfil = new Perfil(
                nombre,
                carrera,
                semestre,
                datoAdicional
        );

        view.getLblResultado().setText(
                perfil.obtenerPresentacion()
        );
    }

    private void limpiarCampos() {
        view.getTxtNombre().clear();
        view.getTxtCarrera().clear();
        view.getTxtSemestre().clear();

        // NIVEL 3: Reseteamos la selección del ComboBox
        view.getCmbDatoAdicional().setValue(null);

        view.getLblResultado().setText("");
        view.getLblResultado().setStyle("");
    }
}