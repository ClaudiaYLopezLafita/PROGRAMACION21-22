package com.company.FicherosBinarios.Complementarios;

import java.io.*;
/*
3. Implementar un programa que leea todos los datos de un fichero benario y los muestre por pantalla.
 */
public class Ejer03 {
    public static void main(String[] args) {
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream("numDoubles.dat"));

            /*
            Un bucle infinito lee numeros indefinidamente hasta que al llegar al fin del fichero
            salta una excepcion que nos saca del bucle try.
             */
            try{
            while (true) {
                System.out.println(in.readDouble());
            }
            } catch (EOFException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
