package com.ecodeup;

import com.ecodeup.model.Juguete;
import com.ecodeup.model.TipoJuguete;
import com.ecodeup.service.Tienda;

import java.util.List;
import java.util.Scanner;

public class Consola {
    public static void main(String[] args) {
        Tienda tienda = new Tienda("Mi Tienda");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("======= MENÚ =======");
            System.out.println("1. Agregar nuevo juguete");
            System.out.println("2. Informar cantidad de juguetes por tipo");
            // Agregar más opciones del menú

            System.out.print("Seleccione una opción (0 para salir): ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del juguete: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Tipo (0: Femenino, 1: Masculino, 2: Unisex): ");
                    TipoJuguete tipo = TipoJuguete.values()[scanner.nextInt()];
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Cantidad en existencia: ");
                    int cantidad = scanner.nextInt();
                    tienda.agregarJuguete(new Juguete(nombre, tipo, precio, cantidad));
                    break;
                case 2:
                    System.out.println("Cantidad de juguetes por tipo:");
                    for (TipoJuguete tipoJuguete : TipoJuguete.values()) {
                        System.out.println(tipoJuguete + ": " + tienda.contarJuguetesPorTipo(tipoJuguete));
                    }
                    break;
                case 3:
                    System.out.println("Cantidad total de juguetes en la tienda: " + tienda.cantidadTotalJuguetes());
                    break;
                case 4:
                    System.out.println("Valor total de todos los juguetes en la tienda: $" + tienda.valorTotalJuguetes());
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del juguete para disminuir existencias: ");
                    String nombreJugueteDisminuir = scanner.nextLine();
                    System.out.print("Ingrese la cantidad para disminuir existencias: ");
                    int cantidadDisminuir = scanner.nextInt();
                    tienda.disminuirExistencias(nombreJugueteDisminuir, cantidadDisminuir);
                    break;
                case 6:
                    System.out.print("Ingrese el nombre del juguete para aumentar existencias: ");
                    String nombreJugueteAumentar = scanner.nextLine();
                    System.out.print("Ingrese la cantidad para aumentar existencias: ");
                    int cantidadAumentar = scanner.nextInt();
                    tienda.aumentarExistencias(nombreJugueteAumentar, cantidadAumentar);
                    break;
                case 7:
                    System.out.println("Tipo con más juguetes: " + tienda.tipoConMasJuguetes());
                    break;
                case 8:
                    System.out.println("Tipo con menos juguetes: " + tienda.tipoConMenosJuguetes());
                    break;
                case 9:
                    System.out.print("Ingrese el valor para filtrar los juguetes con valor mayor a: ");
                    double valorFiltro = scanner.nextDouble();
                    List<Juguete> juguetesFiltrados = tienda.obtenerJuguetesConValorMayorA(valorFiltro);
                    System.out.println("Juguetes con valor mayor a $" + valorFiltro + ":");
                    for (Juguete juguete : juguetesFiltrados) {
                        System.out.println(juguete.getNombre() + " - Precio: $" + juguete.getPrecio());
                    }
                    break;
                case 10:
                    List<Juguete> juguetesOrdenados = tienda.ordenarPorCantidadExistencias();
                    System.out.println("Juguetes ordenados por cantidad de existencias:");
                    for (Juguete juguete : juguetesOrdenados) {
                        System.out.println(juguete.getNombre() + " - Cantidad: " + juguete.getCantidad());
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}

