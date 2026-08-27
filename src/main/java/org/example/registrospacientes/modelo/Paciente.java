package org.example.registrospacientes.modelo;

public class Paciente {
    private String nombres;
    private String apellidos;
    private String genero;

    public Paciente(String nombres, String apellidos, String genero) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
    }

    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getGenero() { return genero; }

    @Override
    public String toString() {
        return nombres + " " + apellidos + " - " + genero;
    }
}