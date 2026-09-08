module com.biblioconnect.biblioconnect {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.biblioconnect.biblioconnect to javafx.fxml;
    exports com.biblioconnect.biblioconnect;
}