package com.company.FicherosBinarios.Complementarios.Ejer08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String opcion="";

        GestionClientes gestion = new GestionClientes();

        gestion.cargarDatos();
        do {
            System.out.println("Elija una opcion: ");
            mostrarMenu();
            opcion = sc.nextLine();

            switch (opcion){
                case "1":
                    gestion.insertarCliente();
                    break;
                case "2":
                    System.out.println("inserte el id del cliente: ");
                    int idM= sc.nextInt();
                    gestion.modificarCliente(idM);
                case "3":
                    System.out.println("inserte el id del cliente: ");
                    int id= sc.nextInt();
                    gestion.eliminarCliente(id);
                    break;
                case "4":
                    gestion.listarClientes();
                    break;
                case "5":
                    gestion.salvaDatos();
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

        }while (!opcion.equals("6"));
    }

    public static void mostrarMenu(){

        System.out.println("1. Añadir nuevo Cliente");
        System.out.println("2. Modificar datos");
        System.out.println("3. DAr de baja cliente");
        System.out.println("4. Listar clientes");
        System.out.println("5. Guardar datos");
        System.out.println("6. Salir");
    }

}
