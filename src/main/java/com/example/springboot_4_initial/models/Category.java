package com.example.springboot_4_initial.models;

public class Category {
    private Long id;
    private String nombre;
    private String description;
    private boolean status;

    public Category() {
    }

    public Category(Long id, String nombre, String description, boolean status) {
        this.id = id;
        this.nombre = nombre;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
