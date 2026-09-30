package vallegrande.edu.pe.mysqlprueba.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vallegrande.edu.pe.mysqlprueba.model.Mensaje;
import vallegrande.edu.pe.mysqlprueba.model.MensajeDAO;

public class MainController {
    @FXML private TableView<Mensaje> tableCitas; // Mantiene el ID que mapea con tu vista
    @FXML private TableColumn<Mensaje, Integer> colId;
    @FXML private TableColumn<Mensaje, String> colNombre;
    @FXML private TableColumn<Mensaje, String> colCorreo;
    @FXML private TableColumn<Mensaje, String> colTelefono;
    @FXML private TableColumn<Mensaje, String> colMensaje;

    private final MensajeDAO mensajeDAO = new MensajeDAO();

    @FXML
    public void initialize() {
        // Enlaza cada columna del TableView con los atributos de tu clase Mensaje
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colMensaje.setCellValueFactory(new PropertyValueFactory<>("mensaje"));

        cargarDatos();
    }

    public void cargarDatos() {
        // Trae la lista desde la BD en Docker y la inyecta en la tabla
        ObservableList<Mensaje> datos = FXCollections.observableArrayList(mensajeDAO.listarMensajes());
        tableCitas.setItems(datos);
    }
}
