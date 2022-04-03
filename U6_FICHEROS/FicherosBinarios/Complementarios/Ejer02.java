package com.company.FicherosBinarios.Complementarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/*
Leer de un fichero binario una tabla de numeros double. Mostrar el contenido de la tabla por consola
Se usara el fichero del Ejer01
 */
public class Ejer02 {
    public static void main(String[] args) {
        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new FileInputStream("numDoubles.dat"));
            while (true){
               double[] tablas = (double[]) in.readObject();
                System.out.println(Arrays.toString(tablas));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in!= null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
