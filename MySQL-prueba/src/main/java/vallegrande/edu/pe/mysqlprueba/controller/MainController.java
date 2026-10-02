package vallegrande.edu.pe.mysqlprueba.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vallegrande.edu.pe.mysqlprueba.model.Mensaje;
import vallegrande.edu.pe.mysqlprueba.model.MensajeDAO;

public class MainController {
    // Componentes del Formulario de Captura para APARC
    @FXML private TextField txtNombre;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtMensaje;
    @FXML private Button btnRegistrar;

    // Componentes de la Tabla
    @FXML private TableView<Mensaje> tableCitas;
    @FXML private TableColumn<Mensaje, Integer> colId;
    @FXML private TableColumn<Mensaje, String> colNombre;
    @FXML private TableColumn<Mensaje, String> colCorreo;
    @FXML private TableColumn<Mensaje, String> colTelefono;
    @FXML private TableColumn<Mensaje, String> colMensaje;

    private final MensajeDAO mensajeDAO = new MensajeDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colMensaje.setCellValueFactory(new PropertyValueFactory<>("mensaje"));

        cargarDatos();
    }

    public void cargarDatos() {
        ObservableList<Mensaje> datos = FXCollections.observableArrayList(mensajeDAO.listarMensajes());
        tableCitas.setItems(datos);
    }

    // Acción del botón Registrar exigido en la S10
    @FXML
    public void onRegistrarAction() {
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        String mensajeTexto = txtMensaje.getText();

        // Validación para que no manden campos vacíos
        if (nombre.isEmpty() || correo.isEmpty() || mensajeTexto.isEmpty()) {
            System.out.println("Por favor complete los campos obligatorios.");
            return;
        }

        // Instanciar entidad (S10)
        Mensaje nuevoMensaje = new Mensaje(0, nombre, correo, telefono, mensajeTexto);

        // Ejecutar inserción en el DAO
        boolean exito = mensajeDAO.insertar(nuevoMensaje);

        if (exito) {
            System.out.println("Solicitud guardada en MySQL de forma permanente.");
            cargarDatos(); // Sincroniza y refresca el TableView automáticamente
            limpiarCampos();
        } else {
            System.out.println("Error al registrar en la BD.");
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        txtMensaje.clear();
    }
}
