package com.company.FicherosBinarios.Ejercicios;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
Actividad 2. Abrir el archivo del ejercicio anterior, leer el double y mostrarlo por pantalla
 */
public class Ejer02 {
    public static void main(String[] args) {

        FileInputStream archivo = null;
        ObjectInputStream in = null;
        try {
            archivo = new FileInputStream("datos.dat");
            in = new ObjectInputStream(archivo);

            System.out.println((Double) in.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
