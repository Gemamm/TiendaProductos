
package com.ceep.tiendaProductos.datos;

import com.ceep.tiendaProductos.dominio.Producto;
import com.ceep.tiendaProductos.excepciones.AccesoDatosEx;
import com.ceep.tiendaProductos.excepciones.EscrituraDatosEx;
import com.ceep.tiendaProductos.excepciones.LecturaDatosEx;
import java.util.List;


public interface IAccesoDatos {
    boolean existe(String nombreArchivo);
    
    List<Producto> listar (String nombreArchivo) throws LecturaDatosEx;
    
    void escribir (Producto producto, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    
    String buscar (String nombreArchivo, String buscar) throws LecturaDatosEx;
    
    void crear (String nombreArchivo) throws AccesoDatosEx;
    
    void borrar (String nombreArchivo);
    
    
}
