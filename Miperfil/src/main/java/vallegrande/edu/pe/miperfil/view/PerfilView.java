package vallegrande.edu.pe.miperfil.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PerfilView {
    private VBox contenedor;
    private Label titulo;
    private TextField txtNombre;
    private TextField txtCarrera;
    private TextField txtSemestre;
    private ComboBox<String> cmbDatoAdicional; // NIVEL 3: ComboBox en lugar de TextField
    private Button btnMostrar;
    private Button btnLimpiar;
    private Label lblResultado;

    public PerfilView(){
        titulo = new Label("MI PERFIL");
        titulo.getStyleClass().add("titulo-perfil"); // Asigna clase CSS

        txtNombre = new TextField();
        txtNombre.setPromptText("Ingrese su nombre");

        txtCarrera = new TextField();
        txtCarrera.setPromptText("Ingrese su carrera");

        txtSemestre = new TextField();
        txtSemestre.setPromptText("Ingrese su semestre");

        // NIVEL 3: Inicializamos el ComboBox y añadimos las opciones del reto
        cmbDatoAdicional = new ComboBox<>();
        cmbDatoAdicional.setPromptText("Seleccione un dato adicional");
        cmbDatoAdicional.setMaxWidth(Double.MAX_VALUE); // Para que ocupe todo el ancho
        cmbDatoAdicional.getItems().addAll(
                "Música Cristiana",
                "Videojuego favorito",
                "Hobby o pasatiempo",
                "Curso favorito",
                "Ciudad de origen",
                "Meta profesional",
                "Género musical"
        );

        btnMostrar = new Button("Mostrar Perfil");
        btnMostrar.getStyleClass().add("btn-mostrar"); // Asigna clase CSS

        btnLimpiar = new Button("Limpiar");
        btnLimpiar.getStyleClass().add("btn-limpiar"); // Asigna clase CSS

        HBox contenedorBotones = new HBox(15);
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.getChildren().addAll(btnMostrar, btnLimpiar);

        lblResultado = new Label();
        lblResultado.getStyleClass().add("label-resultado"); // Asigna clase CSS
        lblResultado.setAlignment(Pos.CENTER);
        lblResultado.setLineSpacing(5);

        contenedor = new VBox(18);
        contenedor.setAlignment(Pos.CENTER);

        // NIVEL 4: Cargamos la hoja de estilos CSS externa
        contenedor.getStylesheets().add(getClass().getResource("/estilos.css").toExternalForm());

        contenedor.getChildren().addAll(
                titulo,
                txtNombre,
                txtCarrera,
                txtSemestre,
                cmbDatoAdicional, // Añadido el ComboBox aquí
                contenedorBotones,
                lblResultado
        );
    }

    public VBox getContenedor(){ return contenedor; }
    public TextField getTxtNombre(){ return txtNombre; }
    public TextField getTxtCarrera(){ return txtCarrera; }
    public TextField getTxtSemestre(){ return txtSemestre; }
    public ComboBox<String> getCmbDatoAdicional(){ return cmbDatoAdicional; } // Getter del ComboBox
    public Button getBtnMostrar(){ return btnMostrar; }
    public Button getBtnLimpiar(){ return btnLimpiar; }
    public Label getLblResultado(){ return lblResultado; }
}