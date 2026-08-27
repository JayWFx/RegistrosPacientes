module org.example.registrospacientes {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens org.example.registrospacientes to javafx.fxml;
    exports org.example.registrospacientes;
}