
package com.ceep.tiendaProductos.dominio;

import java.util.Date;


public class Producto {
    private String nombre;
    private int canitdad;
    private double precio;
    private Date fechaCad;

    public Producto() {
    }

    public Producto(String nombre, int canitdad, double precio, Date fechaCad) {
        this.nombre = nombre;
        this.canitdad = canitdad;
        this.precio = precio;
        this.fechaCad = fechaCad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCanitdad() {
        return canitdad;
    }

    public void setCanitdad(int canitdad) {
        this.canitdad = canitdad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaCad() {
        return fechaCad;
    }

    public void setFechaCad(Date fechaCad) {
        this.fechaCad = fechaCad;
    }

    @Override
    public String toString() {
        return "Producto: "+ nombre + ", canitdad=" + canitdad + ", precio=" + precio + ", fechaCad=" + fechaCad + '}';
    }
    
    
}
