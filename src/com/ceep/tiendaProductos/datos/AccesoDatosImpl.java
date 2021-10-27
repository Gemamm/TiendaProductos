
package com.ceep.tiendaProductos.datos;

import com.ceep.tiendaProductos.dominio.Producto;
import com.ceep.tiendaProductos.excepciones.AccesoDatosEx;
import com.ceep.tiendaProductos.excepciones.EscrituraDatosEx;
import com.ceep.tiendaProductos.excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        //Archivo
        File archivo = new File(nombreArchivo);
        //Creo un arraylist con los productos
        List<Producto> productos = new ArrayList<>(); //almacena productos
        String[] producto = new String[4];

        try {
            //Declaro variable para entrar al archivo
            BufferedReader entrada = new BufferedReader(new FileReader(archivo)); //Para que no se sobreescriba
            String lectura = entrada.readLine(); // lectura = nombre;cantidad;precio;fecha

            //Hasta que se acaben las lineas con productos
            while (lectura != null) {
                producto = lectura.split(";"); // producto = {nombre, cantidad, precio, fecha}
                
                 var nombre= producto[0];
                var precio= Double.parseDouble(producto[1]);
                var cantidad= Integer.parseInt(producto[2]);
                var fecha= producto[3];
                productos.add(new Producto (nombre, cantidad, precio, fecha)); //Se van añadiendo al array los productos
                lectura = entrada.readLine();//Pasa de linea
            }
            entrada.close();//Cierra
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los productos");
        }
        return productos;
    }
    
    @Override
    public void escribir(Producto producto, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File (nombreArchivo);
        try {
            
            var escribir = new PrintWriter (new FileWriter(archivo));
            escribir.println(producto.getNombre()+";"
                    +producto.getCantidad()+";"
                    +producto.getPrecio()+";"
                    +producto.getFechaCad());
            escribir.close();
        } catch (IOException e) {
           e.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al escribir el archivo");
            
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        String mensaje = "";
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            int cont = 1;
            while (lectura != null) {
                if (!lectura.equalsIgnoreCase(buscar)) {
                    mensaje = "\nEl producto: " + buscar + ", está en la línea " + cont;
                    break;
                }

                lectura = entrada.readLine();
                cont++;
            }
            if (lectura == null) {
                mensaje = "El producto" + buscar + "no esta"
                        + "en el catalogo";
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los productos");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los productos");
        }
        return mensaje;
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
        if (archivo.exists()){
            archivo.delete();
        }
        System.out.println("Se ha borrado el archivo");
    }

    
    
}
