package com.company.DOM.Actividades.Entregable_1;

import java.util.Scanner;

public class MainDom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion = "";

        do {
            mostrarMenu();

            System.out.println("Indica un opcion: ");
            opcion = sc.nextLine();

            switch (opcion){
                case "1":
                    RecorridoDOM.numNodosHijos();
                    sc.nextLine();
                    break;
                case "2":
                    RecorridoDOM.mostrarXMLDom();
                    sc.nextLine();
                    break;
                case "3":
                    System.out.println("Indica la etiqueta: ");
                    String etiqueta = sc.nextLine();
                    RecorridoDOM.mostrarContenidoEtiqueta(etiqueta);
                    sc.nextLine();
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
            }

        }while (!opcion.equals("4"));

    }

    public static void mostrarMenu(){
        System.out.println("1. Numero de nodos hijos");
        System.out.println("2. Mostras el XML");
        System.out.println("3. Numero de nodos hijos");
        System.out.println("4. Salir");
    }
}
