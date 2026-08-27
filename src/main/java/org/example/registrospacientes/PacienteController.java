package org.example.registrospacientes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import org.example.registrospacientes.dao.PacienteDao;
import org.example.registrospacientes.modelo.Paciente;

public class PacienteController {

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtApellidos;

    @FXML
    private RadioButton rbHombre;

    @FXML
    private RadioButton rbMujer;

    @FXML
    private ListView <Paciente> lvPacientes;

    private ToggleGroup grupoGenero;
    private final PacienteDao pacienteDao = new PacienteDao();

    //  actualiza visualmente al ListView automáticamente
    private final ObservableList<Paciente> listaObservable = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        grupoGenero = new ToggleGroup();
        rbHombre.setToggleGroup(grupoGenero);
        rbMujer.setToggleGroup(grupoGenero);

        lvPacientes.setItems(listaObservable);
    }

    @FXML
    protected void agregarOnClick() {
        leerDatos();
        limpiarCampos();
    }

    private void leerDatos() {
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String genero = "";
        if (rbHombre.isSelected()) {
            genero = "Hombre";
        } else if (rbMujer.isSelected()) {
            genero = "Mujer";
        }


        if (!nombres.trim().isEmpty() && !apellidos.trim().isEmpty()) {
            Paciente paciente = new Paciente(nombres, apellidos, genero);
            pacienteDao.agregarPaciente(paciente);
        } else {
            System.out.println("Por favor ingrese tanto el nombre como el apellido.");
        }
    }

    private void limpiarCampos() {
        txtNombres.setText("");
        txtApellidos.setText("");

        if (grupoGenero.getSelectedToggle() != null) {
            grupoGenero.getSelectedToggle().setSelected(false);
        }
    }

}