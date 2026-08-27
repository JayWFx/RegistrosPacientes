package org.example.registrospacientes.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.registrospacientes.PacientesApplication;

import java.io.IOException;
import java.io.InputStream;

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private ImageView imgCandado;
    @FXML private Label lblMensajeLogin;

    @FXML
    public void initialize() {
        try {
            InputStream imgStream = PacientesApplication.class.getResourceAsStream("candado_abierto.png");
            if (imgStream != null) {
                imgCandado.setImage(new Image(imgStream));
            }
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
        imgCandado.setFitWidth(80);
        imgCandado.setFitHeight(80);
        imgCandado.setPreserveRatio(true);
    }

    @FXML
    protected void loginOnClick(ActionEvent event) {
        String usuario = txtUsuario.getText().trim();
        String password = txtPassword.getText().trim();

        if (usuario.equals("admin") && password.equals("1234")) {
            abrirPantallaPacientes(event);
        } else {
            lblMensajeLogin.setText("Usuario o contraseña incorrectos.");
        }
    }

    private void abrirPantallaPacientes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(PacientesApplication.class.getResource("paciente-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Sistema de Gestión de Pacientes");
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al cargar la vista de pacientes:");
            e.printStackTrace();
        }
    }
}