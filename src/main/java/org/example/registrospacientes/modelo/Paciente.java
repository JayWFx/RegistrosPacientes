package org.example.registrospacientes.modelo;

import java.time.LocalDate;

public class Paciente {
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Paciente() {}

    public Paciente(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Paciente(String nombre, LocalDate fechaNacimiento) {
        this(nombre, "", fechaNacimiento);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNombres() { return nombre; }
    public void setNombres(String nombres) { this.nombre = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
}