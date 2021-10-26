
package com.ceep.tiendaProductos.negocio;

public interface ICatalogoProductos {
    void agregarProducto(String nombreArchivo, String nombreProducto);
    void listarProducto(String nombreProducto);
    void buscarProducto(String nombreProducto, String buscar);
    void iniciarCatalogo(String nombreArchivo);
}
