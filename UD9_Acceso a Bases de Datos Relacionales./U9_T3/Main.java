package U9_T3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String opcion = "";

        do {
            mostrarMenu();
            System.out.println("Indica una opcion: ");
            opcion = sc.nextLine();

            switch (opcion){
                case "1":
                    Staments.insertCustomers();
                    break;
                case "2":
                    Staments.assignEmployeeCustomer();
                    break;
                case "3":
                    Staments.addProductToOrders();
                    break;
                case "4":
                    Staments.detailsOrder();
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }

        }while (!opcion.equals("5"));

    }

    public static void mostrarMenu(){

        System.out.println("1. Insertar cliente.");
        System.out.println("2. Asignar empleado a cliente.");
        System.out.println("3. Añadir priducto a pedido.");
        System.out.println("4. Mostrar con detalle un pedido");
        System.out.println("5. Salir");
    }
}
