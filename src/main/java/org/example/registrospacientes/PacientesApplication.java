package org.example.registrospacientes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PacientesApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Carga la interfaz paciente-viex.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(PacientesApplication.class.getResource("paciente-viex.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Registro de Pacientes");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}