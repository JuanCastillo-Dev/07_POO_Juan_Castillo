package vallegrande.edu.pe.mysqlprueba.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Corrección de ruta usando la barra '/' al inicio para que busque en resources
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vallegrande/edu/pe/mysqlprueba/MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Listado de Mensajes - ASOCIACION DE PRODUCTORES AGRARIOS RENACE CAÑETE");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
