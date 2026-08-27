package org.example.registrospacientes.dao;

import org.example.registrospacientes.modelo.Paciente;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {

    private final List<Paciente> pacientes;

    public PacienteDao() {
        this.pacientes = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
        System.out.println("-> Paciente guardado con éxito: " + paciente.getNombres() + " " + paciente.getApellidos());
    }

    public List<Paciente> listarPacientes() {
        return pacientes;
    }
}