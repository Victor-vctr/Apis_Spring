package com.example._Gestion_de_Tareas.model;

import java.sql.Timestamp; // ✅ CORRECTO

import com.fasterxml.jackson.annotation.JsonFormat;

public class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private boolean completado;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private Timestamp fecha_creacion;

    public Tarea() {
    }

    public Tarea(int id, String titulo, String descripcion, boolean completado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completado = completado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
