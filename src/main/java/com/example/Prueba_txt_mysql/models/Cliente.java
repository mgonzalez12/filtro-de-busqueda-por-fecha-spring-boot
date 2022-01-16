package com.example.Prueba_txt_mysql.models;

public class Cliente {
    public Cliente() {
    }

    public Cliente(String numeroDocumento, String fechaInicio, String fechaFinal) {
        this.numeroDocumento = numeroDocumento;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    private String numeroDocumento;
    private String fechaInicio;
    private String fechaFinal;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}
