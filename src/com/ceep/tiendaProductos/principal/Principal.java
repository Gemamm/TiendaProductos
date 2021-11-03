package com.ceep.tiendaProductos.principal;

import com.ceep.tiendaProductos.negocio.CatalogoProductosImpl;
import com.ceep.tiendaProductos.negocio.ICatalogoProductos;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        var option = -1;
        var nombre = "";
        var cantidad = 0;
        var precio = 0.0;
        var fecha = "";
        var lectura = new Scanner(System.in);
        var nombreArchivo = "tienda.txt";
        ICatalogoProductos catalogo = new CatalogoProductosImpl();

        while (option != 0) {
            System.out.println("Elige una de las opciones: \n"
                    + "1.- Catalogo productos. \n"
                    + "2.- Agregar producto. \n"
                    + "3.- Listar productos. \n"
                    + "4.- Buscar producto. \n"
                    + "5.- Total precio productos. \n"
                    + "6.- Mayor precio. \n"
                    + "0.- Salir\n");
            option = Integer.parseInt(lectura.nextLine());

            switch (option) {
                case 1:
                    catalogo.iniciarCatalogo(nombreArchivo);
                    System.out.println("Catalogo inicado...");
                    break;
                case 2:
                    System.out.print("Introduce el producto:\t");
                    System.out.println("Nombre\n");
                    nombre = lectura.nextLine();
                    System.out.println("Cantidad\n");
                    cantidad = lectura.nextInt();
                    System.out.println("Precio\n");
                    precio = lectura.nextDouble();
                    System.out.println("Fecha\n");
                    fecha = lectura.next();
                    System.out.println("Se ha agregado el " + nombre + "al catalogo"
                            + nombreArchivo);
                    break;
                case 3:
                    catalogo.listarProducto(nombreArchivo);

                    break;
                    
                case 4:
                    System.out.print("Introduce el producto a buscar:\t");
                    nombre = lectura.nextLine();
                    catalogo.buscarProducto(nombreArchivo, nombre);
                    break;
                case 5:
                    catalogo.listarProducto(nombreArchivo);

                    break;
                case 6:
                    catalogo.listarProducto(nombreArchivo);

                    break;
                case 0:
                    System.out.println("Gracias!, hasta la proxima");
                    break;
                default:
                    System.out.println("Opción desconocida");

            }
        }
    }
}
