
package com.ceep.tiendaProductos.datos;

import com.ceep.tiendaProductos.dominio.Producto;
import com.ceep.tiendaProductos.excepciones.AccesoDatosEx;
import com.ceep.tiendaProductos.excepciones.EscrituraDatosEx;
import com.ceep.tiendaProductos.excepciones.LecturaDatosEx;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccesoDatosImpl implements IAccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) {
        var archivo = new File (nombreArchivo);
        return true;
    }

    @Override
    public List<Producto> listar(String nombreArchivo) throws LecturaDatosEx {
        var archivo = new File (nombreArchivo);
        return null;
    }

    @Override
    public void escribir(Producto producto, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File (nombreArchivo);
        try {
            
            var escribir = new PrintWriter (new PrintWriter(archivo));
            escribir.close();
        } catch (IOException e) {
           e.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al escribir el archivo");
            
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        var archivo = new File (nombreArchivo);
        return null;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        var archivo = new File (nombreArchivo);
        try {
            var escribir = new PrintWriter (new PrintWriter(nombreArchivo));
            escribir.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al crear el archivo");
        }
        
    }

    @Override
    public void borrar(String nombreArchivo) {
        var archivo = new File (nombreArchivo);
    }
    
}
