package com.example.laboratorioFinal.model;

import java.util.Objects;

public class Element {
    private String nombre;
    private String tipo;
    private int cantidad;
    private String uso;
    private String ubicacion;
    private String estado;
    private String id;
    private int precio;

    public Element(String nombre, String tipo, int cantidad, String uso, String ubicacion, String estado, String id, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.uso = uso;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.id = id;
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element element = (Element) o;
        return getPrecio() == element.getPrecio() && getNombre().equals(element.getNombre()) && getTipo().equals(element.getTipo()) && getCantidad() ==(element.getCantidad()) && getUso().equals(element.getUso()) && getUbicacion().equals(element.getUbicacion()) && getEstado().equals(element.getEstado()) && getId().equals(element.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getTipo(), getCantidad(), getUso(), getUbicacion(), getEstado(), getId(), getPrecio());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
