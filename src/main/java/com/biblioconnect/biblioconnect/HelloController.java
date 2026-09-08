package com.biblioconnect.biblioconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnConsultar;

    @FXML
    void onIngresarClick(ActionEvent event) {
        System.out.println("¡Ingresar al sistema presionado!");
    }

    @FXML
    void onConsultarClick(ActionEvent event) {
        System.out.println("¡Consultar catálogo presionado!");
    }
}