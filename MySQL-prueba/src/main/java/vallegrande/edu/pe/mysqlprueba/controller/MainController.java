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

    // Almacenar la referencia del objeto seleccionado en la tabla
    private Mensaje mensajeSeleccionado;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colMensaje.setCellValueFactory(new PropertyValueFactory<>("mensaje"));

        // MEJORA S11: Escuchador para detectar clics en la tabla y cargar los campos de texto
        tableCitas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                mensajeSeleccionado = newSelection;
                txtNombre.setText(mensajeSeleccionado.getNombre());
                txtCorreo.setText(mensajeSeleccionado.getCorreo());
                txtTelefono.setText(mensajeSeleccionado.getTelefono());
                txtMensaje.setText(mensajeSeleccionado.getMensaje());
            }
        });

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

        if (nombre.isEmpty() || correo.isEmpty() || mensajeTexto.isEmpty()) {
            System.out.println("Por favor complete los campos obligatorios.");
            return;
        }

        Mensaje nuevoMensaje = new Mensaje(0, nombre, correo, telefono, mensajeTexto);
        boolean exito = mensajeDAO.insertar(nuevoMensaje);

        if (exito) {
            System.out.println("Solicitud guardada en MySQL de forma permanente.");
            cargarDatos();
            limpiarCampos();
        } else {
            System.out.println("Error al registrar en la BD.");
        }
    }

    // Acción del botón Actualizar
    @FXML
    public void onActualizarAction() {
        if (mensajeSeleccionado == null) {
            System.out.println("Por favor, seleccione una fila de la tabla primero.");
            return;
        }

        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        String mensajeTexto = txtMensaje.getText();

        if (nombre.isEmpty() || correo.isEmpty() || mensajeTexto.isEmpty()) {
            System.out.println("Por favor complete los campos obligatorios.");
            return;
        }

        // Modificar los atributos del objeto seleccionado
        mensajeSeleccionado.setNombre(nombre);
        mensajeSeleccionado.setCorreo(correo);
        mensajeSeleccionado.setTelefono(telefono);
        mensajeSeleccionado.setMensaje(mensajeTexto);

        boolean exito = mensajeDAO.actualizar(mensajeSeleccionado);

        if (exito) {
            System.out.println("Registro modificado en MySQL con éxito.");
            cargarDatos(); // Sincroniza la tabla de inmediato
            limpiarCampos();
        } else {
            System.out.println("Error al actualizar el registro.");
        }
    }

    // MEJORA S11: Acción del botón Eliminar
    @FXML
    public void onEliminarAction() {
        if (mensajeSeleccionado == null) {
            System.out.println("Por favor, seleccione una fila de la tabla primero.");
            return;
        }

        boolean exito = mensajeDAO.eliminar(mensajeSeleccionado.getId());

        if (exito) {
            System.out.println("Registro borrado de MySQL de forma segura.");
            cargarDatos(); // Sincroniza la tabla de inmediato
            limpiarCampos();
        } else {
            System.out.println("Error al eliminar el registro.");
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        txtMensaje.clear();
        mensajeSeleccionado = null; // Quita la selección activa
        tableCitas.getSelectionModel().clearSelection(); // Deselecciona visualmente en la tabla
    }
}
