package com.company;

import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        /*
La tienda online BanderaDeEspaña.es vende banderas personalizadas de la máxima calidad y nos ha pedido
hacer un configurador que calcule el precio según el alto y el ancho. El precio base de una bandera es
de un céntimo de euro el centímetro cuadrado. Si la queremos con un escudo bordado, el precio
se incrementa en 2.50 € independientemente del tamaño. Los gastos de envío son 3.25 €.
El IVA ya está incluido en todas las tarifas.
         */
        Scanner sc = new Scanner(System.in);

        double alto, ancho;
        String escudo="";
        final double GASTO_ENVIO = 3.25;

        System.out.print("Introduce la altura de la bandera en cm:");
        alto = sc.nextInt();
        System.out.print("Ahora introduce la anchura:");
        ancho = sc.nextInt();
        sc.nextLine();
        System.out.print("¿Quieres escudo bordado? (s/n)");
        escudo = sc.nextLine();

        double area = alto*ancho;
        double precioBandera=area/100;
        double precioEscudo = 0;


        if (escudo.equals("s")){
            precioEscudo = 2.5;

            System.out.println("Gracias aqui tienes el desglose de la compra");
            System.out.println("Bandera de: "+area+" cm²: "+precioBandera+" €");
            System.out.println("Con escudo: "+": "+precioEscudo+" €");
            System.out.println("Gastos de envio: "+GASTO_ENVIO+" €");
            System.out.println("Total: "+(precioBandera+precioEscudo+GASTO_ENVIO)+" €");
        } else {
            precioEscudo =0;

            System.out.println("Gracias aqui tienes el desglose de la compra");
            System.out.println("Bandera de: "+area+" cm²: "+precioBandera+" €");
            System.out.println("Sin escudo: "+": "+precioEscudo+" €");
            System.out.println("Gastos de envio: "+GASTO_ENVIO+" €");
            System.out.println("Total: "+(precioBandera+precioEscudo+GASTO_ENVIO)+" €");
        }

    }
}
