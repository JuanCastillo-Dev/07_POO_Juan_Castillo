package vallegrande.edu.pe.mysqlprueba.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vallegrande.edu.pe.mysqlprueba.model.Productor;
import vallegrande.edu.pe.mysqlprueba.model.ProductorDAO;

public class MainController {

    // Componentes del Formulario de Captura (Opción 1: Productores)
    @FXML private TextField txtNombre;
    @FXML private TextField txtDni;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtComunidad;
    @FXML private Button btnRegistrar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;

    // Componentes de la Tabla de Productores
    @FXML private TableView<Productor> tableCitas; // Mantenemos el fx:id para no romper el FXML
    @FXML private TableColumn<Productor, Integer> colId;
    @FXML private TableColumn<Productor, String> colNombre;
    @FXML private TableColumn<Productor, String> colDni;
    @FXML private TableColumn<Productor, String> colTelefono;
    @FXML private TableColumn<Productor, String> colComunidad;

    private final ProductorDAO productorDAO = new ProductorDAO();
    private Productor productorSeleccionado;

    @FXML
    public void initialize() {
        // Vincular las columnas de la tabla con los atributos de Productor
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colComunidad.setCellValueFactory(new PropertyValueFactory<>("comunidad"));

        // Escuchador para detectar selección en la tabla y cargar el formulario de edición
        tableCitas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                productorSeleccionado = newSelection;
                txtNombre.setText(productorSeleccionado.getNombre());
                txtDni.setText(productorSeleccionado.getDni());
                txtTelefono.setText(productorSeleccionado.getTelefono());
                txtComunidad.setText(productorSeleccionado.getComunidad());
            }
        });

        cargarDatos();
    }

    // 2. LISTAR: Cargar datos desde MySQL hacia la TableView
    public void cargarDatos() {
        ObservableList<Productor> datos = FXCollections.observableArrayList(productorDAO.listarProductores());
        tableCitas.setItems(datos);
    }

    // 1. REGISTRAR: Insertar un nuevo productor en la base de datos
    @FXML
    public void onRegistrarAction() {
        String nombre = txtNombre.getText();
        String dni = txtDni.getText();
        String telefono = txtTelefono.getText();
        String comunidad = txtComunidad.getText();

        if (nombre.isEmpty() || dni.isEmpty() || comunidad.isEmpty()) {
            System.out.println("Por favor complete los campos obligatorios.");
            return;
        }

        Productor nuevoProductor = new Productor(0, nombre, dni, telefono, comunidad);
        boolean exito = productorDAO.insertar(nuevoProductor);

        if (exito) {
            System.out.println("Productor registrado en MySQL correctamente.");
            cargarDatos();
            limpiarCampos();
        } else {
            System.out.println("Error al registrar el productor.");
        }
    }

    // 3. EDITAR: Modificar los datos del productor seleccionado
    @FXML
    public void onActualizarAction() {
        if (productorSeleccionado == null) {
            System.out.println("Por favor, seleccione un productor de la tabla primero.");
            return;
        }

        String nombre = txtNombre.getText();
        String dni = txtDni.getText();
        String telefono = txtTelefono.getText();
        String comunidad = txtComunidad.getText();

        if (nombre.isEmpty() || dni.isEmpty() || comunidad.isEmpty()) {
            System.out.println("Por favor complete los campos obligatorios.");
            return;
        }

        productorSeleccionado.setNombre(nombre);
        productorSeleccionado.setDni(dni);
        productorSeleccionado.setTelefono(telefono);
        productorSeleccionado.setComunidad(comunidad);

        boolean exito = productorDAO.actualizar(productorSeleccionado);

        if (exito) {
            System.out.println("Productor actualizado en MySQL con éxito.");
            cargarDatos();
            limpiarCampos();
        } else {
            System.out.println("Error al actualizar el productor.");
        }
    }

    // 4. ELIMINAR: Remover de forma permanente el productor seleccionado
    @FXML
    public void onEliminarAction() {
        if (productorSeleccionado == null) {
            System.out.println("Por favor, seleccione un productor de la tabla primero.");
            return;
        }

        boolean exito = productorDAO.eliminar(productorSeleccionado.getId());

        if (exito) {
            System.out.println("Productor eliminado de MySQL con éxito.");
            cargarDatos();
            limpiarCampos();
        } else {
            System.out.println("Error al eliminar el productor.");
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtDni.clear();
        txtTelefono.clear();
        txtComunidad.clear();
        productorSeleccionado = null;
        tableCitas.getSelectionModel().clearSelection();
    }
}
