package com.company.FicherosTexto.Tarea1;

import java.io.*;
import java.util.Scanner;

/*
Un libro de firmas es útil para recoger todas las personas que han pasado por un determinado lugar.
Crear una aplicación que permita mostrar el libro de firmas o insertar un nuevo nombre (comprobando
que no se encuentre repetido). Llamaremos al fichero firmas.txt.
 */
public class Ejer06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean esta = false;

        System.out.println("¿Quieres leer  o escribir ?: ");
        String respuesta = sc.nextLine();

        if (respuesta.equals("leer")) {
            String texto = "";

            try {
                FileReader in = new FileReader("ficheros/firmas.txt");
                int c = in.read();
                while (c != -1) {
                    texto += (char) c;
                    c = in.read();
                }
                in.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println(texto);
        } else if (respuesta.equals("escribir")) {
            try {
                BufferedReader in = new BufferedReader(new FileReader("firmas.txt"));
                String linea = in.readLine();
                while(linea!=null) {

                    if (linea.equals(respuesta)) {
                        esta = true;
                        break;
                    }
                    linea = in.readLine();
                }
                if (esta) {
                    System.out.println(respuesta+" ya está en el libro de firmas");
                } else {
                    BufferedWriter out = new BufferedWriter(new FileWriter("firmas.txt",true));

                    out.newLine();
                    out.write(respuesta);
                    out.close();
                }
                in.close();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("NO TIENES OTRO TIPO DE PERSMISO");
        }
    }
}
