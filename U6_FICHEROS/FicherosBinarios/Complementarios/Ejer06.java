package com.company.FicherosBinarios.Complementarios;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/*
6. Por motivos estadisticos se desea llevar constancia del  numero de llamadas recibirdas en una oficina.
Para ello, al terminar cada jornada laboras se guarda dicho numero al final de un archivo binario.
IMplementar una app con un menú que nos permita añadir el número correspondiente cada día y
ver la lista complerta en cualquier momento.
 */
public class Ejer06 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        String[] telefonos = new String[0];

        try {
            in = new ObjectInputStream(new FileInputStream("telefonos.dat"));
            telefonos = (String[]) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (in!= null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        int opcino=0;
        do {
            mostrarmenu();
            System.out.println();
            opcino = sc.nextInt();

            switch (opcino){
                case 1:
                    System.out.println("Lista de teléfono: ");
                    System.out.println(Arrays.toString(telefonos));
                    break;

                case 2:
                    String[] auxiliar = Arrays.copyOf(telefonos, telefonos.length+1);
                    System.out.println("Escriba el telefono: ");
                    auxiliar[telefonos.length] = sc.nextLine();
                    telefonos = auxiliar;
            }

        }while (opcino!=3);

        try {
            out = new ObjectOutputStream(new FileOutputStream("telefonos.dat"));
            out.writeObject((telefonos));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void mostrarmenu(){
        System.out.println("1. MOstrar llamadas");
        System.out.println("2. Añadir llamadas");
        System.out.println("3. Salir");
        System.out.println();
        System.out.print("Elige opcion: ");
    }
}
