package org.example.registrospacientes.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.registrospacientes.modelo.Paciente;

import java.time.LocalDate;

public class PacienteController {

    @FXML private TextField txtNombre;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private Label lblMensaje;

    @FXML private TableView<Paciente> tablaPacientes;
    @FXML private TableColumn<Paciente, String> colNombre;
    @FXML private TableColumn<Paciente, LocalDate> colFechaNacimiento;

    private final ObservableList<Paciente> listaPacientes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));

        tablaPacientes.setItems(listaPacientes);

        tablaPacientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txtNombre.setText(newSel.getNombre());
                dpFechaNacimiento.setValue(newSel.getFechaNacimiento());
            }
        });
    }

    @FXML
    private void guardarPaciente() {
        lblMensaje.setText("");
        String nombre = txtNombre.getText().trim();
        LocalDate fechaNacimiento = dpFechaNacimiento.getValue();

        if (nombre.isEmpty() || fechaNacimiento == null) {
            lblMensaje.setText("Completa todos los campos.");
            return;
        }

        Paciente seleccionado = tablaPacientes.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setNombre(nombre);
            seleccionado.setFechaNacimiento(fechaNacimiento);
            tablaPacientes.refresh();
        } else {
            Paciente paciente = new Paciente(nombre, fechaNacimiento);
            listaPacientes.add(paciente);
        }

        limpiarFormulario();
    }

    @FXML
    private void eliminarPaciente() {
        Paciente seleccionado = tablaPacientes.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaPacientes.remove(seleccionado);
            limpiarFormulario();
        } else {
            lblMensaje.setText("Selecciona un paciente para eliminar.");
        }
    }

    @FXML
    private void limpiarFormulario() {
        txtNombre.clear();
        dpFechaNacimiento.setValue(null);
        lblMensaje.setText("");
        tablaPacientes.getSelectionModel().clearSelection();
    }
}