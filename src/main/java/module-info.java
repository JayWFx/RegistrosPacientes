module org.example.registrospacientes {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.registrospacientes to javafx.fxml;
    opens org.example.registrospacientes.controlador to javafx.fxml;
    opens org.example.registrospacientes.modelo to javafx.base;

    exports org.example.registrospacientes;
    exports org.example.registrospacientes.controlador;
}