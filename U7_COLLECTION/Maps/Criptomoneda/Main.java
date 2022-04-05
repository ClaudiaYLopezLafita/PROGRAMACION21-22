package com.company.Maps.Criptomoneda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionCambio gestion = new GestionCambio();
        String opcion ="";
        do {
            mostrasOpciones();
            System.out.println("Elige una opcion: ");
            opcion = sc.nextLine();

            switch (opcion){
                case "1":
                    ParCotizacion c = crearParCotizacion();
                    gestion.addCotizacion(c);
                    break;
                case "2":
                    System.out.println("Indique el simbolo: ");
                    String simbolo = sc.nextLine();
                    gestion.obtenerCotizaciones(simbolo);
                    break;
                case "3":
                    gestion.mostrarDivisasOrdenadas();
                    break;
                case "4":
                    gestion.mostrarCotizacionesAlAlzaUnaHora();
                    break;
                case "5":
                    gestion.borrar();
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

        }while (!opcion.equals("6"));

    }

    public static void mostrasOpciones(){
        System.out.println("1. Añadir cotizacion");
        System.out.println("2. Obtener cotizaciones");
        System.out.println("3. MOstras Divisas ordenadas");
        System.out.println("4. Mostras Cotiazacion al alza");
        System.out.println("5. Borrar cotizacion");
        System.out.println("6. Salir");
    }

    public static ParCotizacion crearParCotizacion(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Indique la divisa");
        Divisa divisa = null;
        System.out.println("Indique la D cotizada");
        Divisa cotizada=null;
        System.out.println("Indique el precio");
        Double precio= sc.nextDouble();
        System.out.println("Indique la variacion");
        Double variacion= sc.nextDouble();

        return new ParCotizacion(divisa,cotizada, precio,variacion);
    }
}
