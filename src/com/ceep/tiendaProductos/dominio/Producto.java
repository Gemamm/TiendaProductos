
package com.ceep.tiendaProductos.dominio;




public class Producto {
    private String nombre;
    private int cantidad;
    private double precio;
    private String fechaCad;

    public Producto() {
    }
    /*public Producto() {
    this.idproducto= Producto.contadorProd++;
    }*/
    public Producto(String nombre, int cantidad, double precio, String fechaCad) {
        this();
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fechaCad = fechaCad;
    }
    public Producto(String nombre) {
        this.nombre = nombre;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCanitdad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFechaCad() {
        return fechaCad;
    }

    public void setFechaCad(String fechaCad) {
        this.fechaCad = fechaCad;
    }

    @Override
    public String toString() {
        return "Producto: "+ nombre + "\ncantidad=" + cantidad + "\nprecio=" + precio + "\nfechaCad=" + fechaCad + '}';
    }
    
    
}
