
package com.ceep.tiendaProductos.negocio;

import com.ceep.tiendaProductos.datos.AccesoDatosImpl;
import com.ceep.tiendaProductos.datos.IAccesoDatos;
import com.ceep.tiendaProductos.dominio.Producto;
import com.ceep.tiendaProductos.excepciones.AccesoDatosEx;
import com.ceep.tiendaProductos.excepciones.EscrituraDatosEx;
import com.ceep.tiendaProductos.excepciones.LecturaDatosEx;
import java.util.ArrayList;
import java.util.List;



public class CatalogoProductosImpl implements ICatalogoProductos{
    private final IAccesoDatos DATOS;
    
    public CatalogoProductosImpl(){
        this.DATOS = new AccesoDatosImpl();
    }
    
    @Override
    public void agregarProducto(String nombreArchivo, String nombreProducto, int cantidad, double precio, String fechaCad) {
        try {
            if (this.DATOS.existe(nombreArchivo)){
                this.DATOS.escribir(new Producto(nombreProducto, cantidad, precio, fechaCad), nombreArchivo, true);
            }else{
                System.out.println("Catálogo no iniciado");
            }
        } catch (EscrituraDatosEx ex) {
            System.out.println("Error de lectura desde el catálogo Agregar");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarProducto(String nombreArchivo) {
        List<Producto> productoAlCat = new ArrayList<>();
        try {
            productoAlCat = this.DATOS.listar(nombreArchivo);
            productoAlCat.forEach(producto ->{
                System.out.println("producto: " 
                        + producto.getNombre()
                         + producto.getPrecio()
                          +producto.getCantidad()
                        +producto.getFechaCad());
            });
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de lectura desde catálogo productosImpl");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarProducto(String nombreArchivo, String buscar) {
        try {
            System.out.println(this.DATOS.buscar(nombreArchivo, buscar));
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogo(String nombreArchivo) {
        try {
            if(this.DATOS.existe(nombreArchivo)){
                this.DATOS.borrar(nombreArchivo);
                this.DATOS.crear(nombreArchivo);
            }else{
                this.DATOS.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al iniciar el archivo");
        }

    }
  
}
