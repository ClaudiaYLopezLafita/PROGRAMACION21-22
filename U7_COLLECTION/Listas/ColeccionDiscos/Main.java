package com.company.Listas.ColeccionDiscos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestionDiscos gestion = new GestionDiscos();
        String opcion="";

        do {
            mostrarOpciones();
            System.out.println("Elige una opción: ");
            opcion = sc.nextLine();

            switch (opcion){
                case "1":
                    String opcionListado="";
                    do {
                        System.out.println("¿Como quieres listar los discos?: ");
                        mostrarOpcionListado();
                        opcionListado = sc.nextLine();

                        switch (opcionListado){
                            case "1":
                                gestion.listadoCompleto();
                                break;
                            case "2":
                                System.out.print("Introduzca el autor: ");
                                String autor = sc.nextLine();
                                gestion.listadoAutor(autor);
                            case "3":
                                System.out.print("Introduzca el autor: ");
                                String genero = sc.nextLine();
                                gestion.listadoGenero(genero);
                            case "4":
                                System.out.println("Establezca el intervalo para la duración");
                                System.out.print("Introduzca el límite inferior de duración en minutos: ");
                                int limInferior = sc.nextInt();
                                System.out.println("Introduzca el límite superior de duración en minutos: ");
                                int limSuperior=sc.nextInt();
                                gestion.listadoDuracion(limSuperior, limInferior);
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                    }while (!opcionListado.equals("5"));
                case "2":
                    gestion.addDisco();
                    break;
                case "3":
                    gestion.modificarDisco();
                    break;
                case "4":
                    System.out.print("Por favor, introduzca el código del disco que desea borrar: ");
                    String codigo = sc.nextLine();
                    gestion.borrarDisco(codigo);
                default:
                    System.out.println("Opcion incorrecta.");
            }

        }while (!opcion.equals("5"));
    }
    public static void mostrarOpciones(){
        System.out.println("1. Listar Discos");
        System.out.println("2. Añadir Disco");
        System.out.println("3. Modificar Disco");
        System.out.println("4. Borrar Disco");
        System.out.println("5. Salir");
    }

    public static void mostrarOpcionListado(){
        System.out.println("1. Completo");
        System.out.println("2. Por autor");
        System.out.println("3. Por género");
        System.out.println("4. En un rango de duración");
        System.out.println("5. Menú principal");
        System.out.print("Introduzca una opción: ");
    }
}
