
package com.ceep.tiendaProductos.negocio;



public interface ICatalogoProductos {
    void agregarProducto(String nombreArchivo, String nombreProducto, int cantidad, double precio, String fechaCad);
    void listarProducto(String nombreArchivo);
    void buscarProducto(String nombreArchivo, String buscar);
    void iniciarCatalogo(String nombreArchivo);
}
