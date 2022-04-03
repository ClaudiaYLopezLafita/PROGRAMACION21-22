package com.company.FicherosBinarios.Complementarios;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/*
1. Pedir un entero n por consola. A continuacion, pedir n numeros doubles, que iremos guardado en una tabla.
GUardar la tabla en un fichero binario.
 */
public class Ejer01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // como tenesmo que "escribir" en un fichero estamos con un Flujo de entrada
        ObjectOutputStream out = null;

        try {
            System.out.println("Cantidad de elementos en la tabla: ");
            Integer n = sc.nextInt();
            double[] tabla = new double[n];

            out = new ObjectOutputStream(new FileOutputStream("numDoubles.dat"));

            for (int i = 0; i < tabla.length; i++) {
                System.out.println("Introduce un numero double: ");
                tabla[i] = sc.nextDouble();
            }

            out.writeObject(tabla); // los Array son objetos, por lo tanto podemos guardarlas
            // con una sola sentencia y no tener que ir recorrediendo cada elemento de la misma.
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
