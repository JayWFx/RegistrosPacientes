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
    private ListView<Paciente> lvPacientes;

    private ToggleGroup grupoGenero;
    private final PacienteDao pacienteDao = new PacienteDao();
    private final ObservableList<Paciente> listaObservable = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Unifica los RadioButtons para seleccionar solo uno a la vez
        grupoGenero = new ToggleGroup();
        rbHombre.setToggleGroup(grupoGenero);
        rbMujer.setToggleGroup(grupoGenero);

        // Enlaza la lista visual con el componente de la pantalla
        lvPacientes.setItems(listaObservable);
    }

    @FXML
    protected void agregarOnClick() {
        String nombres = txtNombres.getText().trim();
        String apellidos = txtApellidos.getText().trim();

        String genero = "";
        if (rbHombre.isSelected()) {
            genero = "Hombre";
        } else if (rbMujer.isSelected()) {
            genero = "Mujer";
        }

        // Si los 3 datos existen, guarda y actualiza la pantalla
        if (!nombres.isEmpty() && !apellidos.isEmpty() && !genero.isEmpty()) {
            Paciente paciente = new Paciente(nombres, apellidos, genero);

            pacienteDao.agregarPaciente(paciente);
            listaObservable.add(paciente); // Inserta el dato directamente en la vista

            limpiarCampos();
        } else {
            System.out.println("Debe ingresar Nombre, Apellido y seleccionar un género.");
        }
    }

    private void limpiarCampos() {
        txtNombres.clear();
        txtApellidos.clear();
        if (grupoGenero.getSelectedToggle() != null) {
            grupoGenero.getSelectedToggle().setSelected(false);
        }
    }
}